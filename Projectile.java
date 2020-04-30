package javagame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.*;

public class Projectile {
	private Vector2f pos;
	private Vector2f speed;
	private int lived = 0;
	private boolean active = true;
	
	private static int MAX_LIFETIME = 2000;
	
	public  Projectile( Vector2f pos, Vector2f speed)
	{
		this.pos = pos;
		this.speed = speed;
		
	}
	public void update (int t)
	{
		if (active)
		{
			Vector2f realSpeed = speed.copy();
			realSpeed.scale((t/1000));
			pos.add(realSpeed);
			
			lived += t;
			if (lived > MAX_LIFETIME) active = false;
			}
		}
	public void render (GameContainer gc,Graphics g) throws SlickException
	{
		g.setColor(Color.blue);
		g.fillOval(pos.getX()-10, pos.getY()-10, 10, 10);
		
	}
	
	
}

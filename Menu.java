package javagame;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState
{
	Image playNow;
	Image exitGame;
	public String mouse = "All clear on the western front."; 
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		playNow = new Image("res/playNow.png");
		exitGame = new Image ("res/exitGame.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawString("Welcome to something...", 100, 50);
		playNow.draw(50,100);
		exitGame.draw(200,350);
		g.drawString(mouse, 100, 25);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse xpos:" + posX + " ypos:" + posY;
		
		//play button
		if((posX>120 && posX<400)&&(posY>200  && posY<260)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		//exit button
		if((posX>200 && posX<260)&&(posY>90&& posY<145)) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			sbg.enterState(1);
		}
	}
	
	public int getID() {
		return 0;
	}
}

package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;
import org.newdawn.slick.GameContainer;
	public class Play extends BasicGameState{

		Animation heroic, movingUp, movingDown, movingLeft, movingRight;
		Image worldMap;
		boolean quit = false;
		int[] duration = {200,200};
		float heroicPosX = 0;
		float heroicPosY = 0;
		float shiftX = heroicPosX + 320;
		float shiftY = heroicPosY + 160;
		Projectile b;
		
		public Play(int state) {
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			worldMap = new Image("res/Mapthing.png");
			Image[] walkUp = {new Image("res/tile009.png"), new Image("res/tile011.png")};
			Image[] walkDown = {new Image("res/tile001.png"), new Image("res/tile003.png")};
			Image[] walkLeft = {new Image("res/tile013.png"), new Image("res/tile015.png")};
			Image[] walkRight = {new Image("res/tile005.png"), new Image("res/tile007.png")};
		
			movingUp = new Animation(walkUp, duration, false);
			movingDown = new Animation(walkDown, duration, false);
			movingLeft = new Animation(walkLeft, duration, false);
			movingRight = new Animation(walkRight, duration, false);
			heroic = movingDown;
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
			worldMap.draw(heroicPosX,heroicPosY);
			heroic.draw(shiftX,shiftY);
			g.drawString("heroic X:" + heroicPosX +"/n heroic Y:" +heroicPosY, 200, 20);
			
			if (quit == true) {
				g.drawString("Resume(r)", 250, 100);
				g.drawString("Main Menu(m)",250, 150);
				g.drawString("Quit game(q)", 250, 200);
				if(quit == false) {
					g.clear();
				}
			}
			b.render( gc,g);
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			Input input = gc.getInput();
			// up
			if(input.isKeyDown(Input.KEY_UP)) {
				heroic = movingUp;
				heroicPosY += delta * .1f;
				if(heroicPosY>168) {
					heroicPosY -= delta * .1f;
				}
			}
			//down
			if(input.isKeyDown(Input.KEY_DOWN)) {
				heroic = movingDown;
				heroicPosY -= delta * .1f;
				if(heroicPosY<-292) {
					heroicPosY += delta * .1f;
				}
			}
			//left
			if(input.isKeyDown(Input.KEY_LEFT)) {
				heroic = movingLeft;
				heroicPosX += delta * .1f;
				if(heroicPosX>322) {
					heroicPosX -= delta * .1f;
				}
			}
			//right
			if(input.isKeyDown(Input.KEY_RIGHT)) {
				heroic = movingRight;
				heroicPosX -= delta * .1f;
				if(heroicPosX<-145) {
					heroicPosX += delta * .1f;
				}
			}
			//uppermost boundary is 168
			//lowermost boundary is -292
			//rightmost boundary is -145
			//leftmost boundary is 322
			
			//escape
			if(input.isKeyDown(Input.KEY_ESCAPE)) {
				quit = true;
			}
			//when menu is up
			if(quit ==true) {
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
			
			}
			if (input.isKeyDown(Input.KEY_SPACE ))
			{
				Projectile b = new Projectile(new Vector2f(heroicPosX), new Vector2f(heroicPosY));
				
				b.update(5);
			}
		}
		
		public int getID() {
			return 1;
		}
	}
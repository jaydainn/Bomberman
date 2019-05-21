import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Personnage {
	private int x , y ;
	private Image pers ; 

	public Personnage() throws SlickException {
		pers = new Image("images/bomberman.png");
		x = 1 ; 
		y = 1;
		
	}
	
	public void gauche(grille g ) {
		if(g.typecase(x-1,y ) == 0) {
			this.x = x-1;
		}
		
	}
	public void droite(grille g ) {
		if(g.typecase(x+1, y) == 0) {
			this.x = x+1;
		}
		
	}
	public void haut(grille g ) {
		if(g.typecase(x, y-1) == 0) {
			this.y = y-1;
		}
		
	}
	public void bas(grille g ) {
		if(g.typecase(x, y+1) == 0) {
			this.y = y+1;
		}
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(pers, x*30, y*30);
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

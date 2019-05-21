import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class bombe {
	private int x ,y ;
	private Image bombe;
	private int temps;

	public bombe(int x , int y) throws SlickException {
		bombe = new Image("images/bombe.png");
		this.x = x;
		this.y = y;
		
		
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(bombe, x*30, y*30);
		
	}
	
	public boolean doitExploser(int delta) {
		temps+= delta;
		if(temps > 2000) {
			return true ;
		}
		return false;
	}
	
	public void exploser(grille g) {
		if(g.typecase(x+1, y) == 1) {
			g.setexplose(y, x+1);
		}
		if(g.typecase(x-1, y) == 1) {
			g.setexplose(y, x-1);
		}
		if(g.typecase(x, y+1) == 1) {
			g.setexplose(y+1, x);
		}
		if(g.typecase(x, y-1) == 1) {
			g.setexplose(y-1, x);
		}
		
	}
	
	public boolean exPerso(Personnage p ) {
		if(Math.sqrt(Math.pow(p.getX()-this.x, 2)+Math.pow(p.getY()-this.y, 2))<=1) {
			return true;
		}
		return false;
	}
	
	

}

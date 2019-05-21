import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GO {
	 private Image go ; 

	public GO() throws SlickException {
		go = new Image("images/go.png");
		
	}
	
	public void draw(Graphics g) {
		g.drawRect(0, 0, 570, 390);
		g.drawImage(go, 0, 0);
		
	}
	
	

}

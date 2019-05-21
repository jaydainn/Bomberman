import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class grille {
	private int grille[][] = new int[13][19];
	private Image image_vide, image_obstacle_1, image_obstacle_2;

	public grille() throws SlickException {
		image_vide = new Image("images/vide.png");
		image_obstacle_1 = new Image("images/obstacle_destructible.png");
		image_obstacle_2 = new Image("images/obstacle_indestructible.png");

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 13; j++) {
				if ((int) (Math.random() * 100) < 50) {
					grille[j][i] = 1;
				}
				
				switch (j) {
				case 0:
					grille[j][i] = 2;
					break;
				case 12:
					grille[j][i] = 2;
				}
				switch (i) {
				case 0:
					grille[j][i] = 2;
					break;
				case 18:
					grille[j][i] = 2;
					break;
				}
				if ((i % 2 == 0 )&& (j % 2 == 0)) {
					grille[j][i] = 2;
				}
				

			}
		}
		grille[1][1] = 0;
		grille[1][2] = 0;
		grille[2][1] = 0;
		grille[10][17] = 0;
		grille[11][17] = 0;
		grille[11][16] = 0;

	}
	
	public void setexplose(int x ,int y) {
		this.grille[x][y] = 0;
	}

	public void draw(Graphics g) {
		for(int i = 0 ; i < 19;i++) {
			for(int j = 0; j< 13;j++) {
				switch(grille[j][i]) {
				case 0: g.drawImage(image_vide, i*30, j*30);
				break;
				case 1: g.drawImage(image_obstacle_1, i*30, j*30);
				break;
				case 2: g.drawImage(image_obstacle_2, i*30, j*30);
				break;
				}
			}
		}
		
	}
	
	public int typecase(int x, int y) {
		return grille[y][x];
	}

}

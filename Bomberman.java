import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bomberman extends BasicGame {
	private grille test;
	private Personnage p;
	private ArrayList<bombe> bombes = new ArrayList<bombe>();
	private GO go;
	private boolean game_over = false;

	public Bomberman(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		test.draw(g);
		for (int i = 0; i < bombes.size(); i++) {
			bombes.get(i).draw(g);
		}
		p.draw(g);
		if (game_over) {
			go.draw(g);
		}

	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		test = new grille();
		p = new Personnage();
		go = new GO();

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		for (int i = 0; i < bombes.size(); i++) {
			if (bombes.get(i).doitExploser(delta)) {
				if (bombes.get(i).exPerso(p) && bombes.get(i).doitExploser(delta)) {
					game_over = true;

				}
				bombes.get(i).exploser(test);
				bombes.remove(bombes.get(i));
				break;

			}

		}

	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Bomberman("Bomberman"));
		app.setShowFPS(false);
		app.setDisplayMode(570, 390, false);
		app.start();
	}

	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		switch (key) {
		case Input.KEY_LEFT:
			p.gauche(test);
			break;
		case Input.KEY_RIGHT:
			p.droite(test);
			break;
		case Input.KEY_UP:
			p.haut(test);
			break;
		case Input.KEY_DOWN:
			p.bas(test);
			break;
		case Input.KEY_SPACE:
			try {
				bombes.add(new bombe(p.getX(), p.getY()));
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

}

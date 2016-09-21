package Menu;
import javax.swing.JMenuBar;

import Fenetre.Fenetre;


public class BarreDeMenu extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	public BarreDeMenu(Fenetre fenetre) {
		super();
		add(new MenuFichier(fenetre));
	}
}

package Menu;
import javax.swing.JMenu;

import Fenetre.Fenetre;


public class MenuFichier extends JMenu{
	private static final long serialVersionUID = 1L;

	public MenuFichier(Fenetre fenetre) {
		super("Fichier");
		add(new MenuDifficulte(fenetre));
	}
}

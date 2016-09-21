package Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Fenetre.Fenetre;


public class MenuDifficulte extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	
	public MenuDifficulte(Fenetre fenetre) {
		super("Difficulté");
		this.fenetre = fenetre;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		fenetre.ouvrirFenetreDifficulte();
	}
}

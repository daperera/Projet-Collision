package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Fenetre.Fenetre;

public class MenuReset extends JMenuItem implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	
	public MenuReset(Fenetre fenetre) {
		super("Réinitialiser (F5)");
		this.fenetre = fenetre;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		fenetre.reset();
	}
}

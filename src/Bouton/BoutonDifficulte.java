package Bouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import Fenetre.Fenetre;
import Type.TypeDifficulte;


public class BoutonDifficulte extends JRadioButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private final TypeDifficulte difficulte;
	
	public BoutonDifficulte(Fenetre fenetre, TypeDifficulte difficulte) {
		super();
		this.fenetre = fenetre;
		this.difficulte = difficulte;
		setVisible(true);
		switch(difficulte) {
			case FACILE:
				setText("facile");
				break;
			case NORMAL:
				setText("normal");
				setSelected(true);
				break;
			case DIFFICILE:
				setText("difficile");
				break;
		}
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		fenetre.setDifficulte(difficulte);
	}

}

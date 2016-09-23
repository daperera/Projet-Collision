package Panneau;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Bouton.BoutonGenerique;
import Fenetre.Fenetre;
import Type.TypeBouton;


public class PanneauBoutonOk extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanneauBoutonOk(Fenetre fenetre, FenetreDifficulte fenetreDifficulte) {
		super();
		setVisible(true);
		setPreferredSize(new Dimension(fenetreDifficulte.getLargeur()/3, fenetreDifficulte.getHauteur()/3));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		add(new BoutonGenerique(fenetre, TypeBouton.OK), c);
	}

}

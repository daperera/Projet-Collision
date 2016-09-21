package Panneau;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import Bouton.BoutonDifficulte;
import Fenetre.Fenetre;
import Type.TypeDifficulte;


public class PanneauBoutonDifficulte extends JPanel{
	private static final long serialVersionUID = 1L;
	private final BoutonDifficulte boutonFacile;
	private final BoutonDifficulte boutonNormal;
	private final BoutonDifficulte boutonDifficile;
	
	public PanneauBoutonDifficulte(Fenetre fenetre, FenetreDifficulte fenetreDifficulte) {
		super();
		setVisible(true);
		setPreferredSize(new Dimension(fenetreDifficulte.getLargeur()*2/3, fenetreDifficulte.getHauteur()*2/3));
		//setBackground(new Color(206,206,255));
		setLayout(new GridLayout(1,3));
		add(boutonFacile = new BoutonDifficulte(fenetre, TypeDifficulte.FACILE));
		add(boutonNormal = new BoutonDifficulte(fenetre, TypeDifficulte.NORMAL));
		add(boutonDifficile = new BoutonDifficulte(fenetre, TypeDifficulte.DIFFICILE));
		ButtonGroup bG = new ButtonGroup();
	    bG.add(boutonFacile);
	    bG.add(boutonNormal);
	    bG.add(boutonDifficile);
	}
	
}

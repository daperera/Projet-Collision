package Panneau;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import Fenetre.Fenetre;



public class FenetreDifficulte extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	private final int largeur = 275;
	private final int hauteur = 200;
	

	
	public FenetreDifficulte(Fenetre fenetre) {
		super();
		setVisible(false);
		setBounds(fenetre.getWidth()/2-largeur/2, fenetre.getHeight()/2 - hauteur/2, largeur, hauteur);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new BorderLayout());
		add(new PanneauBoutonDifficulte(fenetre, this), BorderLayout.NORTH);
		add(new PanneauBoutonOk(fenetre, this), BorderLayout.SOUTH);
	    		
		
	}
	public int getLargeur() {
		return largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	
	
}

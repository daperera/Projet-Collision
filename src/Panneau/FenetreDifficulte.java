package Panneau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import Fenetre.Fenetre;



public class FenetreDifficulte extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	
	private final int largeur = 270; 
	private final int hauteur = 150; 
	

	
	public FenetreDifficulte(Fenetre fenetre) {
		super();
		setVisible(false);
		setBounds(fenetre.getWidth()/2-largeur/2, fenetre.getHeight()/2 - hauteur/2, largeur, hauteur);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new BorderLayout());
		add(new PanneauBoutonDifficulte(fenetre, this), BorderLayout.NORTH);
		add(new PanneauBoutonOk(fenetre, this), BorderLayout.SOUTH);
	    addMouseListener(this);		
	}
	public int getLargeur() {
		return largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void mouseExited(MouseEvent e) {
		e.consume();
	}
	public void mousePressed(MouseEvent e) {
		e.consume();
	}
	public void mouseReleased(MouseEvent e) {
		e.consume();
	}
	public void mouseClicked(MouseEvent e) {
		e.consume();
	}
	public void mouseEntered(MouseEvent e) {
		e.consume();
	}

	
	
}

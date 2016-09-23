package Panneau;
import javax.swing.*;

import Fenetre.Fenetre;
import Type.TypeBouton;

import java.awt.*;

public class WindowPanel extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private final PanneauAnimation panneauAnimation;
	private final PanneauHorloge panneauHorloge;
	private final FenetrePopup fenetreCommencer;
	private final FenetrePopup fenetrePause;
	private final FenetrePopup fenetreEchec;
	private final FenetreDifficulte fenetreDifficulte;
	
	
	
	public WindowPanel(Fenetre fenetre) {
		super();
		setVisible(true);
		setPreferredSize(new Dimension((int) fenetre.getSize().getWidth(), (int) fenetre.getSize().getHeight()));	
		add(panneauHorloge = new PanneauHorloge(fenetre), new Integer(1), 0);
		add(panneauAnimation = new PanneauAnimation(fenetre), new Integer(1), 0);
		add(fenetreCommencer = new FenetrePopup(fenetre, TypeBouton.COMMENCER), new Integer(0), 0);
		add(fenetrePause = new FenetrePopup(fenetre, TypeBouton.REPRENDRE), new Integer(0), 0);
		add(fenetreEchec = new FenetrePopup(fenetre, TypeBouton.RECOMMENCER), new Integer(0), 0);
		add(fenetreDifficulte = new FenetreDifficulte(fenetre), new Integer(0), 0);
	}
	public void afficherFenetreCommencer() {
		fenetreCommencer.setVisible(true);
		setLayer(fenetreCommencer, new Integer(2), 0);
	}
	public void afficherFenetrePause() {
		fenetrePause.setVisible(true);
		setLayer(fenetrePause, new Integer(2), 0);
	}
	public void afficherFenetreEchec() {
		fenetreEchec.setVisible(true);
		fenetreEchec.actualiserBouton();
		panneauHorloge.colorier();
		setLayer(fenetreEchec, new Integer(2), 0);
	}
	public void afficherFenetreDifficulte() {
		fenetreDifficulte.setVisible(true);
		setLayer(fenetreDifficulte, new Integer(2), 0);
	}
	public void fermerFenetre() {
		if (getLayer(fenetreCommencer) == new Integer(2)){
			fenetreCommencer.setVisible(false);
			setLayer(fenetreCommencer, new Integer(0), 0);
		}
		if (getLayer(fenetrePause) == new Integer(2)) {
			fenetrePause.setVisible(false);
			setLayer(fenetrePause, new Integer(0), 0);
		}
		else {
			fenetreEchec.setVisible(false);
			panneauHorloge.normal();
			setLayer(fenetreEchec, new Integer(0), 0);
		}
	}
	public void fermerFenetreDifficulte() {
		fenetreDifficulte.setVisible(false);
		setLayer(fenetrePause, new Integer(0), 0);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void focusPanneauAnimation() {
		panneauAnimation.requestFocus();
	}
	public void actualiserHorloge() {
		panneauHorloge.actualiser();
	}
}

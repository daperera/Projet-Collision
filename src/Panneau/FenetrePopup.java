package Panneau;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import Type.TypeBouton;
import Bouton.BoutonGenerique;
import Fenetre.Fenetre;

public class FenetrePopup extends JPanel{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private final BoutonGenerique bouton;
	
	public FenetrePopup(Fenetre fenetre, TypeBouton type) {
		super();
		this.fenetre = fenetre;
		//setPreferredSize(new Dimension(fenetre.getWidth(), fenetre.getHeight()));
		setBounds(0, fenetre.getHauteurHorloge(), fenetre.getWidth(), fenetre.getHeight());
		//setBackground(Color.black);
		setOpaque(false);
		switch(type) {
			case COMMENCER:
				setVisible(true);
				break;
			case RECOMMENCER:
			case REPRENDRE:
				setVisible(false);
				break;
			default :
				break;
		}
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		add(bouton = new BoutonGenerique(fenetre, type), c);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(255,255,255, 200));
		g.fillRect(0, 0, fenetre.getWidth(), fenetre.getHeight());
	}
	public void actualiserBouton() {
		bouton.actualiser();
	}

}

package Panneau;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fenetre.Fenetre;




public class PanneauHorloge extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private int hauteur;
	private int largeur;
	private JLabel chrono;
	
	public PanneauHorloge(Fenetre fenetre) {
		super();
		this.fenetre = fenetre;
		hauteur = fenetre.getHauteurHorloge();
		largeur = (int)fenetre.getSize().getWidth();
		setBounds(0, 0, largeur, hauteur);
		setVisible(true);
		setBackground(new Color(206,206,255));
		setBorder(BorderFactory.createLineBorder(Color.black));
		chrono = new JLabel("0:0:0");
		this.add(chrono);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(fenetre.isContinuer()) {
			chrono.setText(fenetre.getTemps().toString());
		}
	}
	public void colorier() {
		chrono.setForeground(Color.red);	
	}
public void normal() {
	chrono.setForeground(Color.black);
	}
	
}

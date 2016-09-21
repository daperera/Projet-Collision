package Panneau;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import utile.Boules;
import utile.Point;
import Fenetre.Fenetre;

public class PanneauAnimation extends JPanel implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private final Boules boules;
	private int hauteur;
	private int largeur;
	
	public PanneauAnimation(Fenetre fenetre) {
		super();
		this.fenetre = fenetre;
		addMouseListener(this);
		addMouseMotionListener(this);
		boules = fenetre.getBoules();
		hauteur  = (int) fenetre.getSize().getHeight() - fenetre.getHauteurHorloge();
		largeur = (int) fenetre.getSize().getWidth();
		//setPreferredSize(new Dimension(largeur, hauteur));
		setBounds(0, fenetre.getHauteurHorloge(), largeur, hauteur);
		setVisible(true);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		fenetre.pause();
	}
	public void mouseClicked(MouseEvent e) {
	
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		fenetre.setCurseur(new Point(e.getX(), e.getY()));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(234,234,255));
		g.fillRect(0, 0, largeur, hauteur);
		boules.paint(g);
	}
}

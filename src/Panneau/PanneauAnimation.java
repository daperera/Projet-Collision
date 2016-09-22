package Panneau;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import utile.Boules;
import utile.Fleche;
import utile.Point;
import utile.Vecteur;
import Fenetre.Fenetre;

public class PanneauAnimation extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private final Boules boules;
	private Fleche fleche = new Fleche();
	private int hauteur;
	private int largeur;
	private int curseurX = 0;
	private int curseurY = 0;
	private final int rayon;
	private int bouleSelectionnee;
	private boolean modeVitesse = false;
	
	
	
	public PanneauAnimation(Fenetre fenetre) {
		super();
		this.fenetre = fenetre;
		this.setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		boules = fenetre.getBoules();
		hauteur  = (int) fenetre.getSize().getHeight() - fenetre.getHauteurHorloge();
		largeur = (int) fenetre.getSize().getWidth();
		rayon = fenetre.getRayonBoules();
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
		if(fenetre.isModePlacement()) {
			switch(e.getButton()) {
				case MouseEvent.BUTTON1:
					if(modeVitesse){
						Vecteur v = fleche.getVecteur();
						v.product((float) 0.05);
						boules.setVitesse(v, bouleSelectionnee);
						modeVitesse = false;
					}
					else {
						bouleSelectionnee = boules.getNbBoules();
						boules.add(curseurX,curseurY);
						fleche.setOrigine(curseurX, curseurY);
						modeVitesse = true;
					}
					break;
				case MouseEvent.BUTTON2:
					System.out.println("bouton 2");
					break;
				default:
					
					break;
			}
			
		}
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		Point curseur = new Point(e.getX(), e.getY());
		fenetre.setCurseur(curseur);
		curseurX = e.getX();
		curseurY = e.getY();
		if (modeVitesse) {
			fleche.setExtremite(curseur);
			fleche.actualiser();
		}
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(234,234,255));
		g.fillRect(0, 0, largeur, hauteur);
		boules.paint(g);
		if(fenetre.isModePlacement()) {
			if(modeVitesse) {
				g.setColor(Color.red);
				fleche.paintComponent(g);
			}
			else {
				g.setColor(Color.black);
				g.fillOval((int) (curseurX - rayon),
						(int) (curseurY - rayon), 
						(int) (2*rayon), 
						(int) (2*rayon));
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		if(fenetre.isModePlacement()) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.out.println("echap pressée");
				fenetre.quitterModePlacement();
			default:
				
				break;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}

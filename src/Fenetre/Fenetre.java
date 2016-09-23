package Fenetre;

import javax.swing.JFrame;
import utile.Boules;
import utile.Point;
import utile.Temps;
import Menu.BarreDeMenu;
import Panneau.WindowPanel;
import Type.TypeDifficulte;


public final class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private final Boules boules;
	private final WindowPanel windowPanel;
	private final Temps temps;
	private Point curseur;
	private boolean echec;
	private boolean continuer;
	private boolean premiereFois;
	private final BarreDeMenu barreDeMenu;
	private boolean pauseActive = false;
	private boolean modePlacement = false;
	private TypeDifficulte difficulte = TypeDifficulte.NORMAL;
	public final int nbBoulesMax = 30;
	public final int largeurEcran = 400;
	public final int hauteurEcran = 600;
	public final int hauteurHorloge = 30;
	public final int rayonBoules = 30;
	private int nbBoules = 6;
	private float vitesseMax = 1;
	private float vitesseMin = 3;
	


	
	public Fenetre() {
		super();
		setTitle("ScratchPad01");
	    setSize(largeurEcran, hauteurEcran);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setVisible(true);
	    curseur = new Point();
	    echec = false;
	    continuer = false;
	    premiereFois = true;
	    temps = new Temps(true);
	    boules = new Boules(nbBoules, nbBoulesMax, rayonBoules, vitesseMax, vitesseMin, this);
	    windowPanel = new WindowPanel(this);
	    setContentPane(windowPanel);
	    barreDeMenu = new BarreDeMenu(this);
	    setJMenuBar(barreDeMenu);
	    windowPanel.afficherFenetreCommencer();
	    pack();
	    animation();
	}
	public boolean isContinuer() {
		return continuer;
	}
	public int getHauteurHorloge() {
		return hauteurHorloge;
	}
	/*public void setHauteurHorloge(int hauteurHorloge) {
		this.hauteurHorloge = hauteurHorloge;
	}*/
	public Temps getTemps() {
		return temps;
	}
	public WindowPanel getWindowPanel() {
		return windowPanel;
	}
	public Point getCurseur() {
		return curseur;
	}
	public void setCurseur(Point curseur) {
		this.curseur = curseur;
	}
	public Boules getBoules() {
		return boules;
	}
	public TypeDifficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(TypeDifficulte difficulte) {
		this.difficulte = difficulte;
		switch(difficulte) {
			case FACILE:
				boules.setNbBoules(4);
				boules.setVitesseMin((float) 1);
				boules.setVitesseMax((float) 3);
				break;
			case NORMAL:
				boules.setNbBoules(6);
				boules.setVitesseMin(1);
				boules.setVitesseMax(3);
				break;
			case DIFFICILE:
				boules.setNbBoules(8);
				boules.setVitesseMin(2);
				boules.setVitesseMax(3);
				break;
			case PERSONNALISEE: // mode de placement des boules
				modePlacement = true;
				break;
			default:
				break;
		}
	}
	public boolean isModePlacement() {
		return modePlacement;
	}
	public void setModePlacement(boolean modePlacement) {
		this.modePlacement = modePlacement;
	}
	public void animation() {
		while(true) {
			if(continuer) {
				boules.gererCollisions();
				boules.deplacer();
				windowPanel.repaint();
				if(boules.testerContact(curseur)) {
					echec = true;
					if (difficulte != TypeDifficulte.PERSONNALISEE) {
						boules.initialiserBoules();
					}
					pause();
				}
			}
			try {
		        Thread.sleep(10);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
			
		}
	}
	public void pause() {
		if (!premiereFois && !pauseActive) {
			temps.pause();
			continuer = false;
			if (echec) {
				windowPanel.afficherFenetreEchec();
				echec = false;
			}
			else {
				windowPanel.afficherFenetrePause();
			}
			pauseActive = true;
		}
	}
	public void resume() {
		if(!modePlacement) {
			temps.resume();
			continuer = true;
		}
		if (premiereFois) {
			premiereFois = false;
		}
		windowPanel.fermerFenetre();
		pauseActive = false;
	}
	public boolean isEchec() { //methode inutilisee
		return echec;
	}
	public void reinitialiser() {
		temps.reinitialiser(false);
		echec = false;
	}
	public void ouvrirFenetreDifficulte() {
		windowPanel.afficherFenetreDifficulte();
	}
	public void fermerFenetreDifficulte() {
		windowPanel.fermerFenetreDifficulte();
		boules.initialiserBoules();
		echec = false;
		pauseActive = false;
		if (modePlacement) {
			continuer = false;
			boules.setNbBoules(0);
			temps.reinitialiser(true);
			windowPanel.actualiserHorloge();
			windowPanel.fermerFenetre();
			windowPanel.focusPanneauAnimation();
			pauseActive = true;
		}
		else {
			windowPanel.fermerFenetre();
			premiereFois = true;
			windowPanel.afficherFenetreCommencer();
		}
		
	}
	public int getRayonBoules() {
		return rayonBoules;
	}
	public void quitterModePlacement() {
		pauseActive = false;
		modePlacement = false;
		premiereFois = true;
		windowPanel.afficherFenetreCommencer();
	}
	public void reset() {
		boules.setNbBoules(0);
	}
}

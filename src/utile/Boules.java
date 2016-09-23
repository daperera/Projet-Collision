package utile;
import java.awt.*;

import Fenetre.Fenetre;

public class Boules {
	private Boule[] boules;
	private int nbBoules;
	private int rayon;
	private int largeurEcran;
	private int hauteurEcran;
	private float vitesseMax;
	private float vitesseMin;
	
	public Boules(int nbBoules, int nbBoulesMax, int rayonBoules, float vitesseMin, float vitesseMax, Fenetre fenetre) {
		boules = new Boule[nbBoulesMax];
		this.nbBoules = nbBoules;
		this.rayon = rayonBoules;
		this.vitesseMin = vitesseMin;
		this.vitesseMax = vitesseMax;
		this.largeurEcran = fenetre.getWidth();
		this.hauteurEcran = fenetre.getHeight() - fenetre.getHauteurHorloge();
		initialiserBoules();
	}
	
	private void placerBoule(int i) {
		boules[i] = new Boule();
		boules[i].setRayon(rayon);
		do {
			float x = (int) (Math.random()*(largeurEcran-2*rayon) + rayon);
			float y = (int) (Math.random()*(hauteurEcran-2*rayon) + rayon);
			boules[i].setPosition(x, y);
		} while(testerCollisionAvecBoule(i)[0] != 0);
	}
	public void initialiserBoules() {
		for (int i=0; i<nbBoules; i++) {
			placerBoule(i);
			float x = (float) ((Math.random()) * (vitesseMax - vitesseMin) + vitesseMin);
			float y = (float) ((Math.random()) * (vitesseMax - vitesseMin) + vitesseMin);
			boules[i].setVitesse(x,y);
		}
	}
	
	private int[] testerCollisionAvecBoule(int i) {
		int[] res = new int[nbBoules];
		int indice = 1;
		for (int j=0; j<nbBoules;j++){
			if (j != i && boules[i].contact(boules[j])) {
				res[indice] = j;
				indice++;
			}
		}
		res[0] = indice-1;
		return res;
	}
	
	public void gererCollisions() {
		for (int i=0; i<nbBoules; i++) {
			for (int j=0; j<i; j++) {
				if (boules[i].contact(boules[j])) {
					echangerVecteursVitesse(i,j);
				}
			}
			if (boules[i].getPosition().getX() <= boules[i].getRayon() && boules[i].getVitesse().getX() < 0) {
				Vecteur vitesseCorrigee = new Vecteur(-boules[i].getVitesse().getX(),boules[i].getVitesse().getY());
				boules[i].setVitesse(vitesseCorrigee);
			}
			if (boules[i].getPosition().getX() >= largeurEcran - boules[i].getRayon() && boules[i].getVitesse().getX() > 0) {
				Vecteur vitesseCorrigee = new Vecteur(-boules[i].getVitesse().getX(),boules[i].getVitesse().getY());
				boules[i].setVitesse(vitesseCorrigee);
			}
			if (boules[i].getPosition().getY() <= boules[i].getRayon() && boules[i].getVitesse().getY() < 0) {
				Vecteur vitesseCorrigee = new Vecteur(boules[i].getVitesse().getX(),-boules[i].getVitesse().getY());
				boules[i].setVitesse(vitesseCorrigee);
			}
			if (boules[i].getPosition().getY() >= hauteurEcran - boules[i].getRayon() && boules[i].getVitesse().getY() > 0) {
				Vecteur vitesseCorrigee = new Vecteur(boules[i].getVitesse().getX(),-boules[i].getVitesse().getY());
				boules[i].setVitesse(vitesseCorrigee);
			}
		}	
	}
	
	private void echangerVecteursVitesse(int i, int j) {
		Vecteur vCache = new Vecteur(boules[i].getVitesse().getX(), boules[i].getVitesse().getY());
		boules[i].setVitesse(boules[j].getVitesse());
		boules[j].setVitesse(vCache);
	}
	
	public void deplacer() {
		for (int i=0; i<nbBoules; i++){
			boules[i].deplacer();
		}
	}
	
	public Boule get(int i) {
		return boules[i];
	}
	
	public void paint(Graphics g) {
		for (int i=0; i<nbBoules; i++){
			boules[i].paintComponent(g);
		}
	}
	
	public boolean testerContact(Point curseur) {
		boolean contact = false;
		for (int i=0; i<nbBoules; i++) {
			if (curseur.distance(boules[i].getPosition()) < boules[i].getRayon()) {
				contact = true;
			}
		}
		return contact;
	}
	public int indiceContact(Point curseur) {
		int indice = -1;
		for (int i=0; i<nbBoules; i++) {
			if (curseur.distance(boules[i].getPosition()) < boules[i].getRayon()) {
				indice = i;
			}
		}
		return indice;
	}
	public int getNbBoules() {
		return nbBoules;
	}

	public void setNbBoules(int nbBoules) {
		this.nbBoules = nbBoules;
	}
	public float getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(float vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public float getVitesseMin() {
		return vitesseMin;
	}

	public void setVitesseMin(float vitesseMin) {
		this.vitesseMin = vitesseMin;
	}
	public void add(int x, int y) {
		nbBoules++;
		boules[nbBoules-1] = new Boule(x, y, 0, 0, rayon);
	}
	public void setVitesse(Vecteur v, int indice) {
		boules[indice].setVitesse(v);
	}
	public void supprimer(int indice) {
		for (int k=indice; k<nbBoules-1; k++) {
			boules[k] = boules[k+1].copy();
		}
		nbBoules--;
	}
	/*
	static Bord[] testerCollisionAvecBord(Boule boule) {
		Bord[] res = new Bord[2];
		int indice = 0;
		if (boule.getPosition().getX() <= boule.getRayon()) {
			res[indice] = Bord.GAUCHE;
			indice ++;
		}
		if (boule.getPosition().getX() >= largeurEcran - boule.getRayon()) {
			res[indice] = Bord.DROITE;
			indice ++;
		}
		if (boule.getPosition().getY() <= boule.getRayon()) {
			res[indice] = Bord.HAUT;
			indice ++;
		}
		if (boule.getPosition().getY() >= hauteurEcran - boule.getRayon()) {
			res[indice] = Bord.BAS;
		}
		return res;	
	}
	*/
}

package utile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;


public class Fleche {
	private Point origine;
	private Point extremite;
	private Point coinBas;
	private Point coinHaut;
	
	public Fleche()  {
		origine = new Point();
		extremite = new Point();
	}
	public Fleche(Point origine,Point extremite) {
		this.origine = origine;
		this.extremite = extremite;
	}
	public Fleche(float x1, float y1, float x2, float y2) {
		origine = new Point(x1,y1);
		extremite = new Point(x2, y2);
	}
	public Point getOrigine() {
		return origine;
	}
	public void setOrigine(Point origine) {
		this.origine = origine;
	}
	public void setOrigine(float x, float y) {
		this.origine = new Point(x,y);
	}
	public Point getExtremite() {
		return extremite;
	}
	public void setExtremite(Point extremite) {
		this.extremite = extremite;
	}
	public void actualiser() {
		Vecteur u = new Vecteur(extremite, origine);
		u.normalize();
		u.product(10);
		u.rotate((float) (30*2*Math.PI/360));
		coinBas = extremite.addp(u);
		u.rotate((float) (-60*2*Math.PI/360));
		coinHaut = extremite.addp(u);
	}
	public Vecteur getVecteur() {
		return new Vecteur(origine, extremite);
	}
	public void paintComponent(Graphics g) {
		if (!origine.equalsTo(extremite)) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(new Line2D.Float(origine.getX(), origine.getY(), extremite.getX(), extremite.getY()));
			g2.draw(new Line2D.Float(extremite.getX(), extremite.getY(), coinBas.getX(), coinBas.getY()));
			g2.draw(new Line2D.Float(extremite.getX(), extremite.getY(), coinHaut.getX(), coinHaut.getY()));
		}
	}
}

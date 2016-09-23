package utile;
import java.awt.Color;
import java.awt.Graphics;


public class Boule {

	private Point position;
	private Vecteur vitesse;
	private float rayon;

	
	public Boule(){
		position = new Point();
		vitesse = new Vecteur();
		rayon = 0;

	}
	public Boule( Point position, Vecteur vitesse, float rayon) {
		this.position = position;
		this.vitesse = vitesse;
		this.rayon = rayon;
	}
	public Boule(float px,float py,float vx,float vy, float r){
		position = new Point(px, py);
		vitesse = new Vecteur(vx, vy);
		rayon = r;
	}
	public Point getPosition() {
		return this.position;
	}
	public Vecteur getVitesse() {
		return this.vitesse;
	}
	public float getRayon() {
		return this.rayon;
	}
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}
	public void setVitesse(float x, float y) {
		this.vitesse.set(x, y);
	}
	public void setVitesse(Vecteur v) {
		this.vitesse.set(v);
	}
	public void setRayon(float r) {
		this.rayon = r;
	}
	public void deplacer() {
		this.position.add(this.vitesse);
	}
	public float distance(Boule b) {
		return this.getPosition().distance(b.getPosition());
	}
	public boolean contact(Boule b) {
		if (b == null) {
			return false;
		}
		else {
			return (b.position == null || this.distance(b)<= this.rayon + b.rayon);
		}	
	}
	public float tempsAvantCollision(Boule b) {
		return (this.distance(b) - this.rayon - b.rayon) / this.vitesse.norme();
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int) (position.getX() - rayon),(int) (position.getY() - rayon), (int) (2*rayon), (int) (2*rayon));
	}

	public Boule copy() {
		return new Boule(position, vitesse, rayon);
	}
	
		
}

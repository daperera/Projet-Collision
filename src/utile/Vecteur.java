package utile;

public class Vecteur {
	
	private float x;
	private float y;
	
	public Vecteur() {
		this.x = 0;
		this.y = 0;
	}
	public Vecteur(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Vecteur(Point a, Point b) {
		this.x = b.getX() - a.getX();
		this.y = b.getY() - a.getY();
	}
	public Vecteur(Vecteur autre) {
		this.x = autre.x;
		this.y = autre.y;
	}
	public void rotate(float angle) {
		float theta;
		if (x == 0) {
			theta = (float) (Math.PI/2);
		}
		else {
			theta = (float) Math.atan(y/x);
		}
		theta += angle;
		float n = norme();
		x = (float) (n*Math.cos(theta));
		y = (float) (n*Math.sin(theta));
	}
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void set(float x, float y) {
		this.setX(x);
		this.setY(y);
	}
	public void set(Vecteur v) {
		this.x = v.getX();
		this.y = v.getY();
	}
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	public void add(Vecteur u) {
		this.x += u.getX();
		this.y += u.getY();
	}
	public void product(float x) {
		this.x *= x;
		this.y *= x;
	}
	public float norme() {
		return (float) Math.sqrt(this.x*this.x + this.y*this.y);
	}
	public void normalize() {
		float n = norme();
		x /= n;
		y /= n;
	}

	
}

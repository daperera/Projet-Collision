package utile;

public class Point {
	private float x;
	private float y;
	
	public Point(){
		this.x = 0;
		this.y = 0;
	}
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
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
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	public void add(Vecteur u) {
		this.x += u.getX();
		this.y += u.getY();
	}
	public Point addp(Vecteur u) {
		return new Point(x + u.getX(), y + u.getY());
	}
	public float distance(Point p) {
		Vecteur u = new Vecteur(this, p);
		return u.norme();
	}
	public boolean equalsTo(Point p) {
		return (x == p.getX() && y == p.getY());
	}
}

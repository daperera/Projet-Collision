package utile;

public class Temps {
	private long tempsDepart;
	private long tempsEnPause;
	private long tempsDernierArret;
	private boolean enPause;
	
	public Temps(boolean enPause) {
		tempsDepart = System.currentTimeMillis();
		tempsEnPause = 0;
		this.enPause = enPause;
		if (enPause) {
			tempsDernierArret = tempsDepart;
		}
	}
	public void pause() {
		if (!enPause) {
			tempsDernierArret = System.currentTimeMillis();
			enPause = true;
		}
		else {
			
		}
	}
	public void resume() {
		if (enPause) {
			tempsEnPause += (System.currentTimeMillis() - tempsDernierArret);
			enPause = false;
		}
		else {
			
		}
	}
	public long get() {
		return (System.currentTimeMillis() - tempsDepart - tempsEnPause);
	}
	public void reinitialiser(boolean enPause) {
		tempsDepart = System.currentTimeMillis();
		tempsEnPause = 0;
		this.enPause = enPause;
		tempsDernierArret = tempsDepart;
	}
	public String toString() {
		long temps = get();
		int heure = (int) temps / 3600000;
		int minute = (int) (temps % 3600000) / 60000;
		int seconde = (int) (temps % 60000) / 1000;
		return heure + ":" + minute + ":" + seconde;
	}
}

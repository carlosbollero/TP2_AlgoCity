package algo3.algocity.model.mapas;

public class Coordenada implements Comparable<Coordenada> {

	int x;
	int y;

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int distancia(Coordenada c) {
		return ((int) Math.sqrt((x - c.getX()) * (x - c.getX())
				+ (y - c.getY()) * (y - c.getY())));
	}
	
	public boolean equals(Coordenada c) {
		return (x == c.getX() && y == c.getY());
	}
	
	private int norma(){
		return (int)Math.sqrt((x * x) + (y * y));
	}

	@Override
	public int compareTo(Coordenada o) {
		if(this.norma() > o.norma()){
			return 1;
		}
		if(this.norma() < o.norma()){
			return -1;
		}
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

package caosEnLaEmbasadora;

public class Secuencia {
	private int longitud;
	private int inicio;
	private int fin;
	

	public Secuencia(int longitud2, int inicio2, int fin2) {
		this.longitud = longitud2;
		this.inicio = inicio2;
		this.fin = fin2;
	}


	public int getLongitud() {
		return longitud;
	}


	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}


	public int getInicio() {
		return inicio;
	}


	public void setInicio(int inicio) {
		this.inicio = inicio;
	}


	public int getFin() {
		return fin;
	}


	public void setFin(int fin) {
		this.fin = fin;
	}
	
	
	
}

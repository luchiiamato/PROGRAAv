package depositosSubterraneos;

public class Depositos {
	
	int superficie;
	int profundidad;
	double volumen;
	double volumenMax;
	double volumenPorMetro;
	
	public Depositos(int superficie,int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.volumen = 0;
		this.volumenMax = superficie*profundidad;
		this.volumenPorMetro = this.volumenMax/profundidad;
	}
	
}

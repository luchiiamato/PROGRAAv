package nombresRepetidos;

import java.util.Comparator;

public class Nombres implements Comparator<Nombres>{
	private String nombre;
	int cantRep;
	
	public Nombres(String name) {
		this.nombre = name;
		this.cantRep = 1;
	}
	
	public Nombres() {
		this.nombre = "";
		this.cantRep = 0;
	}
	public Nombres(String name, int cant) {
		this.nombre = name;
		this.cantRep = cant;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nombres other = (Nombres) obj;
		if (cantRep != other.cantRep)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + nombre + "," + cantRep + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantRep() {
		return cantRep;
	}

	public void setCantRep(int cantRep) {
		this.cantRep = cantRep;
	}

	@Override
	public int compare(Nombres arg0, Nombres arg1) {
	      if (arg0.cantRep< arg1.cantRep) {
	            return -1;
	        }
	        if (arg0.cantRep< arg1.cantRep){
	            return 1;
	        }
	        return 0;
	}
	
	
}

class OrdenarNombrePorCant implements Comparator<Nombres> {

    @Override
    public int compare(Nombres arg0, Nombres arg1) {
    	 if (arg0.cantRep> arg1.cantRep) {
	            return -1;
	        }
	        if (arg0.cantRep<arg1.cantRep){
	            return 1;
	        }
	        return 0;
    }
}

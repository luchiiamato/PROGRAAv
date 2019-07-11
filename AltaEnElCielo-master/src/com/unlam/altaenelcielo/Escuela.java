package com.unlam.altaenelcielo;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
	
	private int orden;
	private int ultimoCocido;
	private int tamañoBandera;
	private List<Integer> retazos;
	
	public Escuela(int retazoInicial,int  orden) {
		this.tamañoBandera=retazoInicial;
		this.orden=orden;
		this.ultimoCocido=retazoInicial;
		retazos = new ArrayList<>();
	}
	public void agregarRetazo(int retazo) {
		ultimoCocido=retazo;
		tamañoBandera+=retazo;
		retazos.add(retazo);
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public int getUltimoCocido() {
		return ultimoCocido;
	}
	public void setUltimoCocido(int ultimoCocido) {
		this.ultimoCocido = ultimoCocido;
	}
	public int getTamañoBandera() {
		return tamañoBandera;
	}
	public void setTamañoBandera(int tamañoBandera) {
		this.tamañoBandera = tamañoBandera;
	}
	public List<Integer> getRetazos() {
		return retazos;
	}
	public void setRetazos(List<Integer> retazos) {
		this.retazos = retazos;
	}
	
	
}

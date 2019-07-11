package com.unlam.altaenelcielo;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
	
	private int orden;
	private int ultimoCocido;
	private int tama�oBandera;
	private List<Integer> retazos;
	
	public Escuela(int retazoInicial,int  orden) {
		this.tama�oBandera=retazoInicial;
		this.orden=orden;
		this.ultimoCocido=retazoInicial;
		retazos = new ArrayList<>();
	}
	public void agregarRetazo(int retazo) {
		ultimoCocido=retazo;
		tama�oBandera+=retazo;
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
	public int getTama�oBandera() {
		return tama�oBandera;
	}
	public void setTama�oBandera(int tama�oBandera) {
		this.tama�oBandera = tama�oBandera;
	}
	public List<Integer> getRetazos() {
		return retazos;
	}
	public void setRetazos(List<Integer> retazos) {
		this.retazos = retazos;
	}
	
	
}

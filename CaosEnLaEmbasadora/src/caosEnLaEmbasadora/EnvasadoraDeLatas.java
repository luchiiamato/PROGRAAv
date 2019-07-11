package caosEnLaEmbasadora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EnvasadoraDeLatas extends General {

		private ArrayList<Character> latas;
		private Secuencia secuenciaMaslarga;
		private Secuencia segundaSecuenciaMasLarga;

	public EnvasadoraDeLatas(File entrada,File salida) throws FileNotFoundException {
		super(entrada,salida);
		this.latas = new ArrayList<Character>();
		this.levantarEntrada();
		this.secuenciaMaslarga = new Secuencia(0,0,0);
		this.segundaSecuenciaMasLarga = new Secuencia (0,0,0);
	}
	
	private void levantarEntrada() throws FileNotFoundException { //Subo al arraylist latas uno por una de las letras de la linea
		Scanner sc = new Scanner(this.entrada);
		String lata = sc.next();
		for (int i=0; i< lata.length() -1 ;i++) {
			this.latas.add(lata.charAt(i));}
		sc.close();
	}
	
	public void resolver() throws FileNotFoundException {
		this.buscarSecuencias();
		this.grabarSalida();
	}
	
	private void buscarSecuencias() {
		int inicio,fin,longitud=0;
		
	for(int i=0;i<this.latas.size();i++) {
		if(this.latas.get(i).equals('G')) {
			inicio=i;
			do {
				longitud++;
				i++;
			}while(i<this.latas.size() && this.latas.get(i).equals('G'));
		fin=i-1;
		if(longitud>this.secuenciaMaslarga.getLongitud()) {
			this.segundaSecuenciaMasLarga = this.secuenciaMaslarga;
			this.secuenciaMaslarga = new Secuencia(longitud,inicio,fin);
		}else if(longitud > this.segundaSecuenciaMasLarga.getLongitud()) {
			this.segundaSecuenciaMasLarga = new Secuencia (longitud,inicio,fin);
			
		}
		longitud = 0;
			}
		}
	}
	
	private int calcularDistanciaEntreSecuencias() {
		if(this.secuenciaMaslarga.getLongitud()==0 || this.segundaSecuenciaMasLarga.getLongitud()==0) {
			return 0;
		}
		if(this.secuenciaMaslarga.getInicio()<this.segundaSecuenciaMasLarga.getInicio())
			return this.segundaSecuenciaMasLarga.getInicio()- this.secuenciaMaslarga.getInicio();
		else
			return this.secuenciaMaslarga.getInicio()-this.segundaSecuenciaMasLarga.getInicio();
	}
	private void grabarSalida() throws FileNotFoundException {
		PrintWriter p = new PrintWriter(this.salida);
		p.println(this.latas.size());
		p.println(this.secuenciaMaslarga.getLongitud());
		p.println(this.segundaSecuenciaMasLarga.getLongitud());
		p.println(this.calcularDistanciaEntreSecuencias());
		p.close();
	}
	
}

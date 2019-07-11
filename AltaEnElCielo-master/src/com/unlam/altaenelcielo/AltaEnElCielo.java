package com.unlam.altaenelcielo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AltaEnElCielo extends EjercicioOIA{
	
	int cantEscuelas;
	int carretelTela;
	List<Escuela> escuelas;
	int cantTelaActual;
	int banderaMasLarga;
	int escuelaGanadora;
	
	
	public AltaEnElCielo(File entrada, File salida){
		super(entrada,salida);
		escuelas = new ArrayList<>();
		
	}
	private void leerEntrada() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			String[] valores = linea.split(" ");
			
			carretelTela = (int)valores[0];
			cantEscuelas = (int)valores[1];
			
			cantTelaActual = carretelTela;
			int i  = 0;		
			
			linea = br.readLine();
			Integer retazoInicial = Integer.valueOf(linea);
				
			banderaMasLarga = retazoInicial;
			boolean alcanzaAlInicio = false;
			escuelaGanadora = 1;
			
			while(i<cantEscuelas) {
		
				if(cantTelaActual>=retazoInicial) {
					escuelas.add(new Escuela(retazoInicial, i +1));
					cantTelaActual-=retazoInicial;
					if(banderaMasLarga<retazoInicial) {
						banderaMasLarga=retazoInicial;
						escuelaGanadora = i+1;
					}
					alcanzaAlInicio = true;
				}else {
					if(!alcanzaAlInicio) {
						//imprimir vacio
						break;
					}
				}
				i++;
				linea = br.readLine();
				if(linea!=null)
				retazoInicial= Integer.valueOf(linea);
			}
			
		}catch(IOException ex) {
		
				try {	
					if(fr!=null)
					fr.close();
					if(br!=null) 
						br.close();
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		}
	}
	@Override
	public void resolver() {
		leerEntrada();
		int orden = 1;
	
		int cantEscuelasQueNoCumplen = 0;
		
		while(cantEscuelasQueNoCumplen!=cantEscuelas) {
			Escuela escuelaActual = escuelas.get(orden-1);
			int ultCocido = escuelaActual.getUltimoCocido();
			int retazoNecesario = ultCocido + sumarDigitos(ultCocido);
			
			if(retazoNecesario>cantTelaActual) {
				cantEscuelasQueNoCumplen++;
			}else {
				cantEscuelasQueNoCumplen=0;
				escuelaActual.agregarRetazo(retazoNecesario);
				if(banderaMasLarga<escuelaActual.getTamañoBandera()) {
					banderaMasLarga = escuelaActual.getTamañoBandera();
					escuelaGanadora = orden;
				}
				cantTelaActual-=retazoNecesario;
			}
			if(orden==cantEscuelas) {
				orden=1;
			}else {
				orden++;
			}
		}
		
		System.out.println("Bandera mas larga : "+ banderaMasLarga);
		System.out.println("Escuela ganadora: "+ escuelaGanadora);
		System.out.println("Numero de costuras bandera mas larga: " + (escuelas.get(escuelaGanadora-1).getRetazos().size()-1));
		System.out.println("Tamaño de tela que sobro: " + cantTelaActual);
		
		
	}
	
	private int sumarDigitos(int n) {
		int sum = 0;
		
		while(n>0) {
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}
	
	public static void main(String[]args) {
		File f = new File("entrada.in");
		AltaEnElCielo alta = new AltaEnElCielo(f,null);
		alta.resolver();
	}
}

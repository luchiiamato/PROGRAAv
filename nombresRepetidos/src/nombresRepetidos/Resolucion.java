package nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Resolucion {
	
	private int cantGanadores;
	private ArrayList<Nombres> vecNomb;
	protected Nombres nuevo;
	

	public Resolucion(File entrada, File salida) throws FileNotFoundException {
				
		this.vecNomb = new ArrayList<Nombres>();	
		
		Scanner sc = new Scanner(entrada);
		cantGanadores= sc.nextInt();
		int cantNombresRepAVer=sc.nextInt();
		Nombres nuevo = new Nombres();
		ArrayList<String> aux=new ArrayList<String>();
		long ini = System.currentTimeMillis();
		for(int i=0;i<cantGanadores;i++) {
			aux.add(sc.next());		
		}
		aux.sort(null);
		int i=0;
		int contador=0;
		int j=0;
		while(i<cantGanadores) {
			 j= i+1;
			 contador=1;
			 if(j>=cantGanadores) {
				 j=i;
				 contador=0;
			 }
			if(j<cantGanadores) {
				while(j<cantGanadores && aux.get(i).equals(aux.get(j))){
					contador++;
					j++;
				}
			}
			else{
				contador++;
			}
			nuevo =new Nombres((aux.get(i)),contador);
			vecNomb.add(nuevo);
			i = j;
		}
		Collections.sort(vecNomb, new OrdenarNombrePorCant());
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo:"+ (fin-ini));
		PrintWriter pw = new PrintWriter(salida);
		for(int x=0; x<cantNombresRepAVer;x++) {
			
			pw.println(vecNomb.get(x));
		}
		
	pw.close();
	sc.close();
	}
	}

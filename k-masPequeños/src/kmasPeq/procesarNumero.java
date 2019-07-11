package kmasPeq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class procesarNumero {
		int cantNumeros;
		int cantAMostrar;
		ArrayList<Integer> numeros;
	public procesarNumero(File entrada, File salida) throws FileNotFoundException {
		
		Scanner sc = new Scanner (entrada);
		numeros = new ArrayList<Integer>();
		cantNumeros=sc.nextInt();
		cantAMostrar=sc.nextInt();
		int aux;
		int[] resultado= new int[cantAMostrar];
		for(int i=0;i<cantNumeros;i++) {
			numeros.add(sc.nextInt());
		}
		numeros.sort(null);
		int k=0;
		int i=0;
		int j=0;
		PrintWriter p = new PrintWriter(salida);
		p.println(cantAMostrar);
		while(k<cantAMostrar) {
			if(k>1) {
			while(numeros.get(i)==resultado[k-1]) {
			i++;
			}		
		}
			resultado[k]=numeros.get(i);
			p.println(resultado[k]);
			k++;
			i++;
		}
		
		
		sc.close();
		p.close();
		
	
	}
	
	
	
	}



package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcesarEntradaYSalida {
	int cantPalabras;
	ArrayList<String> palabras;
	
	public ProcesarEntradaYSalida(File entrada, File salida) throws FileNotFoundException {
		
		Scanner sc = new Scanner(entrada);
		cantPalabras = sc.nextInt();
		palabras = new ArrayList<String>();
		int cantidad = 'z'-'a';
		int[] vectorLetras = new int[cantidad];
		String aux;
		int cantLetras;
		char extremoI;
		char extremoF;
		long starTime = System.currentTimeMillis();
		for(int i=0;i<cantidad;i++) {
			vectorLetras[i]=0;
		}
		for(int i=0;i<cantPalabras;i++) {
			palabras.add(sc.next());
		}
		for(int i=0;i<cantPalabras;i++){
			aux = palabras.get(i);
			cantLetras=aux.length();
			extremoI=aux.charAt(0);
			extremoF=aux.charAt(cantLetras-1);
			vectorLetras[(int)extremoI-'a']++;
			vectorLetras[(int)extremoF-'a']++;
			
		}
		int max=0;
		int k=0;
		for(int i = 0; i < cantidad; i++)
		{
			if(max<vectorLetras[i])
			{
				max=vectorLetras[i];
				k=i;
			}
		}
		PrintWriter p = new PrintWriter(salida);
		p.println((char)(k+'a'));
		for(int i=0;i<cantPalabras;i++){
			aux = palabras.get(i);
			cantLetras=aux.length();
			if(aux.charAt(0) == (char)(k+'a') || aux.charAt(cantLetras-1)==(char)(k+'a')) {
			p.println(aux);
			}
		}
		System.out.println(System.currentTimeMillis() - starTime);
	p.close();
	sc.close();

	}
}

package kmasPeq;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		long starTime = System.currentTimeMillis();
		File entrada = new File("entrada.in");
		File salida = new File("salida.out");
		
		procesarNumero pn = new procesarNumero(entrada,salida);
		
//		System.out.println(System.currentTimeMillis() - starTime);
		

	}

}

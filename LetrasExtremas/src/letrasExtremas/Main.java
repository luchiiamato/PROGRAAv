package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File entrada = new File("entrada.in");
		File salida = new File ("salida.out");
		
	ProcesarEntradaYSalida pe = new ProcesarEntradaYSalida(entrada,salida);
	

	}

}

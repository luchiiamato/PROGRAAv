package nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		File entrada = new File("entrada.in");
		File salida = new File ("salida.out");
		Resolucion pe = new Resolucion(entrada,salida);
	}

}

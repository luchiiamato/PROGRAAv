package caosEnLaEmbasadora;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File entrada = new File("latas.in.txt");
		File salida = new File("latasout.txt");
	
	EnvasadoraDeLatas env = new EnvasadoraDeLatas(entrada,salida);
	env.resolver();
	}
}

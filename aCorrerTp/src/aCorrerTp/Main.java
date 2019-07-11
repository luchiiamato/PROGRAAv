package aCorrerTp;

import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {

		File dir = new File(".//IN//");
		for(File archivo : dir.listFiles()) {
			CarreraM carrera = new CarreraM(archivo);
			carrera.otorgarMedallas();
			carrera.mostrarPodios(archivo);
		}
	}

}

package caosEnLaEmbasadora;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class General {

	public File entrada;
	public File salida;
	
	public General (File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver() throws FileNotFoundException;
}

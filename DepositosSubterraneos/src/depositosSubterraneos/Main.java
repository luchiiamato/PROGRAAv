package depositosSubterraneos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Salida sal1 = new Salida("in.txt","out.txt");
		sal1.generarSalida();
	}

}

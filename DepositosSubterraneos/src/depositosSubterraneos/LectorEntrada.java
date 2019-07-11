package depositosSubterraneos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorEntrada {
	String entrada;

	
	public LectorEntrada(String entrada2) {
		this.entrada = entrada2;
		// TODO Auto-generated constructor stub
	}

	public int procesar(ArrayList<Depositos> dep) throws FileNotFoundException {
		int volumenAIngresar,tam;
		Scanner sc = new Scanner(new File(entrada));
		tam = sc.nextInt();
		for(int i=0;i<tam;i++) {
			dep.add(new Depositos(sc.nextInt(),sc.nextInt()));
		}
		volumenAIngresar=sc.nextInt();
		sc.close();
		return volumenAIngresar;
	}
	
}

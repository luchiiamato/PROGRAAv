package codificandoMensajes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Codificar {
	char[] cadena;
	int digito;
	int clave;
	int cantDeCaracteres;//Incluye espacios
	
	public Codificar(File entrada, File salida) throws FileNotFoundException {
		
		Scanner sc = new Scanner(entrada);
		digito=sc.nextInt();
		clave=sc.nextInt();
		cantDeCaracteres = sc.nextInt();
		cadena = new char[cantDeCaracteres];
		String espacio = sc.nextLine();
		String linea = sc.nextLine();
		int k=0;
		for(int i = 0; i<cantDeCaracteres;i++) {
			if(linea.charAt(i)!=' ') {
			cadena[k]= linea.charAt(i);
			k++;
			}
		}
		int claveCifradoPar = clave%10;
		int claveCifradoImpar = clave/10;
		int j=0;
		int i=0;
		PrintWriter p = new PrintWriter(salida);
		while(i<k) {
			
			if((i+1)%2==0) {
				cadena[i]+=claveCifradoPar;
			}
			else{
				cadena[i]+=claveCifradoImpar;
				if((cadena[i])>'Z') 
					cadena[i]=(char) (cadena[i]-('Z'-'A'+1));
			}
			i++;
		}
		p.print(cadena);
	System.out.println(cadena);
	sc.close();
	p.close();
	}
}

package aCorrerTp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CarreraM {
	
	public Corredor[] corredores;
	public RangoEdad[] rangoEdadF;
	public RangoEdad[] rangoEdadM;
	public String[] premiosF;
	public String[] premiosM;
	public int[]	llegadas;
	
	public CarreraM (File archivo) throws IOException{
		
		Scanner sc = new Scanner (archivo);
		int cantCorredores = sc.nextInt();
		int cantRef = sc.nextInt();
		int cantRem = sc.nextInt();
		int cantLlegadas = sc.nextInt();
		
		corredores = new Corredor[cantCorredores];
		rangoEdadF=new RangoEdad[cantRef];
		rangoEdadM=new RangoEdad[cantRem];
		llegadas = new int[cantLlegadas];
		
		for ( int i = 0;i<cantRef;i++){
			rangoEdadF[i]= new RangoEdad (sc.nextInt(),sc.nextInt());
		}
		
		for (int i=0;i<cantRem;i++) {
			rangoEdadM[i] = new RangoEdad(sc.nextInt(),sc.nextInt());
		}
		
		for(int i=0;i<cantCorredores;i++) {
			int edad=sc.nextInt();
			String linea=sc.nextLine();
			corredores[i] = new Corredor(edad,linea.charAt(1));
		}
		
		for(int i = 0; i< cantLlegadas; i++) {
			llegadas[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	public void otorgarMedallas () throws Exception {
		if(corredores.length == 0 || rangoEdadF.length == 0 || rangoEdadM.length == 0)
			throw new Exception ( "Error en el input");
		if(corredores.length < llegadas.length)
			throw new Exception ("Hay mas llegadas que corredores!");
		
		for ( int i = 0; i< llegadas.length;i++) {
			//Busco rango de edad que esta
			char sexo =corredores[llegadas[i]-1].getSexo();
			int edad = corredores[llegadas[i]-1].getEdad();
			int numRangoEdad=0;
		
		
		if(sexo=='F') {
			while(numRangoEdad<rangoEdadF.length && 
					!(edad>=rangoEdadF[numRangoEdad].getEdadInicial() &&
					edad<=rangoEdadF[numRangoEdad].getEdadFinal())) 
				numRangoEdad++;
			if(numRangoEdad == rangoEdadF.length -1 &&!(edad>=rangoEdadF[numRangoEdad].getEdadInicial() &&
					edad<=rangoEdadF[numRangoEdad].getEdadFinal()))
				throw new Exception ("No hay rango de edad para este jugador Femenino");
			rangoEdadF[numRangoEdad].agregarGanador(llegadas[i]);
				
		}
			
		else {
			while(numRangoEdad<rangoEdadM.length && 
					!(edad>=rangoEdadM[numRangoEdad].getEdadInicial() &&
					edad<=rangoEdadM[numRangoEdad].getEdadFinal())) {
				numRangoEdad++;
			}
		if(numRangoEdad == rangoEdadM.length -1 &&!(edad>=rangoEdadM[numRangoEdad].getEdadInicial() &&
				edad<=rangoEdadM[numRangoEdad].getEdadFinal()))
			throw new Exception ("No hay rango de edad para este jugador Masculino");
		rangoEdadM[numRangoEdad].agregarGanador(llegadas[i]);
		}}}

	
	public void mostrarPodios(File archivo) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(new File(".//OUT//" + archivo.getName().replaceAll(".in",".out"))));
		
		for(int i=0;i<rangoEdadF.length;i++) {
			int []ganadores = rangoEdadF[i].getGanadores();
			out.println((i + 1) + " " + ganadores[0] + " "+ ganadores[1] + " "+ ganadores[2]);
		}
		for(int i=0;i<rangoEdadM.length;i++) {
			int []ganadores = rangoEdadM[i].getGanadores();
			out.println((i + 1) + " " + ganadores[0] + " "+ ganadores[1] + " "+ ganadores[2]);
		}
		out.close();
	}
}

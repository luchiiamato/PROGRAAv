package depositosSubterraneos;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Salida {
	
	String sal;
	ArrayList<Depositos> dep;
	int volumenIngresado;
	int depositosCargados;
	int distApiso;
	
	public Salida(String entrada,String sal) throws FileNotFoundException {
		this.sal = sal;
		this.dep = new ArrayList<Depositos>();
		LectorEntrada le = new LectorEntrada(entrada);
		this.volumenIngresado = le.procesar(dep);
		this.depositosCargados=0;
		
	}
	
	public int desborde() {
		int total=0;
		for(Depositos x:dep) {
			total+=x.volumenMax;
		}
		return total-volumenIngresado;
	}
	
	public void llenarDepositos() {
		int totalADepositar = dep.size();
		int metrosAEmparejar;
		double volumenPorMetrosTotal=0;
		Depositos dep1,depSig;
		this.depositosCargados++;
		dep1=dep.get(0);
		depSig=dep.get(1);
		metrosAEmparejar= dep1.profundidad-depSig.profundidad;
		volumenPorMetrosTotal+=dep1.volumenPorMetro;
		if(volumenIngresado<=volumenPorMetrosTotal*metrosAEmparejar)
		{
			dep1.volumen+=volumenIngresado;
			this.distApiso = dep1.profundidad - (int)(dep1.volumen/dep1.volumenPorMetro);
			return;
		}
		dep1.volumen+=volumenPorMetrosTotal*metrosAEmparejar;
		volumenIngresado-=(volumenPorMetrosTotal*metrosAEmparejar);
		
		for(int i=1;i<totalADepositar-1;i++) {
			this.depositosCargados++;
			dep1=dep.get(i);
			depSig=dep.get(i+1);
			metrosAEmparejar= dep1.profundidad-depSig.profundidad;
			volumenPorMetrosTotal+=dep1.volumenPorMetro;
			if(volumenIngresado<=volumenPorMetrosTotal*metrosAEmparejar)
			{
				volumenIngresado/=volumenPorMetrosTotal;
				for( int j=0;j<i;j++) {
					dep1=dep.get(j);
					dep1.volumen+=dep1.volumenPorMetro*(int)volumenIngresado;
				}
				this.distApiso= dep1.profundidad -(int)(dep1.volumen/dep1.volumenPorMetro);
				return;
			}		
			for(int j =0;j<i;j++) {
				dep1=dep.get(j);
				dep1.volumen+=volumenPorMetrosTotal*metrosAEmparejar;
				volumenIngresado-=(volumenPorMetrosTotal*metrosAEmparejar);
				
			}
			
		}
		dep1=dep.get(totalADepositar-1);
		metrosAEmparejar=dep1.profundidad;
		volumenPorMetrosTotal+=dep1.volumenPorMetro;
		volumenIngresado/=volumenPorMetrosTotal;
		for(Depositos x:dep){
			x.volumen+=x.volumenPorMetro*(int)volumenIngresado;
			}
		this.depositosCargados=totalADepositar;
		this.distApiso=dep1.profundidad-(int)(dep1.volumen/dep1.volumenPorMetro);
		return;
		
	}
	public void generarSalida() throws IOException {
		PrintWriter p=new PrintWriter(new FileWriter(sal));
		int desborde = this.desborde();
		if(desborde <0) {
			p.println("Rebalsan: "+Math.abs(desborde));
			p.close();
			return;
		}
		this.llenarDepositos();
		p.println(this.depositosCargados);
		p.println(this.distApiso);
		p.close();
	}
	

}

import java.util.*;
public class Monticulo {
				private int vec[];
				private int cant;
				private int pos;
				
				public Monticulo()
				{
					cant=0;
					vec[0]=-1;
					pos=0;
				}
				
				public Monticulo(int cant){
					this.cant=cant;
					vec= new int[cant];
					
				}
				
				
				
				public void insertarNodo(int n)
				{
					if(pos==cant)
						System.out.println("COLA LLENA");
					pos++;
					int i=pos;
					while(vec[i/2]>n)
					{vec[i]=vec[i/2];
					 i=i/2;
					}
					vec[i]=n;
					
				}
			
				public int eliminarMinimo()
				{	int min=vec[1];
					int i=1;
					int aux;
					 int HI=i*2;
					 int HD=i*2+1;
					 vec[i]=vec[pos];
					 while(HD<pos&&HI<pos&&(vec[i]>vec[HI]||vec[i]>vec[HD]))
					 {		 
					 if(vec[HI]<vec[HD])
					 {aux=vec[i];
					  vec[i]=vec[HI];
					  vec[HI]=aux;
					  i++;
					  HI=i*2;
					  HD=i*2+1;
					 }
					 else
					 {  aux=vec[i];
				    	vec[i]=vec[HD];
						vec[HD]=aux;
					    i+=2;	
					    HI=i*2;
						HD=i*2+1;
					}
					 
				}
				cant--;
				 return min;	
						
						
					}
				
			
				
				
				public void mostrar()
				{for (int i=1;i<cant;i++)
					System.out.println(vec[i]);
					
					
					
				}
				public static void main(String[] args) {
					Monticulo c1= new Monticulo(13);
					c1.insertarNodo(14);
					c1.insertarNodo(19);
					c1.insertarNodo(16);
					c1.insertarNodo(26);
					c1.insertarNodo(21);
					c1.insertarNodo(19);
					c1.insertarNodo(68);
					c1.insertarNodo(65);
					c1.insertarNodo(70);
					c1.insertarNodo(32);
					c1.insertarNodo(31);
					c1.insertarNodo(80);
				
					
					//c1.mostrar();
					/*for(int i=1;i<12;i++)
					  System.out.println(c1.eliminarMinimo());*/
					int min=c1.eliminarMinimo();
					c1.mostrar();
					min=c1.eliminarMinimo();
					c1.mostrar();

				}		
				
}

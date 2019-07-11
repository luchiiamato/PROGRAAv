package aCorrerTp;

public class Corredor {
		private int edad;
				char sexo;
		
		public Corredor(int edad2, char charAt) {
			this.edad = edad2;
			this.sexo = charAt;
				}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public char getSexo() {
			return sexo;
		}
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		
		@Override
		public String toString() {
			return "Corredor [edad=" + edad + ", sexo="	+ sexo + "]";
		}
		

}

package poo;

public class Coche {
	 
		private int ruedas; 
		private int largo,ancho;
		private int motor; 
		private int pesoPlataforma; 
		private String color;
		private int pesoTotal;
		private boolean asientoCuero, climatizador; 
		
		public Coche() {
			//contruir el estado inicial del objeto
			ruedas =4; 
			largo =2000;
			ancho=300;
			motor= 1600;
			pesoPlataforma=500;
		}
		
		public String  getterDatosGenerales  () {
			
			return " la plataforma de vehiculo tiene "+ruedas+" ruedas "
					+" mide"+largo/1000+" mts"+", con un ancho de "+ancho+
					" cm y un peso de plataforma de "+pesoPlataforma+" kg";	
					}
		
		public void setterColor(String colorCoche) {
			color = colorCoche;
		}
		
		public String getterColor() {
			return " El color del coche es "+color;
		}
		
		public void setterAsientos(String asientoCuero) {
			if(asientoCuero.equalsIgnoreCase("si")) {
				this.asientoCuero=true;
			}else {
				this.asientoCuero=false;
			}
		}
		
		public String getterAsientos() {
			if(asientoCuero==true) {
				return " El coche tiene asientos de cuero ";
			}else {
				return " El coche  tiene asientos de de Serie";
			}
		
		}
		
	public void setterClimatizador(String climatizador) {
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	public String getterClimatizador() {
		if(climatizador==true) {
			return " El coche cuenta con acondicionador de aire";
		}else {
			return " El coche no tiene aire aconcicionado";
		}
		
	}
	public String dimePesoCoche() {//setter y getter same time
		int pesoCarroceria=500;
		pesoTotal=pesoPlataforma+pesoCarroceria;
		
		if(asientoCuero==true) {
			pesoTotal+=50;
		}
		if(climatizador==true) {
			pesoTotal+=21;
		}
		return " El peso de coche es "+pesoTotal+" kilos";
	}
	
	public String dimePrecioCoche() {//getter
		int precioBasico=1000; 
		if(asientoCuero==true) {
			precioBasico+=250;
		}
		if(climatizador==true) {
			precioBasico+=400; 
		}
		return" El precio del coche es "+precioBasico+" euros";
	}


}

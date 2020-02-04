package poo;

public class Furgoneta extends Coche{
	
	private int capacidadCarga; 
	private int plazasExtras; 
	
	public Furgoneta(int plazasExtras, int capacidadCarga) {
		
		super(); //llamar al constructo de la clase padre
		this.capacidadCarga=capacidadCarga;
		this.plazasExtras=plazasExtras; 
		
	}
	public String getterDatosFurgoneta() { //getter
		return "  la capaciad de carga es: "+capacidadCarga+
				" y las plazas son: "+plazasExtras;
	}
	
}

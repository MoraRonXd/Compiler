package poo;


public class UsoVehiculo {
	public static void main(String[]args) {
	/*	//instanciando un objeto de la clase Coche
		Coche miCoche =new Coche();
		
		String miColor=JOptionPane.showInputDialog("Color del coche");
		//establecioendo con el metodo setterColor con
		//un paso de parametro el color del coche
		 miCoche.setterColor(miColor);
		 
		 //mostrando en consola medienate el metodo getter
		 //los atributos generales de los coches
		 System.out.println(miCoche.getterDatosGenerales());
		 
		 //mostrando en consola el color del coche mediante
		 //el metodo getterColor
		 System.out.println(miCoche.getterColor());
		 
		 //establecidendo el tipo de asieto con el setterAsiento
		 String miAsiento=JOptionPane.showInputDialog("Quiere asientos de cuero?");
		 miCoche.setterAsientos(miAsiento);
		 
		 //imprimendo con el metodo getterasiento la clase
		 //ya fueron establecidos mediante el setter
		 System.out.println(miCoche.getterAsientos());
		 
		 //estableciendo si tiene aire aconcionado
		 
		 String miClimatizador=JOptionPane.showInputDialog("Desea Climatizador");
		 miCoche.setterClimatizador(miClimatizador);
		 //mosyrando un mensaje con la opcion elegida
		 //mediante un getter
		 System.out.println(miCoche.getterClimatizador());

		 System.out.println(miCoche.dimePesoCoche());
		 
		 System.out.println(miCoche.dimePrecioCoche());*/
		
		Coche miCoche1 = new Coche();
		miCoche1.setterColor("Rojo");
		
		Furgoneta miFurgoneta1= new Furgoneta(7,580);
		
		miFurgoneta1.setterColor("Azul");
		miFurgoneta1.setterAsientos("si");
		miFurgoneta1.setterClimatizador("si");
		
		System.out.println(miCoche1.getterDatosGenerales()+miCoche1.getterColor());
		
		System.out.println(miFurgoneta1.getterDatosGenerales()
				+miFurgoneta1.getterColor()+miFurgoneta1.getterAsientos()
				+miFurgoneta1.getterClimatizador()+miFurgoneta1.getterDatosFurgoneta());
	}
}

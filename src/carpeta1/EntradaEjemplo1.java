package carpeta1;

import java.util.*;
public class EntradaEjemplo1 {
	
	public static void main(String [] args) {
		
		Scanner entrada= new Scanner(System.in);
		System.out.println("Ingrese tu nombre, por favor: ");
		
		String miNombre= entrada.nextLine() ;
		System.out.println("Introduce tu edad, por favor:");
		
		int miEdad=entrada.nextInt();
		
		System.out.println("Hola "+miNombre+" el proximo anio cuamples "+(miEdad+1)+" anios");
	}
}

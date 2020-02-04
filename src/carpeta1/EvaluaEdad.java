package carpeta1;

import java.util.*;
public class EvaluaEdad {
	
	public static void main(String [] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese su edad por favor: ");
		int miEdad=entrada.nextInt();
		
		 if(miEdad<18) {
			 System.out.println("Eres adolecente");
		 }else {
			 if(miEdad>=18 && miEdad<40) {
				 System.out.println("Eres Joven");
			 }else {
				 if(miEdad>=40 && miEdad<60) {
					 System.out.println("Eres Maduro");
				 }else {
					 if(miEdad>=60) {
						 System.out.println("Debes cuidarte");
					 }
				}
			 }
		 }
	}
}

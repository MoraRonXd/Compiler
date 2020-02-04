package carpeta1;
import java.util.*;

import javax.swing.JOptionPane;

public class UsoDeSwitch {
	public static void main(String []args) {
		Scanner entrada =new Scanner(System.in);
		
		System.out.println("Elija una de las Opciones para el calculo de areas geometricas:");
		System.out.println("1. Cuadrado 2. Rectangulo 3.triangulo 4. Circulo");
		int elecion=entrada.nextInt();
		
		while(elecion<1 || elecion>4 ) {
			System.out.println("Eleccion incorrecta intente de nuevo");
			System.out.println("1. Cuadrado 2. Rectangulo 3.triangulo 4. Circulo");
			 elecion=entrada.nextInt();
		}
		switch(elecion) {
		case 1:{
			System.out.println("Caso 1. Calculo Area cuadrado ");
			String miDatoString = JOptionPane.showInputDialog("introdusca el valor de l");
			int miDatoInt=Integer.parseInt(miDatoString);
			double area=Math.pow(miDatoInt, 2);
			System.out.println("El area del cuadrado es: "+area+" Unidades cuadradas");
			break;
		}
		case(2):{
			System.out.println("Caso 2. Calculo de Area del Rectangulo");
			double miLado=Double.parseDouble(JOptionPane.showInputDialog("valor del lado"));
			double miAncho=Double.parseDouble(JOptionPane.showInputDialog("Valor del Ancho"));
			double AreaRec=miLado*miAncho;
			System.out.println("El area del rectangulo es "+AreaRec+" Unidades cuadradas");
			break;
		}
		
		}
		
		
	}
}

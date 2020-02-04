package carpeta1;

import javax.swing.JOptionPane;

public class Entradanumeros {
	public static void main(String []args) {
		String num1=JOptionPane.showInputDialog("Ingrese un numero");
		
		//int miNum1int=Integer.parseInt(num1);
		double miNum1Double=Double.parseDouble(num1);
		
		System.out.print("la raiz de "+num1+" es ");
		System.out.printf("%1.2f",Math.sqrt(miNum1Double));
		
	}
}

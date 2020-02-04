package carpeta1;

import javax.swing.JOptionPane;

public class Factorial {
	public static void main(String []args) {
		long factorial=1l;
		int num;
		
		do {
			num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero mayor que cero"));
		}while(num<=0);
		
		for(int i=1;i<=num;i++) {
			factorial=factorial*i;
		}
		System.out.println("El factorial de "+num+" es "+factorial);
	}
}

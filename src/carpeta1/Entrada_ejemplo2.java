package carpeta1;

import javax.swing.JOptionPane;

public class Entrada_ejemplo2 {
	
	public static void main(String [] args) {
		String nombreUsuario=JOptionPane.showInputDialog("Introduce Tu Nombre: ");
		
		String edadUsuario=JOptionPane.showInputDialog("Ingrese su edad: ");
		
		int edadentera=Integer.parseInt(edadUsuario);
		
		System.out.println("hola "+nombreUsuario+" tu edad sera "+(edadentera+1)+" anios");
	} 
}

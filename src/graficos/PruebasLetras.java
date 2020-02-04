package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class PruebasLetras {

	public static void main(String[] args) {
		String fuente=JOptionPane.showInputDialog("Ingrese una fuente");
		
		boolean estalafuente= false; 
		
		/*la clase Graphics environments devuelve un arreglo
		 * de Strings donde almacena las fuentes que posee
		 * nuestra computador, por tanto necesito un arreglos
		 * se String*/
		String[] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		//con esto almacenamos en el array de String todos
		//los tipos de fuentes que tenemos, ahora necesito
		//recorres ese array
		
		//bucle for each
		//for(tipoArray nombreVariable : nombreDeArray){
		//}
		
		for(String nombredelafuente: nombresDeFuentes) {
			
			if(nombredelafuente.equalsIgnoreCase(fuente)) {
				estalafuente=true;
			}
		}
		if(estalafuente) {
			System.out.println("Fuente instalada");
		}else {
			System.out.println("Fuente no instalada");
		}
	}

}

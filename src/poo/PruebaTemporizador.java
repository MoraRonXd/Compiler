package poo;
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
/*CLASES INTERNAS LOCALES , QUE SON?
 * -Una clase dentro de un metodo
 * cuando se utilizan este tipo de clases y por que ?
 * -Son utiles cuando solo se van a utilizar(INSTANCIAR)
 * 	la clase interna una vez.El objetivo es simplificar
 * el codigo aun mas.
 *   -Su ambito queda restringido al metodo donde son 
 *   declaradas. Ventajas?
 *   	-Estan muy "Encapsuladas".Nisiquiera la clase a la 
 *   que pestenecen puede acceder a ella.Tan solo puede
 *   acceder a ella el metodo donde estan declaradas
 *   - El metodo resulta mas simple*/
public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameLaHora oyente= new DameLaHora();
		//ActionListener oyente = new DameLaHora();
		
		//tambien funciona asi, de hecho asi me gusta mas
		
		Timer miTemporizador =new Timer(5000,oyente);
		/*con esto cada 5 sg se ejecuta el metodo 
		 *ActionPerformed(el cual debe ser implementado
		 *obligaroriamente por que es un metodo perte-
		 *neciente a una interface) se jacute, almacenado
		 *en la variable ahora la hora en ese instante
		 *para justo despues imprimirla en pantalla */
		
		miTemporizador.start();
		
		/*esta instruccion es para el el programa 
		 * este en ejecusion hT el momento  que pulsemos
		 * en botton y pase a la siguiente instruccion
		 * que es detener el programa*/
		JOptionPane.showMessageDialog(null,"pulsa aceptar para detener");
		
		/**/
		System.exit(0);
	}
	
}

class DameLaHora implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		Date ahora =new Date();
		
		System.out.println("te pongo la hora cada 5 sg "+ahora);
		Toolkit.getDefaultToolkit().beep();
	}
}
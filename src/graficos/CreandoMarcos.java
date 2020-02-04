package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {
	public static void main(String [] args) {
		//instancia de la clase miMarco
		miMarco marco1 = new miMarco();
		//hacer visible la ventana 
		marco1.setVisible(true);
		//que hacer cuando se cierre,
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//se usa JFrame. por que el campo EXIT_ON_CLOSE es
		//estatico y se debe utilizar la clase delante, estableciendose 
		//asi el comportamiento de nuestro marco cuando se cierre
		//que es terminar la aplicacion
	}
}

//clase miMarco
class miMarco extends JFrame{
	//constructor 
	public miMarco() {
		//setSize(500,300);
		//setLocation(400,200);
		setBounds(400,200,550,300);//establece ubicacion, largo y ancho
		setResizable(true);//establece si puede cambiar el tamanio de la pantalla
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Mi ventana");
	}
}

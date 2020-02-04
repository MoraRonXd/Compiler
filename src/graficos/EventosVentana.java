package graficos;

import java.awt.event.*;


import javax.swing.*;

public class EventosVentana {

	public static void main(String[] args) {
		MarcoVentana miMarco=new MarcoVentana();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoVentana miMarco2=new MarcoVentana();
		miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		miMarco.setTitle("Ventana 1");
		miMarco2.setTitle("Ventana 2");
		miMarco.setBounds(300, 100, 300, 300);
		miMarco2.setBounds(650, 100, 300, 300);
	}
}

class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
		//setTitle("Respondiendo");
		//setBounds(400,200,500,350);
		setVisible(true);
		
		//M_Ventana oyente = new M_Ventana();
		//addWindowListener(oyente);
		
		//podria resumir estas dos ultimas instruccuines es 
		//una solo con lo cual el codigo queda mas efeciente
		addWindowListener(new M_Ventana());
	}
}
//clase oyente a la espera de eventos en este caso de 
//ventanas (WindowListener), y ya que esto es una interface
//debo implementar todos los metodos abstractos de la misma


/*aca antes estaba implemetando la interface WindowListener
 * lo que me obligaba a sobtreescribir todos los metosdos
 * incluidos en esa interface, ahora en vez de eso EXTENDERE
 * y por tanto heredare los metodos de las clases ADAPTADORAS
 * tales como keyAdapter,WindowAdapter y MouseAdapter y solo
 * implemetare exclusivamente los emtodos que requiera*/
class M_Ventana extends WindowAdapter{
	
	public void windowIconified(WindowEvent e) {
		//Evento ventana minizada
		System.out.println("Ventana minimizada");
	}
	
	

}



	 

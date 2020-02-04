package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.*;
public class CambioEstado {
	public static void main(String [] args) {
		MarcoEstado miMarco = new MarcoEstado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoEstado extends JFrame{
	
	public MarcoEstado() {
		setVisible(true);
		setBounds(450,250,300,300);
		addWindowStateListener(new CambiaEstado( ));
	}
}

//WindowStateListener detecta el cambio 
//de estado de la ventana
class CambiaEstado implements WindowStateListener{

	public void windowStateChanged(WindowEvent e) {
		 
		//System.out.println("La ventana ha cambiada de estado ");
		//System.out.println(e.getNewState());
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("Se ha activado la pantalla completa");
		}else if(e.getNewState()==Frame.NORMAL) {
			System.out.println("La pantalla esta en estado Normal");
		}else if(e.getNewState()==Frame.ICONIFIED) {
			System.out.println("La pantalla esta minimizada");
		}
	}
	
}
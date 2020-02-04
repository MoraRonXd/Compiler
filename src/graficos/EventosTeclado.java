package graficos;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado {
	
	public static void main(String [] agrs) {
		MarcoConTeclas miMarco=new MarcoConTeclas();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class MarcoConTeclas extends JFrame{
	
	public MarcoConTeclas() {
		setVisible(true);
		setBounds(450,150,400,400);
		EventoDeTeclado tecla =new EventoDeTeclado();
		addKeyListener(tecla);
	}
}

class EventoDeTeclado implements KeyListener{

	
	public void keyPressed(KeyEvent e) {
		 int codigo=e.getKeyCode();
		System.out.println(codigo);
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		
	}


	public void keyTyped(KeyEvent e) {
		char letra=e.getKeyChar();
		System.out.println(letra);
		 
	}
	 
}
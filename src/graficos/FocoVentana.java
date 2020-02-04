package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class FocoVentana extends JFrame implements WindowFocusListener {
	public static void main(String [] args) {
		
		FocoVentana miv=new FocoVentana();
		miv.iniciar();
		
	}
		
	public void iniciar() {//metodo donde se construiran los marcos
		//es como hacer un constructor
		marco1=new FocoVentana();
		marco2=new FocoVentana();
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(200, 100,400,400);
		marco2.setBounds(800, 100,400, 400);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//El argumento o parametro que debo pasar a este metodo
		// addWindowFocusListener() es la instancia de la clase oyente,
		//pero como la clase oyente es la propia clase donde estoy
		//(implements WindowFocusListener) puedo usar la instruccion this
		//para hacer referencia a la propia clase donde me encuentro
		
		marco1.addWindowFocusListener(this);//poniendolo a la escucha
		marco2.addWindowFocusListener(this);//poniendolo a la escucha 
		
	
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource()==marco1) {
			marco1.setTitle("Tengo el Foco =) !!");
		}else {
			marco2.setTitle("Tengo el Foco =) !!");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		if(e.getSource()==marco1) {
			marco1.setTitle("Perdi el Foco =( ");
		}else {
			marco2.setTitle("Perdi el Foco =( ");
		}
	}
	
	FocoVentana marco1,marco2;
} 

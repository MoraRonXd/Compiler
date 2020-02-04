package graficos;
import javax.swing.*;
import java.awt.event.*;

public class EventosRaton {
	public static void main (String[] args) {
		
		MarcoRaton miMarco = new MarcoRaton();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoRaton extends JFrame{
	public MarcoRaton() {
	setTitle("Detectando Mouse");
	setBounds(450,150,400,400);
	setVisible(true);
	//Acciones ligadas a EventosDeRaton
	EventosDeRaton raton=new EventosDeRaton();
	addMouseListener(raton);
	
	//Acciones ligadas a EventosDeratonEnMovimiento
	EventosDeRatonEnMovimiento ratonMovido =new EventosDeRatonEnMovimiento();
	addMouseMotionListener(ratonMovido);
	}
}
/*Si no quiero implementar la interface por que ten=ndria que 
 * implementar todos sus metodos, tambien podria heredar de la
 * clase MouseAdapter y solo sobreescribir el que necesito
 
class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(e.MOUSE_CLICKED);
		System.out.println("Se hizo click en el frame");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("acabas de entrar al frame");	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("acabas de salir del frame");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("El boton ha sido presonado en el frame");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("has soltado el boton");
		
	}
	
}*/
class EventosDeRaton extends MouseAdapter{
	/*public void mouseClicked(MouseEvent e) {
		//System.out.println("Coodenada X "+e.getX()+" Coodenada Y "+e.getY());
		System.out.println(e.getClickCount());
	}*/
	
	public void mousePressed(MouseEvent e) {
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has pulsado el boton Izquierdo");
		}else if (e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
			System.out.println("Has pulsado la rueda del raton");
		}else {
			System.out.println("Has pulsado el boton Derecho");
		}
		
	}
}
class EventosDeRatonEnMovimiento implements MouseMotionListener{
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estas arrastrando");
	}
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estas moviendo");
	}
}
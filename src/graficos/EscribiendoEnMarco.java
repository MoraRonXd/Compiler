package graficos;
import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
	public static void main(String[] args) {
		MarcoConTexto miMarco=new MarcoConTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoConTexto extends JFrame{
	public MarcoConTexto() {
		setVisible(true); //marco se hace visible
		setSize(600,450); //define tamanio
		setLocation(400,200);//define ubicacion
		setTitle("Primer Texto");
		
		Lamina miLamina= new Lamina();
		add(miLamina);
	}
}

class Lamina extends JPanel{
	//sobreesribiendo el metodo paintComponent para pintar 
	//lo que yo quiera
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawString("Estamos aprendiendo Swing", 100, 100);
	}
}
package graficos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PruebaEventos {
	public static void main(String[] args) {
		MarcoBotones miMarco=new MarcoBotones();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoBotones extends JFrame{
	public MarcoBotones() {
		 setTitle("Marco con Botones");
		 setBounds(400,200,500,300);
		 LaminaConBotones miLamina=new LaminaConBotones();
		 add(miLamina);
	}
}
class LaminaConBotones extends JPanel {
	/*En la propia lamina (LaminaCnnBotones) la que debe 
	 * imp[lemetar la interface ActionListener ya que es ella 
	 * la que quien recibira el evento*/
	
	//instanciando un boton col la clase JButton
	//Evento 1: hacer clic en el boton(evento)
	//Evento 2 : objeto desencadenante del evento:
	//objeto fuente (el botonen si)
	//Evento 3: Objeto destino o receptor del evento
	//(obje listener): la propia lamina p q quiero que 
	//se ponga azul
	
	     //Factor 2.objeto desencadenante del evento. 
	     //ESTE BOTON
	JButton botonAzul=new JButton("Azul");
	JButton botonRojo=new JButton("Rojo");
	JButton botonAmarillo=new JButton("Amarillo");
	 
	 //luego con el constructor agrego el boton a la lamina
	 public LaminaConBotones() {
		 //Factor 1. hacer clik en este boton(desencadenando un)
		 //objeto de tipo click addActionListener
		 add(botonAzul);
		 add(botonRojo);
		 add(botonAmarillo);
		 
		 ColorFondo Amarillo =new ColorFondo(Color.YELLOW);
 		 ColorFondo Azul =new ColorFondo(Color.BLUE); 
		 ColorFondo Rojo =new ColorFondo(Color.RED);
		 
		 botonAzul.addActionListener(Azul);
		 botonRojo.addActionListener(Rojo);
		 botonAmarillo.addActionListener(Amarillo);
		 	 
	 }

//clase oyente a la espera de eventos con raton (ActionListener)
private	class ColorFondo implements ActionListener{
			
		public ColorFondo(Color c) {
				colorDeFondo=c;
		}
			
		public void actionPerformed(ActionEvent e) {
				setBackground(colorDeFondo);
		}
		private Color colorDeFondo;
	}	 
	 
}

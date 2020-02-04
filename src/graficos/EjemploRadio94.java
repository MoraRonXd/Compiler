package graficos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*En este ejemplo se creare un marco con un texto y debajo de ese texto 
 * aparezcoan unos botones de radio para que al pulsar sobre los botones
 * el tamanio del texto pueda cambiar*/

public class EjemploRadio94 {
	public static void main(String [] args) {
		MarcoRadio miMarco=new MarcoRadio();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoRadio extends JFrame{
	public MarcoRadio() {
		setTitle("Componentes Swing. Boton de Radio II. V 94");
		setBounds(350,200,500,400);
		LaminaRadio1 miLamina=new LaminaRadio1();
		add(miLamina);
		
	}
}

class LaminaRadio1 extends JPanel{
	
	public LaminaRadio1() {
		//indicando la dispocicion de los elemnetos en lamina
		setLayout(new BorderLayout());
		
		//creando el texto a utilizar para cambiar el tamanio del mismo
		texto= new JLabel("En un lugar de la mancha cuyo nombre... ");
		
		// definiendo las caracteristicas del texto por defecto en el nuevo esquema
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		
		add(texto,BorderLayout.CENTER);
		
		laminaBotones= new JPanel();
		
		miGrupo=new ButtonGroup();
		
		colocarBotones("Pequenio",false,10);
		colocarBotones("mediano",true,12);
		colocarBotones("Grande",false,18);
		colocarBotones("Muy Grande",false,24);
		
		add(laminaBotones,BorderLayout.SOUTH);
		
		
		//&*&*&*&*&*&*&*&*&*&*&*&**&**&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*
		/*ButtonGroup miGrupo=new ButtonGroup();
		
		boton1=new JRadioButton("Pequenio",false);
		boton2=new JRadioButton("Mediano",true);
		boton3=new JRadioButton("Grande",false);
		boton4=new JRadioButton("Muy Grande",false);
		
		//Lamina contentiva de los botones
		JPanel laminaRadio = new JPanel();
		
		//poniendo a la escucha los botenos por medio de la instanciacion de la 
		//clase interna creada para ello mas abajo
		
		EventoRadio miEvento= new EventoRadio();
		
		//a la escucha los botones 
		
		boton1.addActionListener(miEvento);
		boton2.addActionListener(miEvento);
		boton3.addActionListener(miEvento);
		boton4.addActionListener(miEvento);
		
		//agregandolos al grupo
		miGrupo.add(boton1);
		miGrupo.add(boton2);
		miGrupo.add(boton3);
		miGrupo.add(boton4);
		
		//agregandolos a la lamina de los botones
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		
		//agregar la lamina de los botones a la lamina principal, zona sur.
		//esto es posible por que estoy en el constructor de la lamina principal
		add(laminaRadio,BorderLayout.SOUTH);
		*///&*&*&*&*&*&*&*&*&*&*&*&*&*&*&***&*&*&*&*&*&*&**&*&*&*&*&*&*&*&*&*
		
	}
	/*nuevo esquema del programa se creara un metodo para gestdionar toda la 
	  funcionalidad, por una parte construye el boton, con su nombre diciendo
	  si esta seleccionado o no con:
	    JRadioButton boton =new JRadioButton(nombre,seleccionado)
	  se encargara de agrupar el boton con:
	    miGrupo.add(boton);
	  y tambien se encargarlo a la lamina:
	     laminaBotones.add(boton);
	  Por ultimo lo pondra a la escucha:
	  
	  ActionListener miEvento= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif",Font.PLAIN, tamagno));
			}
		}; 
		boton.addActionListener(miEvento);
	   
	  */
	
	public void colocarBotones(String nombre, boolean seleccionado,final int tamagno) {
		
		JRadioButton boton =new JRadioButton(nombre,seleccionado);
		
		miGrupo.add(boton);//con esto todos los botones que construya el metodo
		//colocar botones se agreguen al grupo
		
		laminaBotones.add(boton);
		
		ActionListener miEvento= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif",Font.PLAIN, tamagno));
			}
		}; 
		boton.addActionListener(miEvento);
	}
	
	
	//Esta clase interna funciona perfectamente pero lo hare de otra forma
	//ahorras codigo
	//clase interna que se encarga de gestinar los eventos (evento click)
	
	//****************************
	/*private class EventoRadio implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boton1) {
				texto.setFont(new Font("Serif",Font.PLAIN,10));
			}else if(e.getSource()==boton2) {
				texto.setFont(new Font("Serif",Font.PLAIN,15));
			}else if(e.getSource()==boton3) {
				texto.setFont(new Font("Serif",Font.PLAIN,20));
			}else if(e.getSource()==boton4) {
				texto.setFont(new Font("Serif",Font.PLAIN,30));
			}
			
		}
		
	}*///                           *****************************                               
	private JLabel texto;
	private JRadioButton boton1,boton2,boton3,boton4;
	private ButtonGroup miGrupo;
	private JPanel laminaBotones; 
}
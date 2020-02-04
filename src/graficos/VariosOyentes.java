package graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*En este ejemplo busco tener una lamina con dos dos botones
 * nuevo y cerrar. El boton nuevo creara cada vez que sea pulsado
 * una nueva lamina, mientras que el boton cerrar cerrara todas
 * las laminas creadas.Por tanto este ultimo me servira para 
 * entender el concepto de oyente multiple ya que todas las 
 * ventanas deban cerrarse cuando se pulce el boton cerrar de frame
 * principal */

public class VariosOyentes {
	public static void main(String []args) {
		MarcoPrincipal miMarco=new MarcoPrincipal();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoPrincipal extends JFrame{
	public MarcoPrincipal() {
		setTitle("Prueba Varios");
		setBounds(900,100,300,200);
		LaminaPrincipal lamina=new LaminaPrincipal();
		add(lamina);
		
	}
}

class LaminaPrincipal extends JPanel{
	public LaminaPrincipal() {
		JButton botonNuevo=new JButton("Nuevo");
		//botonNuevo es una fuente de evento para crear nuevos
		//frames, esto se consigue instanciando la clase
		//OyenteNuevo para luego indicar que el botonNuevo
		//usara el metodo addActionListener indicando asi que es 
		//es un generador de eventos y entre ()elnombre de 
		//instancia de la clase oyente
		add(botonNuevo);
		botonCerrar=new JButton("Cerrar");
		add(botonCerrar);
		
		//instaranciando la clase interna OyenteNuev0
		OyenteNuevo miOyente=new OyenteNuevo();
		botonNuevo.addActionListener(miOyente);//indico asique
		//el botonNuevo es un oyente y de ser precionado
		//activara el metodo actionPerformed el cual crearar un
		//MarcoEmergente cada vez que se le presione
	
	}
	
	private class OyenteNuevo implements ActionListener{
		/*clase interna oyente(Actionlistener) del evento 
		 * crear ventena nueva con el boton "nuevo". Esta 
		 * interface tiene solo un metodo que implementar
		 * "actionPerformed"*/
		
		public void actionPerformed(ActionEvent e) {
			/*El trabajo de este metodo sera crear una
			 * instancia de la clase MarcoEmergente*/
			MarcoEmergente marco=new MarcoEmergente(botonCerrar);
			marco.setVisible(true);
			/*Posteriormente debo decirle al boton nuevo
			 * que sea una fuente de evento.Procedo asi:
			 * Dentro del constructor de la lamina donde esta
			 * el elemento fuente de evento(boton) creare una 
			 * instancia de la clase interna(oyenteNuevo) y 
			 * luego decir que el boton "Nuevo" llamando al 
			 * metodo addActionListener(nombre de la instancia) */
		}
		
	}
	JButton botonCerrar;
}

class MarcoEmergente extends JFrame{
	/*Aqui lo mas importante del programa...esta clase 
	 * MarcoEmergente su constructor debe recibir por parametro
	 * el botonCerrar para poder tener acceso a el ya que 
	 * pertenece a la clase LaminaPrincipal, sin embargo
	 * no es agregado, pero esto me permite manipularlo
	 * en el constructor y decir que este boton recibido
	 * es el desencadenante del evento o fuente*/
	public MarcoEmergente(JButton boton_de_principal) {
		
		contador++;
		setBounds(40*contador,40*contador,300,150);
		
		setTitle("Ventana "+contador);
		
		//Instanciando la clase interna oyente(CierraTodo)
		CierraTodos oyentecerrar=new CierraTodos();
		
		/*Aca digo que boton_de_principal (parametro
		 * recibido por el constructor) tiene que ser la 
		 * fuente, con el metodo addActionListener() */
		boton_de_principal.addActionListener(oyentecerrar);  
		
	}
	/*Estoy en el caso que tengo un objeto fuente(boton Cerrar)
	 * y varios objetos oyentes(todas las instancias de marco
	 * emergente).La clase oyente tendra que estar dentro de 
	 * MarcoEmergente(Clase interna) ya que los marcos que quiero
	 * cerrar son lo emergentes, es decier al recibir un evento del
	 * botonCerrar ,se cierren todas las instancias,por esta razon la clase 
	 * oyente debe ser una clase interna de MarcoEmergente*/
	private class CierraTodos implements ActionListener{
		/*Este metodo actionPerformed debe es cerrar
		 * el propio objeto*/
		public void actionPerformed(ActionEvent e) {
			
			dispose();
		}
		
	}
	private static int contador=0;
}
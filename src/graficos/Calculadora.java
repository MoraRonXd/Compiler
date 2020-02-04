package graficos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {
	public static void main(String [] args) {
		MarcoCalculadora marco=new MarcoCalculadora();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}
}

class MarcoCalculadora extends JFrame {
	public MarcoCalculadora() {
		setTitle("Marco Calculadora");
		setBounds(350,200,450, 300);
		add(new LaminaCalculadora());
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		principio=true;
		setLayout(new BorderLayout());
		pantalla=new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		
		miLamina2=new JPanel();
		miLamina2.setLayout(new GridLayout(4,4));
		
		ActionListener insertar=new InsertaNumero();
		
		ActionListener orden=new AccionOrden();
		  
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/",orden);
		
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("x",orden);
		
		ponerBoton("3",insertar);
		ponerBoton("2",insertar);
		ponerBoton("1",insertar);
		ponerBoton("-",orden);
		
		ponerBoton("0",insertar);
		ponerBoton(".",orden);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		
		add(miLamina2,BorderLayout.CENTER);
		ultimaOperacion="=";
		
	}
	private void ponerBoton(String rotulo, ActionListener oyente) {
		JButton boton=new JButton(rotulo);
		boton.addActionListener(oyente);
		miLamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			/*este metodo perteneciente a la la clase actionEvent permire guardar
			 * el texto del boton pulsado. Luego necesito hacer que en la pantalla
			 * aparesca ese texto*/
			String entrada=e.getActionCommand();
			 
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			/*El metodo setText() permite establecer un texto en el objeto que 
			 * lo invoca(objeto del boton)*/
			pantalla.setText(pantalla.getText()  +entrada);
		}
		
	}
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String operacion=e.getActionCommand();
			//System.out.println(operacion);
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion=operacion;
			
			 principio=true; 
		}
		
		public void calcular(double x) {
			if(ultimaOperacion.equals("+")) {
				resultado+=x;
			}else if(ultimaOperacion.equals("-")) { 
				resultado-=x;
			}else if(ultimaOperacion.equals("x")) {
				resultado*=x;
			}else if(ultimaOperacion.equals("/")) {
				resultado/=x;
			}else if(ultimaOperacion.equals("=")) {
				resultado=x;
			}
			pantalla.setText(""+resultado);
		}
		
	}
	private JButton pantalla;
	private JPanel miLamina2;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
}
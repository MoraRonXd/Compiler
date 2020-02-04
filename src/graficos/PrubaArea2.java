package graficos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*en este ejemplo se construira un gran area de texto en la zona central y del marco
 * y luego en la zona inferior se colocaran 2 botones, uno de ello insertara un 
 * texto y otro que quitara saltos de linea en el are ade texto. Este ejemplo sera 
 * atipico con respecto a los anteriores ya que programaremos todo el codigo en 
 * una sola clase, este metodo esta desaconcejado pero igual se tocara para ver todos
 * los puntos de vista*/

public class PrubaArea2 {
	public static void main(String []args) {
		MarcoPruebaArea miMarco=new MarcoPruebaArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoPruebaArea extends JFrame{
	MarcoPruebaArea(){
		
		setTitle("Componentes Java Swing. Area de texto II. Video 91");
		setBounds(450,200,500,350);
		
		setLayout(new BorderLayout());/*con esto se le dice al MARCO que debe tener
		una disposicion de tipo BorderLayout*/
		laminaBotones= new JPanel();
		botonInsertar=new JButton("Insertar");
		botonInsertar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				areaTexto.append("En un lugar de la mancha cuyo nombre no quiero acordarme....");
				
			}
			
		});
		
		laminaBotones.add(botonInsertar);//agregando boton de insertar texto
		
		botonSaltoLinea =new JButton("Salto Linea");
		botonSaltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean saltar =!areaTexto.getLineWrap();
				/*La api nos informa que el metodo getLineWrap nos regresa un valor
				 * booleno el cual informa si hay saltos de linea o no en un texto.
				 * Posteriormenet quierp establecer un salto de linea(sabiendo que por def
				 * ecto las areas de texto no tienen saltos de linea )*/
				
				areaTexto.setLineWrap(saltar);/*aca almacenamos dentro de la variable 
				saltar lo contrario de lo que haya en el area de texto, si en area de texto
				no hay saltos de texto se almacenara en saltar un TRUE, por tanto el metodo
				areaTexto.setLineWrap(saltar) ESTABLECERA el salto de linea siempre que 
				se pulse el boton,si pasa el caso contrario se almacenara false y se hara lo 
				inverso quitando el salto de linea */
				
				/*if(saltar) {
					botonSaltoLinea.setText("Quitar salto");
				}else {
					botonSaltoLinea.setText("Salto Linea");
				}*/
				
				//condicional con operador ternario
				
				
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Linea");
			}
			
		});
		
		laminaBotones.add(botonSaltoLinea);//agregando boton de salto de linea
		add(laminaBotones,BorderLayout.SOUTH);/*con esto la lamina con los dos botones 
		queda en la zona de abajo del marco*/
		
		areaTexto=new JTextArea(8,20);/*el area de texto fue definida abajo pero
		iniciadad aca, los numeros entre parentesis indical el numero de columnas 
		y filas que tendra el area de texto*/
		
		/*ahora como quiero que esta area de texto tenga barras de desplazamiento
		 *debo agregarla a una lamina de tipo JScrollPane , la cuan feu definida 
		 *tambien mas abajo */
		
		 laminaConBarras =new JScrollPane(areaTexto);/*con esto ya tenemos el area 
		 de texto dentro de la laminaConBarras, luego se debe agregar esta 
		 lamianConBarras a la zona central*/
		 
		 add(laminaConBarras,BorderLayout.CENTER);
		
	}
	private JPanel laminaBotones;
	private JButton  botonInsertar;
	private JButton botonSaltoLinea;
	private JScrollPane laminaConBarras;
	private JTextArea areaTexto;
	
}
package graficos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/*Con este ejercicio se busca incluir los siguiente elementos a una lamina:
 * dos etiquetas con sus respectivos cuadros de texto que informen al usuario, 
 * los cuales seran usuario y contracenia. El campo contracenia debe ser invisible,
 * es decir debe ocultar en asteriscos lo que el usuario este tecleando, para luego 
 * incluir tambien un boton que se usaria para enviar los datos a algun lado requerido
 * , esto lo hare aplicando Layouts para definir las dispocisiones de los elementos */

public class CampoPassword {
	public static void main(String [] args) {
		MarcoPassword miMarco=new MarcoPassword();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
class MarcoPassword extends JFrame{
	public MarcoPassword() {
		setTitle("Eventos en Cuadro de texto II. Video 89");
		setBounds(350,200,550,400);
		LaminaPassword miLamina=new LaminaPassword();
		add(miLamina);
		setVisible(true);
	}
}

class LaminaPassword extends JPanel{
	public LaminaPassword() {
		setLayout(new BorderLayout());//para la primera lamina
		
		JPanel lamina_superior =new JPanel();
		lamina_superior.setLayout(new GridLayout(2,2));//segunda lamina
		
		add(lamina_superior,BorderLayout.NORTH);//con esto digo que la segunda lamina
		//debe estar en la parte norte de la lamina principal, esto se consigue con el 
		//metodo add, especificamente alq ue se le pasa por parametros la lamina en si
		//y la region de la lamina principal donde esta estara.
		
		JLabel etiqueta1 = new JLabel("Usuario");//instanciando para las etiquetas
		JLabel etiqueta2= new JLabel("Contracenia");// con el correspondiente texto
		
		JTextField c_usuario=new JTextField(15);//cuadro de texto para que el usuario 
		                                        //introduzca nombre de usuario con longitude de 15 columnas
		
		c_contra= new JPasswordField(15);//la funcionalidad de esta clase
		//es la misma de JTextField pero cambia por asteriscos el texto
		
		CompruebaPass miEvento =new CompruebaPass();
		
		//aca pongo a al escucha a c_contra del evento de tipo document
		c_contra.getDocument().addDocumentListener(miEvento);
		
		/*Luego de  construir los todos los elementos de sebe decir donde deben estar 
		 * ubicados.Tantos las etiquetas como los JLabels y el JPassword tienen que ir 
		 * en la lamian superior*/
		lamina_superior.add(etiqueta1);//primer Jlabel
		lamina_superior.add(c_usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(c_contra);
		
		//boton el la lamina inferior 
		JButton enviar = new JButton("Enviar");
		
		add(enviar,BorderLayout.SOUTH);
		
	}
	/*clase interna receptora de eventos*/
	private class CompruebaPass implements DocumentListener{

		public void changedUpdate(DocumentEvent e) {
			
			
		}

		public void insertUpdate(DocumentEvent e) {
	      //usare este metodo p q se ejecuta cada vez que el usuario inserta un 
		 //caracter y quiero que compruebe la longitud cada vez que ese intruduzca
		//un caracter
			char contracena [];
			contracena=c_contra.getPassword();
			if(contracena.length<8 || contracena.length>12) {
				c_contra.setBackground(Color.RED);	
			}else {
				c_contra.setBackground(Color.WHITE);
				/*luego de este punto se debe instanciar esta clase y poner
				 * el al campo contracena a la escucha usando el metodo getDocument*/
			}
		}

		public void removeUpdate(DocumentEvent e) {
			char contracena [];
			contracena=c_contra.getPassword();
			if(contracena.length<8 || contracena.length>12) {
				c_contra.setBackground(Color.RED);	
			}else {
				c_contra.setBackground(Color.WHITE);
				
			}
			
		}
		
	}
	private JPasswordField c_contra; 
}
package graficos;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
/*Con este sencillo programa busco controlar la forma de controlar los eventos 
 * que pueden ocurrir en un cuadro de texto, tanco como cuando el usuario introduce 
 * o borra el texto */

public class PruebaCuadroTexto {
	public static void main(String [] args) {
		MarcoPrueba miMarco =new MarcoPrueba();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPrueba extends JFrame{
	
	public MarcoPrueba() {
		setTitle("Eventos de cuadro de texto I video. Video 88");
		setBounds(350,200,500,350);
		LaminaPrueba miLamina1=new LaminaPrueba();
		add(miLamina1);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel{
	
	public LaminaPrueba() {
		
		miCampo = new JTextField(20);
		
		EscuchaTexto el_evento= new EscuchaTexto();
		
		Document miDoc=miCampo.getDocument();//el metodo getDocument(class JTextField)
		//devuelve un objeto de tipo Documents, debo entonces crear una instancia de
		//la interface Document
		
		miDoc.addDocumentListener(el_evento);//con esto pondo el documento a la escucha 
		//pasandole una instancia de la clase que maneja estos eventos
		
		add(miCampo);
		
	}
	

	
	private class EscuchaTexto implements DocumentListener{

		public void changedUpdate(DocumentEvent e) {
			
			
		}

		public void insertUpdate(DocumentEvent e) {
			System.out.println("has insertado texto");
		}

		public void removeUpdate(DocumentEvent e) {
			System.out.println("has borrado texto");
			
		}
		
	}
	JTextField miCampo;
	
}
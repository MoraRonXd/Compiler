package graficos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*Este ejemplo busca establecer un texto con una frase cualquiera  en la parte
 *  superior, y luego en la parte iunferior aparescan los dos checkbox.Estos 
 *  checkbox permitiran modificar algunas de las caracteristicas del texto que esta 
 *  arriba, por ejem el checkbox de la parte izquierda establecera letra negrita para 
 *  el texto y en siguiente checkbox cambiara a cursiva la letra del texto*/
public class PruebaChecks {
	public static void main(String [] args) {
		MarcoChecks miMarco=new MarcoChecks();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoChecks extends JFrame{
	public MarcoChecks() {
		setTitle("Componentes Swing CheckBox. video 92");
		setBounds(400,200, 500,300);
		LaminaChecks miLamina=new LaminaChecks();
		add(miLamina);		 
	}
}

class LaminaChecks extends JPanel{
	public LaminaChecks() {
		setLayout(new BorderLayout());/*con esto le decimos a la pagina principal 
		que tendra este tipo de distribucion*/
		
		//el texto que aparecera debe tener unas caracteristicas por defecto, para
		//para ello intancio la clase Font
		
		Font miLetra=new Font("Serif",Font.PLAIN, 24);
		//a continuacion creare el texto, iniciando el JLabel que se definio antes 
		
		texto=new JLabel("En un lugar de la mancha de cuyo nombre....");
		
		//ahora el texto en custion debe tomar la caracteristicas del font definido antes
		texto.setFont(miLetra);//SetFont permite establecer un tipo de letra y pide 
		//por parametro un objeto de tipo font
		
		/*paso siguyiente crear una lamina para incluir esa lamina en la zona siperior
		 *dende se encuentre este tipo de letra*/
		
		JPanel laminaTexto=new JPanel();//ahora agrego el texto a la lamina
		
		laminaTexto.add(texto); // ahora debo colocarla 
		
		add(laminaTexto,BorderLayout.CENTER);
		
		//luego creando los JCheckBoxs para aqgregarlos a otra lamina que aun no tengo
		//y esa lamina agregarla a la zona sur de la lamina princial
		
		check1=new JCheckBox("Negritas");
		check2=new JCheckBox("Cursiva");/*antes de agregarlos a la lamina se les 
		debe poner a la escucha de un evento de tipo ActionListener(es decir de clik),
		para esto debo instanciar la clase que manejara los checks*/
		
		//forma Larga 
		ManejaChecks miEvento1 =new ManejaChecks();
		check1.addActionListener(miEvento1);
		
		//forma Corta 
		check2.addActionListener(new ManejaChecks());
		
		/*ya que estan los dos elementos a la escucha tengo que crear la lamina
		 * donde iran estos elemntos. Esta lamina sera colocada en la zona inferior
		 * de la lamina principal */
		JPanel laminaChecks = new JPanel();
		
		laminaChecks.add(check1);
		laminaChecks.add(check2);// puestos en la lamina 
		
		//colocando la lamina en la zona sur
		
		add(laminaChecks,BorderLayout.SOUTH);
		
		
	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int tipo=0;
			if(check1.isSelected()) tipo+=Font.BOLD;
			if(check2.isSelected()) tipo+=Font.ITALIC;
			texto.setFont(new Font("Serift",tipo,24 ));
			
		}
		
	}
	
	private JLabel texto;
	private JCheckBox check1,check2;
}
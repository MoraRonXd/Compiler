package graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import com.mbxd.Compiler.Compiler;

public class EjemploArea {
	public static void main(String [] args) {
		MarcoArea miMarco= new MarcoArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoArea extends JFrame{
	public MarcoArea() {
		setTitle("Componetes Swing.Areas de texto I.video 90 ");
		setBounds(350,200,500,400);
		LaminaArea miLamina=new LaminaArea();
		add(miLamina);
		setVisible(true);
		
	}
}

class LaminaArea extends JPanel{
	public LaminaArea() {
		miArea=new JTextArea(8,20);
		
		miArea.setLineWrap(true);// con este metodo se controla que horizontalemte
		/*no se alargue el area de texto, sino , que exista saltos de linea. Sin
		//emabargo no podemos hacer esto de manera vertical. Para esto debemos*
		 * debemos intanciar una nueva lamina donde sera insetrado este este
		 * elemento, la cual tendra el comportamiento de abarras de scroll
		 * con la clase JScrollPane*/
		
		JScrollPane laminaBarras = new JScrollPane(miArea);
		add(laminaBarras);
		
		JButton miBoton =new JButton("Consola");
		
		miBoton.addActionListener(new GestionaArea());/*poniendo el boton a la 
		escucha con el metodo addActionListener y como argumeto la instancia de 
		la clase que gestiona el evento(GestionarArea en este caso)*/
		
		add(miBoton);
	}
	
	class GestionaArea implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
			/*el desempenio de este metodo debe ser 
			 * rescatar lo que este en el area de texto y mostaralo 
			 * en consola*/
			/*String miTexto=miArea.getText();
			System.out.println(miTexto);*/
			
			Compiler miCompilador=new Compiler(miArea.getText(), true);
			try {
				miCompilador.tokenize();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private JTextArea miArea;
}
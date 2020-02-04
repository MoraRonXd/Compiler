package graficos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaTexto {
	public static void main(String [] args) {
		MarcoTexto miMarco=new MarcoTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoTexto extends JFrame{
	public MarcoTexto() {
		setTitle("Marco con texto video 86");
		setBounds(350,200,600,350);
		
		LaminaTexto lamina=new LaminaTexto();
		add(lamina);
	}
}

class LaminaTexto extends JPanel{
	
	public LaminaTexto() {
		setLayout(new BorderLayout());//con esto digo que la lamina principal tiene
		//una dispocision de borderlayout, es decir norte, sur,este y oeste
		
		JPanel lamina2=new JPanel();
		
		lamina2.setLayout(new FlowLayout());//la lamina secundaria tendra con esto
		//todos los elementos en fila uno a continuacion del otro
		
		resultado = new JLabel("",JLabel.CENTER);
		
		JLabel texto1=new JLabel("Email");
		
		lamina2.add(texto1); 
		
		campo1=new JTextField(20);
		
		lamina2.add(campo1);
		
		add(resultado,BorderLayout.CENTER);
		
		JButton miBoton=new JButton("Comprobar");//creando el boton
		
		DameTexto mievento=new DameTexto();    //instanciando el evento correspondiente
		
		miBoton.addActionListener(mievento); //poniendo el boton a la escucha del evento click
		
		lamina2.add(miBoton);      //adicionando el boton al panel
		
		//con lo siguiente agregare la lamina 2 en la zona norte de la lamina principal
		
		add(lamina2,BorderLayout.NORTH);//uno de los constructores del matodo add
		//
		
	}
	
private	class DameTexto implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			System.out.println();
			
			String email=campo1.getText().trim();
			
			boolean comprobacion=false;
			boolean comprobacion2=false;
			//***comprobando un solo @ en el email**
			int j=0;
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='@') {
					comprobacion=true;
					j++;
				}
			}
			//***comprobando un solo punto (.) en el imail**
			int p=0;
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='.') {
					comprobacion2=true;
					p++;
				}
			}
			if(comprobacion && j<2 &&comprobacion2 && p<2) {
				
				resultado.setText("Correcto");
			}else {
				resultado.setText("Mail invalido");
			}
		}
		
	}
private JTextField campo1;
private JLabel resultado;
}
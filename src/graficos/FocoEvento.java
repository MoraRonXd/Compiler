package graficos;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class FocoEvento {
	public static void main(String[] args) {
		MarcoFoco miMarco=new MarcoFoco();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoFoco extends JFrame{
	public MarcoFoco(){
		setTitle("Ventana 1 cambio de Foco");
		setBounds(450,100,400,400);
		setVisible(true);
		add(new LaminaFoco());
	}
}

class LaminaFoco  extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 setLayout(null);//esto me permite posicionar los 
		 //elementos donde yo disponga
		 
		 cuadro1= new JTextField();
		 cuadro2= new JTextField();
		 
		 cuadro1.setBounds(80,10, 150,20);
		 cuadro2.setBounds(80, 50,150,20);
		 add(cuadro1);
		 add(cuadro2);
		 
		 LanzaFocos elFoco=new LanzaFocos();
		 cuadro1.addFocusListener(elFoco);//con esto ponemos al obj
		 //cuadro1 a la escucha
		 
	}
	JTextField cuadro1,cuadro2; //variables objeto tipo JTextField

private class LanzaFocos implements FocusListener{
	
	public void focusGained(FocusEvent e) {
		System.out.println("El cuadro 1 ha OBTENIDO el Foco");
	}
	public void focusLost(FocusEvent e) {
		//validacion de direcion de corre luego de perder el foco el cuadro1
		String email=cuadro1.getText();
		
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
			System.out.println("EL mail es correcto");
		}else {
			System.out.println("Mail invalido");
		}
	}
}
	
	
}
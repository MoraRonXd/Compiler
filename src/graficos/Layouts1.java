package graficos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Layouts1 {
	public static void main(String [] args) {
		MarcoLayout miMarco=new MarcoLayout();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoLayout extends JFrame{
	public MarcoLayout() {
		setTitle("Prueba Acciones");
		setBounds(300,100,600,300);
		
		PanelLayout lamina=new PanelLayout();
		setVisible(true);
		
		//FlowLayout disposicion=new FlowLayout(FlowLayout.LEFT);
		//lamina.setLayout(disposicion);
		//mas eficiente asi 
		
		
		add(lamina,BorderLayout.NORTH);
		add(new PanelLayout2(),BorderLayout.SOUTH);
		
	}
	
}

class PanelLayout extends JPanel{
	
	public PanelLayout() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		
	}
}
class PanelLayout2 extends JPanel{
	public PanelLayout2() {
		setLayout(new BorderLayout());
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton ("Verde"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);
	}
}
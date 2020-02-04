package graficos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaCombo95 {
	public static void main(String []args) {
		MarcoCombo miMarco= new MarcoCombo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoCombo extends JFrame{
	public MarcoCombo() {
		setTitle("Comonentes Swing. ComboBox.video 95");
		setBounds(350,100,600,400);
		LaminaCombo miLamina =new LaminaCombo();
		add(miLamina);
		
	}
}

class LaminaCombo extends JPanel{
	public LaminaCombo() {
		setLayout(new BorderLayout());
		
		texto=new JLabel("En un lugar de la mancha de cuyo nombre...");
		
		texto.setFont(new Font("Serif",Font.PLAIN,18));

		add(texto,BorderLayout.CENTER);
		
		JPanel laminaNorte = new JPanel();
		
		miCombo = new JComboBox();
		
		miCombo.setEditable(true);
		
		miCombo.addItem("Serif");
		
		miCombo.addItem("SansSerif");
		
		miCombo.addItem("Monospaced");
		
		miCombo.addItem("Dialog");
		
		laminaNorte.add(miCombo);
		
		EventoCombo miEvento =new EventoCombo();
		
		miCombo.addActionListener(miEvento);
		
	    add(laminaNorte,BorderLayout.NORTH);
	    
	}
	class EventoCombo implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//se hizo una refundicion en el constructor del metodo setFont
			//p q los parametros que este metodo espera son un String, el formato del
			//tipo de letra y el tamano. por otro lado el metodo getSelected entrega 
			//un elemento de tipo Objet y se necesita es un String, por tanto se hace 
			//se hace el casting
			texto.setFont(new Font((String)miCombo.getSelectedItem(),Font.PLAIN,18));
		}
		
	}
	
	
	private JLabel texto;
	private JComboBox miCombo;
}
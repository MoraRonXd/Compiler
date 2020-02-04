package graficos;
import java.awt.Font;

import javax.swing.*;

public class MarcoSliders96 {
	public static void main(String []args) {
		MarcoSliders miMarco=new MarcoSliders();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoSliders extends JFrame{
	public MarcoSliders() {
		setTitle("Componetes Swing.JSliders.Video 96");
		setBounds(350,150,500,400);
		PanelSliders miPanel=new PanelSliders();
		add(miPanel);
	}
}

class PanelSliders extends JPanel{
	public PanelSliders() {
		JSlider control=new JSlider(0,100,50);
		
		control.setMajorTickSpacing(50);
		
		control.setMinorTickSpacing(25);
		
		control.setPaintTicks(true);
		
		control.setFont(new Font("Serif",Font.PLAIN,14));
		
		control.setPaintLabels(true);
		
		control.setSnapToTicks(true);
		
		add(control);
	}
}
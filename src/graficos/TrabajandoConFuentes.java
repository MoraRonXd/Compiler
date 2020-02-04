package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class TrabajandoConFuentes {
	public static void main(String []args) {
		MarcoConFuente miMarco = new MarcoConFuente();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoConFuente extends JFrame{
	public MarcoConFuente() {
		setTitle("Prueba de Fuente y Color");
		setSize(400,400);
		LaminaConFuente miLamina=new LaminaConFuente();
		add(miLamina);
		miLamina.setBackground(Color.yellow);
		miLamina.setForeground(Color.blue);
	}
}

class LaminaConFuente extends JPanel{
	
		public void paintComponent(Graphics g) {
			super.paintComponents(g); 
			Graphics2D g2=(Graphics2D)g;//refundicion
			
			//instanciando la clase Font invocando uno de los 3 
			//constructores con los que cuenta
			Font miFuente=new Font("Arial",Font.BOLD,40);
			
			//con setFont, permite establecer de la clase Graphics2D
			//lo que permire ESTABLECER(set) el tipo de letra
			g2.setFont(miFuente);
			
			//definiendo color de fuente 
			//g2.setColor(Color.yellow);
			
			//nuevamente uso la clase Graphics2D con el metodo 
			//DrawString para escribir
			g2.drawString("Eli Mora",100,100);
			
			//agregando otras palabras pero instanciando
			//directamente dentro del font
			g2.setFont(new Font("Calibri",Font.ITALIC,20));
			//g2.setColor(new Color(140,80,100));//formato RGB
			g2. drawString("Curso de Java",100,200);
			
	}
}
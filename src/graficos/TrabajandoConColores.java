package graficos;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConColores {

	public static void main(String[] args) {
		MarcoConColor miMarco=new MarcoConColor();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoConColor extends JFrame{
	public MarcoConColor() {
		
		setTitle("Prueba de Color");
		setSize(400,400);
		LaminaConColor miLamina = new LaminaConColor();
		add(miLamina); 
		
		miLamina.setBackground(SystemColor.window);
	}
	
}
class LaminaConColor extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponents(g); 
		Graphics2D g2=(Graphics2D)g;//refundicion
		//Rectangulo
		Rectangle2D rectangulo= new Rectangle2D.Double(100,100,200,150);
		
		//color
		g2.setPaint(Color.blue);
		g2.draw(rectangulo);//color al borde del rectangulo
		
		g2.setPaint(Color.yellow);
		g2.fill(rectangulo);//rellena interior del rectangulo
		
		//Elipse
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		Color miColor = new Color(220,30, 150);
		g2.setPaint(miColor);
		
		g2.fill(elipse);
		
		
		//instanciando la clase Font invocando uno de los 3 
		//constructores con los que cuenta
		Font miFuente=new Font("Calibri",Font.BOLD,26);
		
		//con setFont, permite establecer de la clase Graphics2D
		//lo que permire ESTABLECER(set) el tipo de letra
		g2.setFont(miFuente);
		
		//nuevamente uso la clase Graphics2D con el metodo 
		//DrawString para escribir
		g2.drawString("Eli Mora",100,100);
		
	}
}
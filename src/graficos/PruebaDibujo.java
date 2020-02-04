package graficos;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		
		MarcoConDibujos miMarco= new MarcoConDibujos();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() {
		setTitle("Prueba de Dibujo");
		setSize(400,400);
		LaminaConFiguras miLamina =new LaminaConFiguras();
		add(miLamina);
		miLamina.setBackground(Color.yellow);
	}
}

class LaminaConFiguras extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//g.drawRect(50, 50,200,200); 
		//g.drawLine(100,100,300,200);
		//g.drawArc(100,100,200,300,45,60);
		
		//RECTANGULO
		Graphics2D g2=(Graphics2D) g; //refundicion
		//seguido objeto que implemeta la interface shape
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		//implementando la interfaz shape
		g2.draw(rectangulo);
		
		//ELIPSE
		Ellipse2D elipse =new Ellipse2D.Double();
		//estableciendo las dimensiones de la elipse
		//que sera el rectangulo anterior
		
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		//linea
		g2.draw(new Line2D.Double(100,100,300,250));
		
		//circunferencia
		double CentroenX= rectangulo.getCenterX();
		double CentroenY= rectangulo.getCenterY();
		double radio = 126;
		Ellipse2D circulo=new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio,CentroenY+radio);
		g2.draw(circulo);
		
	}
} 
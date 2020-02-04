package graficos;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class CreandoMarcoCentrado {
	public static void main(String[] args) {
		MarcoCentrado miMarcoCentrado=new MarcoCentrado();
		miMarcoCentrado.setVisible(true);
		miMarcoCentrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoCentrado.setTitle("Marco Centrado");
		miMarcoCentrado.getIconImage();
		
		 
	}
}

class MarcoCentrado extends JFrame{
	public MarcoCentrado() {
		Toolkit miPantalla =Toolkit.getDefaultToolkit();
		/*con esto consigo guardar en la variable objeto
		 * miPantalla nustro sistema nativo de la pantalla*/
		
		Dimension tamanoPantalla =miPantalla.getScreenSize();
		
		int alturaPantalla= tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		setSize(anchoPantalla/2, alturaPantalla/2);
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		Image miIcono=miPantalla.getImage("src/graficos/delorean.jpg"); 
		
		setIconImage(miIcono);
		
	}
}

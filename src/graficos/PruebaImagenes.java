package graficos;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import javax.imageio.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		
		MarcoConImagen miMarco =new MarcoConImagen();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
class MarcoConImagen extends JFrame{
	public MarcoConImagen() {
		setTitle("Marco con Imagen");
		setBounds(500,300,300,200);
		LaminaConImagen miLamina = new LaminaConImagen();
		add(miLamina);
	}
}

class LaminaConImagen extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Archivo de tipo File, que la pasarle a su constructor
		//la direccion del archivo(en este caso una foto) lo
		//guardara en la variable instanciada, buscar File 
		//en la API Class File, File(String pathname)
		
		File miImagen=new File("src/graficos/bolitaAzul.jpg");
		try {
		//En la API:paquete ImageIO; static BufferedImage,read(File input)
		//Returns a BufferedImage as the result of decoding a 
		//supplied File with an ImageReader chosen automatically
		//from among those currently registered.
		imagen=ImageIO.read(miImagen);

		}catch(IOException e) {
			System.out.println("La imagen no se encuentra");
		}
		/*ahora con la lipreria java.awt,la instancia (g) de 
		 * la Class Graphics y recurriendo al metodo 
		 * drawImage(Image img, int x, int y, ImageObserver observer) el cual
           Draws as much of the specified image as is currently available.
           se diguja el objeto tipo imagen, el ImageObserver observer
           se utiliza para conocer el avance de conversion el archivo, por ahora no me intereza */
		
		int anchoImagen=imagen.getWidth(this);
		int alturaImagen=imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0,null);//aqui se dibuja la imagien por primera vez
		
		for(int i=0;i<300;i++) {
			for(int j=0;j<200;j++) {
				
				//para que no se imprima otra imagen sobre la que ya esta 
				if(i+j>0) {
					g.copyArea(0,0,anchoImagen,alturaImagen,anchoImagen*i,alturaImagen*j);
				}
			}
		}
	}
	private Image imagen;
}
package poo;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		
		Reloj miReloj=new Reloj();
		
		miReloj.enMarcha(3000,true);
		
		JOptionPane.showMessageDialog(null,"pulsa aceptar para terminar");
		
		System.exit(0);

	}

}

class Reloj{
	
	/* *****Constructor de la clase reloj****
	public Reloj(int intervalo,boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
	}     **************************** */
	public void enMarcha(int intervalo,final boolean sonido) {
		//******clase interna local*******
		 class DameLaHora2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Te pongo la hora cada 3 sg "+ahora);
				if(sonido) {
					//Aca puedo darme cunta que estoy 
					//accediendo el campo de clase "SONIDO"
					//sin necesidad de establecer metodos de accesoa(setter
					//y getter) ya que estoy dentro de la clase global reloj
					//que los contiene
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}//******                  ********
		 
		 //****Cuerpo del metodo Reloj****
		ActionListener oyente= new DameLaHora2();
		Timer miTemporizador = new Timer(intervalo,oyente);
		miTemporizador.start();
		//     ***********************
	}
	
	
	  
}

package carpeta1;

import javax.swing.JOptionPane;

public class PesoIdeal {
	public static void main(String []args) {
		String genero="";
		do {
			genero=JOptionPane.showInputDialog("Ingrese H o M");
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("ingrese su altura en cm"));
		
		int pesoIdeal=0;
		
		if(genero.equalsIgnoreCase("H")) {
			
			pesoIdeal=altura-110;
		}else {
			pesoIdeal=altura-120;
		}
		System.out.println("tu peso ideal es "+pesoIdeal+" kilogramos");
	}

}

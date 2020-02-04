package carpeta1;

import javax.swing.JOptionPane;

public class CompruebaMail {
	public static void main(String []args) {
	 int arroba =0;
	 boolean punto=false;
		
	String mail=JOptionPane.showInputDialog("Ingresa tu mail");
		
	for(int i=0;i<mail.length();i++) {
		//metodo statico charAt indica si una carater especifico de 
		//una posicion en una cadena se corresponde con otro ingresado
		if(mail.charAt(i)=='@') {//condicion para @
			arroba++;
		}
		if(mail.charAt(i)=='.') {
			punto=true;
		}
	}
	if(arroba==1 && punto==true) {
		System.out.println("email valido");
	}else if(arroba==0 || punto==false ) {
		System.out.println("email sin '@' o sin '.' ; NO valido");
	}else if(arroba>1) {
		System.out.println("email NO valido, posee mas de un @");
	}
	
		
	
		
		//System.out.println(mail.length());
	}
}

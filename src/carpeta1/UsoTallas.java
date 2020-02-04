package carpeta1;
import java.util.*;

public class UsoTallas {
	/*ejemplos de TIPOS ENUMERADOS. Se refiere cuando podemos
	 * definir dentro de un tipo de variable solo un numero 
	 * especifico de posibilidades, y esto se debe hacer fuera del main
	 * */
	//enum Talla{MINI,MEDIANO,GRANDE,MUY_GRANDE}
	
	enum Talla{
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUYGRANDE("XL");
		
		private Talla(String abreviatura) {//constructor debe ser private y no public 
			this.abreviatura=abreviatura;  //por que no admite la creacion de objetos
		}
		private String abreviatura;
		
		public String dameAbreviatuta() {
			return abreviatura; 
		}
	}

	public static void main(String[] args) {
	
		Scanner entrada =new Scanner(System.in);
		System.out.println("Ingrese una talla: MINI, MEDIANO, GRANDE, MUYGRANDE");
		
		String entradaDatos= entrada.next().toUpperCase();
		
		Talla laTalla =Enum.valueOf(Talla.class, entradaDatos);//se coloca Enum.valueOf() por que es statico
		//los argumentos que pide este metodo son la clase a la que pertenece, en este caso talla
		//y la entrada que dio el usuario. Esto detecta el tipo pertence el texto introducido
		//devuelve el nombre de la constante enumerada a la 
		//que pertenece el texto introducido, esto me permite llamar 
		//al getter de talla
		
		System.out.println("la talla es: "+laTalla);
		System.out.println("Abreviatura="+laTalla.abreviatura);
		
	}

}

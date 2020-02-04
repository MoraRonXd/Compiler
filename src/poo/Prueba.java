package poo;

public class Prueba {
	public static void main(String []args) {
		Empleados trabajador1= new Empleados("Eli mora");
		Empleados trabajador2= new Empleados("Ana");
		Empleados trabajador3= new Empleados("Antonio");
		Empleados trabajador4=new Empleados("maria");
		
		trabajador1.cambiaSeccion("Recursos humanos");
		
		System.out.println(trabajador1.devuelveDatos());
		
		System.out.println(trabajador2.devuelveDatos());
		
		System.out.println(trabajador3.devuelveDatos());
		
		
		System.out.println(trabajador4.devuelveDatos());
		
	    System.out.println(Empleados.dameIdSigiente());
		
		
		
	}
}

class Empleados{
	
	public Empleados(String nom) {
		nombre= nom;  
		seccion= "Administracion";
		id=idSiguiente; 
		idSiguiente++;
		
	}
	
	public String devuelveDatos() { //getter
		return "El nombre es :"+nombre+" y la seccion es "+seccion+" Y el id es "+id;
	} 
	public void cambiaSeccion(String seccion ) {//setter
		this.seccion=seccion;
	}
	
	public static String dameIdSigiente(){
		
		return "El idSiguiente es: "+idSiguiente;
	}
	
	private final String nombre;
	private String seccion;
    private int id; 
	private static int idSiguiente=1;
} 
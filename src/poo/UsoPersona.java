package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		Persona [] lasPersonas= new Persona[2];
		lasPersonas[0]=new Empleado2("Luis Conde",50000,2009,02,25);
		lasPersonas[1]=new Alumno("Ana lopez","Biologicas");
		
		for(Persona p: lasPersonas) {
			System.out.println(p.dameNombre()+", "+p.dameDescripcion());
		}
	}

}

abstract class Persona {
	public Persona(String nom) {//constructor
		nombre=nom;
	}
	public String dameNombre() {//getter
		return "El nombre es: "+nombre; 
	}
	
	public abstract String dameDescripcion();
	
	private String nombre; 
}

class Empleado2 extends Persona{
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia ) {
	super(nom);//llamando al constructor de la clasepadre
		sueldo=sue;
		GregorianCalendar calendario= new GregorianCalendar(agno, mes-1,dia); 
		//el objetivode este meteodo es construir una fecha solo eso
		altaContrato=calendario.getTime();//aca se esta almacenando la fecha 

		id=idSiguiente;
		idSiguiente++;
	}
	
	public String dameDescripcion() {
		return "Este empleado tiene un Id="+id+"  con un sueld="+sueldo;
	}
	
	public double dameSueldo() { //getter
		return sueldo;
	}	
	
	public Date dameFechaContrato() { //getter
		return altaContrato; 
	} 
	
	public void subirSueldo(double porcentaje) { //setter
		
		double aumento= sueldo*porcentaje/100;
		sueldo+=aumento;
	}
		
	
	
	public String develveDatos () {
		return " la seccion es "+
				" y el id es: "+id;
	}
	
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente=1;
}

class Alumno extends Persona {
	
	public Alumno(String nom, String car) {
		super(nom);
		carrera=car;
	}
	public String dameDescripcion() {
		return "Este Alumno estudia "+carrera;
	}
	
	private String carrera;
}

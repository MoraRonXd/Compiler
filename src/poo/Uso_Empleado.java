package poo;

import java.util.*;

public class Uso_Empleado {
	public static void main(String[]args) {
		
		/*Empleado empleado1=new Empleado("Paco Gomez",85000, 1990,12,17); 
		Empleado empleado2=new Empleado("Ana lopez",95000, 1995,06,02);
		Empleado empleado3=new Empleado("Maria Martin",105000, 2002,03,15);
		
		empleado1.subirSueldo(5);
		empleado2.subirSueldo(5); 
		empleado3.subirSueldo(5);
		
		System.out.println("Nombre:"+empleado1.dameNombre()+" Sueldo:"+empleado1.dameSueldo()
		+" fecha de alta:"+empleado1.dameFechaContrato());
		
		System.out.println("Nombre:"+empleado2.dameNombre()+" Sueldo:"+empleado2.dameSueldo()
		+" fecha de alta:"+empleado2.dameFechaContrato());
		
		System.out.println("Nombre:"+empleado3.dameNombre()+" Sueldo:"+empleado3.dameSueldo()
		+" fecha de alta:"+empleado3.dameFechaContrato());*/
		
		Jefatura JefeRRHH = new Jefatura("Eli Mora",55000,2006,9,25); 
		JefeRRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados= new Empleado[6];
		misEmpleados[0]=new Empleado("Paco Gomez",85000, 1990,12,17);
		misEmpleados[1]=new Empleado("Ana lopez",95000, 1995,06,02);
		misEmpleados[2]=new Empleado("Maria Martin",35000, 2002,03,15);
		misEmpleados[3]=new Empleado("Antonio Fernadez");
		misEmpleados[4]=JefeRRHH;//poliforfismo en accion. principio de sustitucion
		misEmpleados[5]=new Jefatura("Maria", 95000,1999,5,26);
		
		/* lo siguiente puedo hacerlo perfectamente gracias a que un jefe 
		 * es un empleado por el principio de sustitucion*/
		Empleado directorComercial = new Jefatura("Sandra", 85000, 2012, 05, 05);
		
		/*lo siguiente puedo hacerlo por que la clase empleado 
		 * implemeta la interfaz comparable y usando el mismo 
		 * principio de sustitucion, no se puede usar directamente 
		 * una interfaz pero SI se puede usar el principio de sustitucion
		 * de tal forma que si la clase empleado IMPLEMENTA la interfaz
		 * comparable, se puede crear una instancia perteneciente a la
		 * interfaz pero sera de tipo empleado o la clase en general
		 * donde se implemento */
		Comparable ejemplo = new Empleado("Elizabeth",95000,2011, 06,06);
		
		
		Jefatura JefaFinanzas =(Jefatura)misEmpleados[5];//casting o refundicion del objeto misEmpleados[5] que es de tipo empleado, paca convertirlo en tipo jefatura y asi poder aplicar el metodo setter insentivo
		
		JefaFinanzas.estableceIncentivo(55000);
		
		System.out.println(JefaFinanzas.tomarDecisiones("Dar mas dias de vacaciones a los empleados"));
		
		System.out.println("El jefe "+JefaFinanzas.dameNombre()+" tiene un bonus de "+
		JefaFinanzas.estableceBonus(500));
		
		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus de "+
				misEmpleados[3].estableceBonus(200));
		
		for(Empleado e: misEmpleados) {
			e.subirSueldo(5);
		} 
		
		
		Arrays.sort(misEmpleados);
		for(Empleado e:misEmpleados) {
		
			System.out.println("Nombre: "+e.dameNombre()
					+" Sueldo: "+e.dameSueldo()
				   	+" fecha de alta "+e.dameFechaContrato());
		}
		
	}
}

class Empleado implements Comparable, Trabajadores {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia ) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario= new GregorianCalendar(agno, mes-1,dia); 
		//el objetivode este meteodo es construir una fecha solo eso
		altaContrato=calendario.getTime();//aca se esta almacenando la fecha 

		id=idSiguiente;
		idSiguiente++;
	}
	
	public double estableceBonus(double gratificacion) {
		
		return Trabajadores.bonusBase+gratificacion;
	}
	
	public Empleado(String nom) {//sobrecarga de constructos,esto se hace 
		this(nom,30000,2000,01,01);//por si tengo objetos con menos datos que los que tenga 
	                              //el cosntructdor con mas datos y predefinir esos valores 
								  //con this()
	
	
	}
	
	
	public String dameNombre() { //getter
		return nombre+" Id: "+id; 
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
		return "El nombre es: "+nombre+" la seccion es "+
				" y el id es: "+id;
	}
	
	public int compareTo(Object miObjeto) {
		/*debo hacer un casting ya que le estoy diciendo
		 * al metodo compareTo que va a recibir un parametro de tipo
		 * objeto y debo transformar ese parametro alcual he llamado
		 * miObjeto en un objeto de tipo Empleado, pudiendo asi 
		 * comparar el sueldo de los empleados */
		Empleado otroEmpleado=(Empleado)miObjeto;
		/*esto me permite tener una variable objeto(otroEmpleado) 
		 * de tipo empleado y esto me permitira usando esta variable
		 * hacer comparaciones de los sueldos
		 *  */
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		
		
			return 0;
	}
	private String nombre;  
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente=1;
}

class Jefatura extends Empleado implements Jefes{
	/*Se definio una interface propia llamada Jefes
	 * la cual esta definiendo el comportamiento de 
	 * de la clase Jefatura, es decir todos los Jefes
	 * deben tomar decisiones, claro lo haran de maneras 
	 * diferentes, por esto este metodo es publico y 
	 * abstracto*/
	public Jefatura(String nom, double sue, int agno,int mes, int dia) {
		super (nom, sue,agno,mes,dia);//llamando al constructor de la clase padre
	}
	
	public String tomarDecisiones(String decision) {
		/*implementacion de la interface Jefes*/
		return "Um mienbro de la direccion ha tomado la "
				+ "decison de: "+decision;
	}
	
	public double estableceBonus(double gratificacion) {
		/*implementacion de la interface Trabajadores
		 * deben implemetarce ambas interfaces por que
		 *  la interface Jefe extiende de al interface
		 *   Trabajadores*/
		double prima=2000;
		
		return Trabajadores.bonusBase+gratificacion+prima;
	}
	public void estableceIncentivo(double b) {//setter
		incentivo=b;
	}	
	public double dameSueldo() {//getter para sueldo
		double sueldoJefe=super.dameSueldo();//con este super.  estoy llamando al metodo dame sueldo de la clase padre para obtener el sueldo basico de empleado
		return sueldoJefe+incentivo;
	}
	private double incentivo;
	
}

	
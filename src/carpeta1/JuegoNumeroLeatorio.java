package carpeta1;
import java.util.*;
public class JuegoNumeroLeatorio {
	public static void main(String []args) {
		
	int	miRandon =(int) (Math.random()*100);
	Scanner entrada=new Scanner(System.in);
	int numero=0;
	int intentos=0;
	
		do {
		intentos++;
		
		System.out.println("Ingrese un numero");
		
		numero=entrada.nextInt();
		
		if(numero<miRandon) {
			
			System.out.println("Bajo");
			
		}else if(numero>miRandon) {
			
			System.out.println("Alto");
		}
		
	}while(numero!=miRandon);
	System.out.println("Correcto fueron "+intentos+" intentos");
	
	}
	
}

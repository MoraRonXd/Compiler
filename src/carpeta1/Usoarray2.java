 package carpeta1;

public class Usoarray2 {

	public static void main(String[] args) {
	
		String [] paises = new String[8]; 
		paises[0]="Espana";
		paises[1]="Venezuela";
		paises[2]="Colomnbia";
		paises[3]="Puru";
		paises[4]="Bolibia";
		paises[5]="EEUU";
		paises[6]="Argentina";
		paises[7]="Brazil";
		
		/*for(int i=0; i<paises.length;i++) {
			System.out.println("pais["+i+"]="+paises[i]+"]");
			
		}*/
		//Bucle foreach
		//se declara el tipo del arreglo en esta caso String
		// luego culquier nombre(en este caso elemento) luego
		//dos puntos(:) y el nombre del arreglo.
		int i=0;
		for(String elemento:paises) {
			System.out.println("Pais ["+i+"]="+elemento);
			i++;
		}
	}

}

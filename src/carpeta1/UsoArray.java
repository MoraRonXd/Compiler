package carpeta1;

public class UsoArray {

	public static void main(String []args) {
		
		
		/*myArray[0]=5;
		myArray[1]=39;
		myArray[2]=-78;
		myArray[3]=92;
		myArray[4]=0;*/
		//System.out.println(myArray[3]);
		int [] myArray= {5,39,-78,92,0};
		for(int i=0;i<myArray.length;i++) {
			System.out.println("["+i+"]="+myArray[i]);
		}
	}
}

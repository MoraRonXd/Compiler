package carpeta1;

public class ArrayBidimensionales {

	public static void main(String []args) {
		
		int [][] matrix= new int[4][5];
		matrix[0][0]=15;
		matrix[0][1]=8;
		matrix[0][2]=24;
		matrix[0][3]=7;
		matrix[0][4]=3;
		
		matrix[1][0]=11;
		matrix[1][1]=78;
		matrix[1][2]=2;
		matrix[1][3]=78;
		matrix[1][4]=0;
		
		matrix[2][0]=-1;
		matrix[2][1]=9;
		matrix[2][2]=4;
		matrix[2][3]=6;
		matrix[2][4]=5;
		
		matrix[3][0]=46;
		matrix[3][1]=81;
		matrix[3][2]=2;
		matrix[3][3]=89;
		matrix[3][4]=36;
		
		for (int i=0; i<4;i++) {
			for(int j=0; j<5;j++) {
				System.out.print("\t"+matrix[i][j]);
			}
			System.out.print("\n");
		}
	}
}

public class TriangleDrawer {
	public static void drawTriangle(int N){
		int col=0;
		int row=0;
		int size=N;

		while(row<size){
		
		while(col<=row){
			System.out.print('*');
			col=col+1;
		}
		while(col<size){
			System.out.print(' ');
			col=col+1;
		}
		    System.out.println(' ');
		    row=row+1;
		    col=0;
		
		}
	}
 public static void main(String[] args){
 	int N=5;
 	drawTriangle(N);
 }

}

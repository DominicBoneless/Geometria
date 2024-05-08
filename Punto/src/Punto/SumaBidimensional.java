package Punto;

public class SumaBidimensional {
	
	public static int[][] calculaTotales(int[][] m) throws Exception{
			int[][] res = new int[m.length + 1][2];
			int suma = 0;
			for(int i = 0; i < m.length; i++) {
				res[i][0] = m[i][0];
				suma = suma + res[i][0];
			}
			res[m.length][0] = suma;
			suma = 0;
			for(int i = 0; i < m.length; i++) {
				res[i][1] = m[i][1];
				suma = suma + res[i][1];
			}
			res[m.length][1] = suma;
			return res;
	}

}

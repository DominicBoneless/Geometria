package Examen;

public class Pregunta3 {
	public static int[] multiplosDe3(int[][] matriz) {
		if(matriz == null) {
			return null;
		}
		else {
			int tamano = 0;
			for(int x = 0; x < matriz.length; x++)
				for(int y = 0; y < matriz[x].length; y++)
					if(matriz[x][y] % 3 == 0)
						tamano++;
			int[] multiplos = new int[tamano];
			int posicion = 0;
			for(int x = 0; x < matriz.length; x++)
				for(int y = 0; y < matriz[x].length; y++)
					if(matriz[x][y] % 3 == 0) {
						multiplos[posicion] = matriz[x][y];
						posicion++;
					}
			return multiplos;
		}
	}
}

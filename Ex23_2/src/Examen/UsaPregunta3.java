package Examen;

public class UsaPregunta3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[10][10];
		for(int x = 0; x < array.length; x++)
			for(int y = 0; y < array[x].length; y++)
				array[x][y] = (int)(Math.random()*100);
		int[] multiplos = Pregunta3.multiplosDe3(array);
		for(int i = 0; i < multiplos.length; i++) 
			System.out.println(multiplos[i]);

	}

}

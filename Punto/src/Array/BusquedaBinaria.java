package Array;

public class BusquedaBinaria {
	
	private int[] array;
	
	public BusquedaBinaria(int[] array) {
		this.array = array;
	}
	
	public int buscaNumero(int numero) {
		int minimo = 0;
		int maximo = array.length - 1;
		int puntero = array.length/2;
		int posicion = -1;
		while (posicion == -1) {
			if (array[puntero] == numero) {
				return puntero;
			}
			if(array[puntero] < numero) {
				maximo = puntero;
				puntero = maximo/2;
			}
			if(array[puntero] > numero) {
				minimo = puntero;
				puntero = (maximo-minimo)/2;
			}
			if(maximo == minimo) {
				return -1;
			}
		}
		return -1;
	}
}

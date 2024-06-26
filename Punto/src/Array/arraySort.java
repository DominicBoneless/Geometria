package Array;

public class arraySort {
	
	public static void main(String[] args) {
	
		//Este valor imprime al final las veces que hizo el cambio de valores
		int vecesCambiado = 0;
		int vecesComprobado = 0;
		boolean haCambiado = true;
		//El 10 hace que el array sea 10 numeros de largo
		int array[] = new int[10];
		System.out.print("Array desordenado: ");
		for(int i = 0; i < array.length;i++) {
			//El bucle hace que cada espacio del array tenga un valor aleatorio entre 1-100
			array[i] = (int) Math.round(100*Math.random());
			//Imprime cada valor del array desordenado
			System.out.print(array[i] + ", ");
			}
		
		for(int vecesPasado = 0 ; vecesPasado < array.length && haCambiado; vecesPasado++) {
			haCambiado = false;
			for(int posicion = 0; posicion < array.length - 1;posicion++) {
				//Se hace para acordarse de los dos valores
				int numIzq = array[posicion];
				int numDer = array[posicion + 1];
				if (numDer < numIzq) {
					//Si el de la izquierda es mas grande ce cambian los dos
					array[posicion] = numDer;
					array[posicion + 1] = numIzq;
					haCambiado = true;
					//Y aumenta los veces que ha cambiado los valores
					vecesCambiado++;
			    }
		    }
			if (haCambiado) {
				vecesComprobado++;
			}
		}
		System.out.println();
		System.out.print("Array ordenado: ");
		for(int i = 0; i < array.length;i++) {
			//Imprime cada valor del array ordenado
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		System.out.println("Veces que ha cambiado valores: " + vecesCambiado);
		System.out.println("Veces que ha pasado por el array: " + vecesComprobado);
	}	
}

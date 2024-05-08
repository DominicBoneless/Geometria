package Examen;

public class Pregunta1 {
	public static int sumaImpares(int fin) {
		int suma = 0;
		for(int i = 0; i <= fin; i++)
			if(i % 2 != 0)
				suma += i;
		return suma;
	}
}

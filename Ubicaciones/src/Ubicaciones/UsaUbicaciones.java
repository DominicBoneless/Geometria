package Ubicaciones;

import java.util.ArrayList;

public class UsaUbicaciones {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Punto> ubicaciones1 = new ArrayList<Punto>();
		Punto ubi1 = new Punto(1,1);
		Punto ubi2 = new Punto(2,2);
		Punto ubi3 = null;
		Punto ubi4 = new Punto(4,4);
		Punto ubi5 = new Punto(5,5);
		ubicaciones1.add(ubi4);
		ubicaciones1.add(ubi3);
		ubicaciones1.add(ubi2);
		ubicaciones1.add(ubi1);
		Ubicaciones objUbi1 = new Ubicaciones(ubicaciones1);
		Punto puntoMasCercano = objUbi1.puntoMasCercanoCentro();
		System.out.println("El punto mas cercano al centro es X:" + puntoMasCercano.getX() + " Y: " + puntoMasCercano.getY());
		System.out.println("El punto 1,1 esta contenido en ubicaciones1: " + objUbi1.busquedaBinaria(ubi1));
		for(int i = 0; i < objUbi1.getUbicaciones().size(); i++) {
			System.out.println("(" + objUbi1.getUbicaciones().get(i).getX() + "," + objUbi1.getUbicaciones().get(i).getY() + ")");
		}
		System.out.println("El punto 3,3 esta contenido en ubicaciones1: " + objUbi1.busquedaBinaria(ubi3));
		System.out.println("El punto 5,5 esta contenido en ubicaciones1: " + objUbi1.busquedaBinaria(ubi5));
		System.out.println("El punto 3,3 esta contenido en ubicaciones1: " + objUbi1.busquedaLineal(ubi3));
		System.out.println("El punto 5,5 esta contenido en ubicaciones1: " + objUbi1.busquedaLineal(new Punto(5,5)));
	}
}

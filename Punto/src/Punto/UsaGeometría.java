package Punto;

public class UsaGeometría {
	
	public static void main(String[] args) {
		
		Punto p1 = new Punto(2,3);
		Punto p2 = new Punto(4,8);
		Punto p3 = new Punto(20,40);
		Punto p4 = new Punto(-12,6);
		Punto p5 = new Punto(5,24);
		Punto arrayPunto[] = new Punto[20];
		for(int i = 0; i < 20; i++) {
			arrayPunto[i] = new Punto();
		}
		double distanciaLejana = 0;
		Punto puntoLejano = new Punto (0,0);
		for(int i = 0; i < 20; i++) {
			if(distanciaLejana < arrayPunto[i].getDistancia()) {
				distanciaLejana = arrayPunto[i].getDistancia();
				puntoLejano = arrayPunto[i];
			}
		}
		Circulo c1 = new Circulo(3, p1);
		Circulo c2 = new Circulo(2, p2);
		
		System.out.println("La distancia de p1 al centro es: " + p1.getDistancia());
		System.out.println("La distancia de p2 al centro es: " + p2.getDistancia());
		System.out.println("La distancia de p1 a p2 es:" + p1.distanciaEntrePuntos(p2));
		System.out.println("La distancia de p2 a p1 es:" + p2.distanciaEntrePuntos(p1));
		System.out.println("P3 está " + p3.tipoDistancia());
		System.out.println("P2 está " + p2.tipoDistancia());
		System.out.println("P1 está " + p1.tipoDistancia());
		System.out.println("P1 está " + p1.tipoDistanciaEntrePuntos(p2) + " de P2");
		System.out.println("P1 está " + p1.tipoDistanciaEntrePuntos(p3) + " de P3");
		System.out.println("El punto mas cercano a p1 contenido en c1 es X: " + c1.puntoMasCercano(p1).getX() + " Y: " + c1.puntoMasCercano(p1).getY());
	    System.out.println("La mayor distancia es: " + distanciaLejana + "Las coordenadas de el punto mas lejanto es X: " + puntoLejano.getX() + " Y: " + puntoLejano.getY()); 
	}
	

}

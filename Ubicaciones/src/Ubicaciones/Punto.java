package Ubicaciones;

	public class Punto {
		
		//Atributos
			//Números int/double/float
			//Characters char: ?,.,a,!
			//Palabreas String
			//Booleanos true/false
		private double x;
		private double y;
		
		//Methods constructor y otros métodos
		//Constructor de puntos con 2 parametros
		public Punto(int x, int y) {
		this.x = x;	
		this.y = y;
		}
		public Punto() {
			this.x = Math.random();
			this.y = Math.random();
		}
		//Métodos getters/setters
		public double getX() {
			return this.x;
		}
		public double getY() {
			return this.y;
		}
		public void setX(double x) {
			this.x = x;
		}
		public void setY(double y) {
			this.y = y;
		}
		public double getDistancia() {
			double dist = Math.sqrt(x*x + y*y);
			return dist;
		}
		//Nos devuelve la distancia con otro punto pasado como parámetro
		public double distanciaEntrePuntos (Punto p2) {
			double xNueva = x - p2.getX();
			double yNueva = y - p2.getY();
			return Math.sqrt(xNueva*xNueva + yNueva*yNueva);
		}
		
	    public String tipoDistancia() {
	    	double distancia = getDistancia();
	    	if(distancia <= 5.0) {
	    		return "Cercano";
	    	}
	    	if(distancia > 5.0 && distancia <= 10.0) {
	    		return "medio";
	    	}
	    	return "lejano";   	   		
	    }
	    public String tipoDistanciaEntrePuntos(Punto pAux) {
	    	double distanciaEntrePuntos = distanciaEntrePuntos(pAux);
	    	if(distanciaEntrePuntos <= 5.0) {
	    		return "cercano";
	    	}
	    	if(distanciaEntrePuntos > 5.0 && distanciaEntrePuntos <= 10.0) {
	    		return "medio";
	    	}
	    	return "lejano";
	    }
		
	}

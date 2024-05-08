package Punto;

public class Vehiculo {
	
	private String matricula;
	private String modelo;
	private double velocidad;
	
	public Vehiculo(String matricula, String modelo, double velocidad) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.velocidad = velocidad;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	public boolean superaVelocidad(double vel) {
		if(this.getVelocidad() > vel) {
			return true;
		}else {
			return false;
		}
	}
	
	public Vehiculo[] getVehiculosSobreLimite(double vel) {
		int numVehiculos = 0;
		for(int i = 0; i < detectados.length; i++) {
			if(detectados[i] != null && detectados[i].getVelocidad() > vel)
				numVehiculos++;
		}
		Vehiculo[] vehiculosAux = new Vehiculo[numVehiculos];
		int posicion = 0;
		for(int i = 0; i < detectados.length; i++) {
			if(detectados[i] != null && detectados[i].getVelocidad() > vel) {
				vehiculosAux[posicion] = detectados[i];
				posicion++;
				
			}
		}
		return vehiculosAux;
	}

}

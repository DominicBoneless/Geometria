package Ubicaciones;

import java.util.ArrayList;

public class Ubicaciones {
	
	private ArrayList<Punto> ubicaciones;
	
	public Ubicaciones (ArrayList<Punto> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	public ArrayList<Punto> getUbicaciones(){
		return ubicaciones;
	}
	
	public void setUbicaciones(ArrayList<Punto> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	//Método fachada
	private ArrayList<Punto> ordenarUbicaciones(ArrayList<Punto> ubicacionesAux) throws Exception {
		for(int i = 0; i < ubicaciones.size(); i++ ) {
			if(ubicaciones.get(i) == null) {
				throw new Exception("Hay un null en el array");
			}
		}
		for(int i = 0; i < ubicaciones.size(); i++ ) {
			for(int j = 0; j < ubicaciones.size()-1; j++) {
				if(ubicacionesAux.get(j).getDistancia() >  ubicacionesAux.get(j+1).getDistancia()) {
					Punto pAux = ubicacionesAux.get(j);
					ubicacionesAux.set(j, ubicacionesAux.get(j+1));
					ubicacionesAux.set(j+1, pAux);
					}
			}
		}
		return ubicacionesAux;
	}
	
	public ArrayList<Punto> ordenarUbicaciones() throws Exception{
		return ordenarUbicaciones(ubicaciones);
	}
	
	public boolean busquedaLineal(Punto ubicacionBuscar) throws Exception{
		ArrayList<Punto> ubicacionesAux = ordenarUbicaciones(ubicaciones);
		for(int i = 0; i < ubicacionesAux.size(); i++) {
			if(ubicacionesAux.get(i).getX() == ubicacionBuscar.getX() && ubicacionesAux.get(i).getY() == ubicacionBuscar.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean busquedaBinaria(Punto pAux) throws Exception {
		ArrayList<Punto> ubicacionesAux = ordenarUbicaciones(ubicaciones);
		int minimo = 0;
		int maximo = ubicacionesAux.size()-1;
		int puntero = ubicacionesAux.size()/2;
		while(maximo != minimo || minimo <= maximo-1) {
			if(ubicacionesAux.get(puntero).getX() == pAux.getX() && ubicacionesAux.get(puntero).getY() == pAux.getY()) {
				return true;
			}
			if(pAux.getDistancia() < ubicacionesAux.get(puntero).getDistancia()) {
				maximo = puntero;
				puntero = (maximo-minimo)/2;
			}
			else {
				minimo = puntero;
				puntero = (maximo-minimo)/2;
			}
		}
		return false;
	}
	
	public Punto puntoMasCercanoCentro() throws Exception {
		ArrayList<Punto> ubicacionesAux = ordenarUbicaciones(ubicaciones);
		return ubicacionesAux.get(0);
	}

}

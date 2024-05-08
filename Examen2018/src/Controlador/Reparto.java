package Controlador;

import java.util.ArrayList;
import java.util.HashSet;

public class Reparto {
	private String id;
	private Camion camion;
	private Conductor conductor;
	private ArrayList<Cliente> ruta;
	private HashSet<Mercancia> mercancias;
	public Reparto(Conductor conductor, Camion camion) {
		this.conductor = conductor;
		this.camion = camion;
		this.ruta = new ArrayList<>();
		this.mercancias = new HashSet<>();
		this.id = UtilsRutas.calculaIDParaReparto();
	}
	public Reparto(ArrayList<Cliente> ruta, HashSet<Mercancia> mercancias) {
		this.ruta = ruta;
		this.mercancias = mercancias;
		this.camion = null;
		this.conductor = null;
		this.id = UtilsRutas.calculaIDParaReparto();
	}
	public boolean valida() {
		if(ruta.isEmpty())
			return true;
		int pesoTotal = 0;
		boolean hayAlgoFrio = false;
		for(Mercancia mercanciaActual: this.mercancias) {
			pesoTotal += mercanciaActual.getPeso();
			if(mercanciaActual.isEnFrio())
				hayAlgoFrio = true;
		}
		
		if(pesoTotal < camion.getCargaMaximaKG()) {
			if((hayAlgoFrio && camion.getClass().equals("Frigorifico")) || (!hayAlgoFrio && camion.getClass().equals("Estandar")))
				return true;
		}
		return false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public ArrayList<Cliente> getRuta() {
		return ruta;
	}
	public void setRuta(ArrayList<Cliente> ruta) {
		this.ruta = ruta;
	}
	public HashSet<Mercancia> getMercancias() {
		return mercancias;
	}
	public void setMercancias(HashSet<Mercancia> marcancias) {
		this.mercancias = marcancias;
	}
}
package Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controlador {
	private String direccionEmpresa;
	private HashMap<String , Camion> flota;
	private HashMap<String , Conductor> conductores;
	private HashMap<String , Cliente> clientes;
	public HashMap<String , Reparto> repartos;
	public Controlador(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
		flota = new HashMap<>();
		conductores = new HashMap<>();
		clientes = new HashMap<>();
		repartos = new HashMap<>();
	}
	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}
	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}
	public HashMap<String, Camion> getFlota() {
		return flota;
	}
	public void setFlota(HashMap<String, Camion> flota) {
		this.flota = flota;
	}
	public HashMap<String, Conductor> getConductores() {
		return conductores;
	}
	public void setConductores(HashMap<String, Conductor> conductores) {
		this.conductores = conductores;
	}
	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}
	public int calculaDistanciaTotalRuta(Reparto reparto) {
		int totalKms = 0;
		totalKms += UtilsRutas.distanciaKms(direccionEmpresa, reparto.getRuta().get(0).getDireccion());
		for(int i = 0; i < reparto.getRuta().size()-1; i++) {
			totalKms += UtilsRutas.distanciaKms(reparto.getRuta().get(i).getDireccion(), reparto.getRuta().get(i+1).getDireccion());
		}
		totalKms += UtilsRutas.distanciaKms(direccionEmpresa, reparto.getRuta().get(reparto.getRuta().size()-1).getDireccion());
		return totalKms;
	}
	public void insertaRepartoPorDistancia(ArrayList<Reparto> lista, Reparto reparto) {
		boolean esUltimo = true;
		for(int i = 0; i < lista.size(); i++) {
			if(this.calculaDistanciaTotalRuta(lista.get(i)) > this.calculaDistanciaTotalRuta(reparto)) {
				lista.add(i, reparto);
				esUltimo = false;
			}
		}
		if(esUltimo)
			lista.add(reparto);
	}
	public ArrayList<Reparto> repartosOrdenadosPorDistanciaCreciente(){
		ArrayList<Reparto> repartos = new ArrayList<>();
		for(Conductor conductor: conductores.values())
			if(conductor.getReparto() != null)
				repartos.add(conductor.getReparto());
		for(int j = 0; j < repartos.size(); j++) {
			for(int i = 0; i < repartos.size()-1; i++) {
				if(calculaDistanciaTotalRuta(repartos.get(i)) > calculaDistanciaTotalRuta(repartos.get(i+1))) {
					Reparto repAux = repartos.get(i);
					repartos.set(i, repartos.get(i+1));
					repartos.set(i+1, repAux);
				}
			}
		}
		return repartos;
	}
	public Reparto getRepartoPorDistancia(int distanciaRuta, ArrayList<Reparto> repartosOrdenados) {
		int min = 0;
		int max = repartosOrdenados.size();
		boolean encontrado = false;
		Reparto rep = null;
		while(min < max && encontrado == false) {
			int puntero = (min + max)/2;
			if(calculaDistanciaTotalRuta(repartosOrdenados.get(puntero)) == distanciaRuta) {
				rep = repartosOrdenados.get(puntero);
				encontrado = true;
			}
			if(calculaDistanciaTotalRuta(repartosOrdenados.get(puntero)) > distanciaRuta)
				max = puntero - 1;
			if(calculaDistanciaTotalRuta(repartosOrdenados.get(puntero)) < distanciaRuta)
				min = puntero + 1;
			
		}
		return rep;
	}
	public boolean anadirCamion(String matricula, int autonomiaKms, int cargaMaximaKG) {
		Camion camion = new Camion(matricula,autonomiaKms,cargaMaximaKG);
		if(flota.put(matricula, camion) == null)
			return true;
		return false;
	}
	public boolean anadirReparto(HashSet<Mercancia> mercancias) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		for(Mercancia mercancia: mercancias)
			if(!clientes.contains(mercancia.getDestinario()))
				clientes.add(mercancia.getDestinario());
		for(int i = 0; i < clientes.size(); i++)
			for(int j = 0; j < clientes.size(); j++) {
				if(UtilsRutas.distanciaKms(clientes.get(j).getDireccion(), direccionEmpresa) > UtilsRutas.distanciaKms(clientes.get(j+1).getDireccion(), direccionEmpresa)) {
					Cliente clienteAux = clientes.get(j);
					clientes.set(j, clientes.get(j+1));
					clientes.set(j+1, clienteAux);
				}
			}
		Reparto reparto = new Reparto(clientes, mercancias);
		if(repartos.put(reparto.getId(), reparto) == null)
			return true;
		return false;
	}
}

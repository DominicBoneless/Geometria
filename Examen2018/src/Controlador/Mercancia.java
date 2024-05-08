package Controlador;

public class Mercancia {
	private int peso;
	private String detalles;
	private boolean enFrio;
	private Cliente destinario;
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public boolean isEnFrio() {
		return enFrio;
	}
	public void setEnFrio(boolean enFrio) {
		this.enFrio = enFrio;
	}
	public Cliente getDestinario() {
		return destinario;
	}
	public void setDestinario(Cliente destinario) {
		this.destinario = destinario;
	}
}

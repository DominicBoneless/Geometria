package Controlador;

public class Conductor {
	private String nif;
	private String nombre;
	private Reparto reparto;
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Reparto getReparto() {
		return reparto;
	}
	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}
}

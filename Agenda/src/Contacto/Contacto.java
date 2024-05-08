package Contacto;

public class Contacto {
	
	private String nombre;
	private int numero;
	private String correo;
	
	public Contacto(String nombre, int numero, String correo) {
		this.nombre = nombre;
		this.numero = numero;
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String toString() {
		return "Nombre: " + nombre + ", numero: " + numero + ", correo: " + correo;
	}

}

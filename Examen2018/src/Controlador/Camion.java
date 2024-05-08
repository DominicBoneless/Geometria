package Controlador;

public class Camion {
	protected String matricula;
	protected int autonomiaKms;
	protected int cargaMaximaKG;
	private Reparto reparto;
	public Camion(String matricula, int autonomiaKms, int cargaMaximaKG) {
		this.matricula = matricula;
		this.autonomiaKms = autonomiaKms;
		this.cargaMaximaKG = cargaMaximaKG;
		this.reparto = null;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAutonomiaKms() {
		return autonomiaKms;
	}
	public void setAutonomiaKms(int autonomiaKms) {
		this.autonomiaKms = autonomiaKms;
	}
	public int getCargaMaximaKG() {
		return cargaMaximaKG;
	}
	public void setCargaMaximaKG(int cargaMaximaKG) {
		this.cargaMaximaKG = cargaMaximaKG;
	}
	public Reparto getReparto() {
		return reparto;
	}
	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}
}

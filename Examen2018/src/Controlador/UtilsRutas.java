package Controlador;

public class UtilsRutas {
	protected static int idGlobal;
	public UtilsRutas() {
		idGlobal = 1;
	}
	public static int distanciaKms(String dirOrigen, String dirDestino) {
		int dist = ((int)(Math.random()*100));
		dist = dist*(Math.abs(dirOrigen.length() - dirDestino.length()));
		return dist;
	}
	public static String calculaIDParaReparto() {
		return "" + idGlobal++;
	}
}

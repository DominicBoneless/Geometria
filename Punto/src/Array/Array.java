package Array;

public class Array {
	private int[] arrayNumeros;
	
	public Array(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}
	
	public int[] getArray() {
		return arrayNumeros;
	}
	
	public void setArray(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}
	
	public int getNumeroGrande() {
		int numeroGrande = arrayNumeros[0];
		for(int i = 0; i < arrayNumeros.length; i++) {
			if(arrayNumeros[i] > numeroGrande) {
				numeroGrande = arrayNumeros[i];
			}
		}
		return numeroGrande;
	}
	public int getNumeroPequeno() {
		int numeroPequeno = arrayNumeros[0];
		for(int i = 0; i < arrayNumeros.length; i++) {
			if(arrayNumeros[i] < numeroPequeno) {
				numeroPequeno = arrayNumeros[i];
			}
		}
		return numeroPequeno;
	}

}

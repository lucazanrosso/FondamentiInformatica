public class InsiemeNumeriNaturali {
	
	boolean[] numeriNaturali;
	
	public InsiemeNumeriNaturali(int dimensione) {
		numeriNaturali = new boolean[dimensione];
	}
	
	public void inserisci(int numero) {
		numeriNaturali[numero] = true;
	}
	
	public void cancella(int numero) {
		numeriNaturali[numero] = false;
	}
	
	public boolean controllaVuoto() {
		for (boolean posizione : numeriNaturali) {
			if (posizione == true)
				return false;
		}
		return true;
	}
	
	public boolean appartiene(int numero) {
		return numeriNaturali[numero];
	}
}
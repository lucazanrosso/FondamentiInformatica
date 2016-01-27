public class Nodo {
	
	// Variabili di istanza
	Stringa stringa;
	int nodoSx;
	int nodoDx;
	
	// Costruttore
	public Nodo(Stringa stringa, int nodoSx, int nodoDx) {
		this.stringa = stringa;
		this.nodoSx = nodoSx;
		this.nodoDx = nodoDx;
	}
	
	// Metodi get
	public Stringa getStringa() {
		return stringa;
	}
	
	public int getNodoSx() {
		return nodoSx;
	}
	
	public int getNodoDx() {
		return nodoDx;
	}
}
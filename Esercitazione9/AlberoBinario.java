import java.util.Arrays;

public class AlberoBinario {
	
	// Variabile di istanza
	Nodo[] nodi;
	
	// Costruttore
	public AlberoBinario(Nodo ... nodi) {
		this.nodi = nodi;
	}
	
	// Metodo depthFirstSearch
	public String depthFirstSearch() {
		if (nodi[1] == null)
			return null;
		String s = "";
		return depthFirstSearch(nodi[1], s);
	}
	
	public String depthFirstSearch(Nodo nodo, String s) {
		s = "\n" + Arrays.asList(nodi).indexOf(nodo) + " " + nodo.getStringa().toString();
		if (nodi[nodo.getNodoSx()] != null)
			s += depthFirstSearch(nodi[nodo.getNodoSx()], s);
		if (nodi[nodo.getNodoDx()] != null)
			s += depthFirstSearch(nodi[nodo.getNodoDx()], s);
		return s;
	}
	
	// Metodo breadthFirstSearch
	public String breadthFirstSearch() {
		String s = "";
		int i = 0;
		for (Nodo nodo : nodi) {
			if (nodo != null)
				s += "\n" + i + " " + nodo.getStringa().toString();
			i++;
		}
		return s;
	}
}
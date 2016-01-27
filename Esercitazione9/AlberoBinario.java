public class AlberoBinario {
	
	Nodo[] alberoBinario;
	
	public AlberoBinario(Nodo ... alberoBinario) {
		this.alberoBinario = alberoBinario;
	}
	
	//CHE ALGORITMO CAZZUTISSIMO FATTO IN 20 MINUTI!!!
	public String depthFirstSearch() {
		if (alberoBinario[1] == null)
			return null;
		String s = "";
		return depthFirstSearch(alberoBinario[1], s);
	}
	
	public String depthFirstSearch(Nodo nodo, String s) {
		s = "\n" + nodo.getStringa().toString();
		if (alberoBinario[nodo.getNodoSx()] != null)
			s += depthFirstSearch(alberoBinario[nodo.getNodoSx()], s);
		if (alberoBinario[nodo.getNodoDx()] != null)
			s += depthFirstSearch(alberoBinario[nodo.getNodoDx()], s);
		return s;
	}
	
	public String breadthFirstSearch() {
		String s = "";
		int i = 1;
		for (Nodo nodo : alberoBinario) {
			if (nodo != null)
				s += "\n" + i + " " + nodo.getStringa().toString();
			i++;
		}
		return s;
	}
}
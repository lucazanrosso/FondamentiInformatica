public class AlberoBinario {
	
	Nodo[] alberoBinario;
	
	public AlberoBinario(Nodo ... alberoBinario) {
		this.alberoBinario = alberoBinario;
	}
	
	public String depthFirstSearch() {
		return "";
	}
	
	public String breadthFirstSearch() {
		String s = "";
		for (Nodo nodo : alberoBinario) {
			if (nodo == null)
				s += "\n";
			else
				s += "\n" + nodo.getStringa().toString();
		}
		return s;
	}
}
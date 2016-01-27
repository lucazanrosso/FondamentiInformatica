public class AlberoBinarioTest {
	
	public static void main(String[] args) {
		
		AlberoBinario alberoBinario = new AlberoBinario(
				null,
				new Nodo(new Stringa('c', 'h', 'e'), 2, 3),
				new Nodo(new Stringa('b', 'e', 'l', 'l', 'i'), 4, 0),
				new Nodo(new Stringa('g', 'l', 'i'), 0, 7),
				new Nodo(new Stringa('a', 'l', 'b', 'e', 'r', 'i'), 0, 0),
				null,
				null,				
				new Nodo(new Stringa('b', 'i', 'n', 'a', 'r', 'i'), 0, 0));
				
		System.out.println(alberoBinario.depthFirstSearch());
		System.out.println(alberoBinario.breadthFirstSearch());
	}
}
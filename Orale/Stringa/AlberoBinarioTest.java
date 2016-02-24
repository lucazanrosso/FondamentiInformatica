public class AlberoBinarioTest {
	
	public static void main(String[] args) {
		
		/*
		9.3
		Creo un oggetto AlberoBinario e come parametri istanzio direttamente tutti gli oggetti 
		Nodo. Questo porta a ridurre di molto il codice, oltre che ad essere più performante.
		Posso passare come parametri quanti oggetti Nodo voglio, perché sto utilizzando
		i varargs: il dettaglio della spiegazione si trova nel costruttore della classe Stringa 
		che, come struttura, è identico al costruttore della classe AlberoBinario.
		Per le stringhe ho deciso di utilizzare la classe Stringa fatta nel punto 9.1, così da
		dimostrare che tutto funziona correttamente.
		In questo albero binario la radice parte dall'indice 1, come spiegato in aula e 
		nell'alternativa del professore.
		CURIOSITÀ: è interessante vedere che se nei child (o nodo figlio) si inserisce un valore 
		di un parent (o nodo genitore), al posto di un altro child, l'algoritmo depthFirstSearch 
		continuerà a passare dal child al parent e viceversa, e il programma andrà in loop. 
		NOTA: se nei nodi "belli" e "gli" inserisco come parametri 4, 5 e 6, 7, l'algoritmo
		funziona lo stesso, anche se nella posizione 5 e 7 non ci sono nodi.
		Infatti mettendo zero dove non si sono i child, il programma controlla
		cosa c'è nella posizione zero (cioè null), il che equivale a mettere il numero di child 
		corretto, perché anche quelli sono null.
		*/
		AlberoBinario alberoBinario = new AlberoBinario(
				null,
				new Nodo(new Stringa('c', 'h', 'e'), 2, 3),
				new Nodo(new Stringa('b', 'e', 'l', 'l', 'i'), 4, 0),
				new Nodo(new Stringa('g', 'l', 'i'), 0, 6),
				new Nodo(new Stringa('a', 'l', 'b', 'e', 'r', 'i'), 8, 9),
				null,		
				new Nodo(new Stringa('b', 'i', 'n', 'a', 'r', 'i'), 13, 0),
				null,
				new Nodo(new Stringa('c', 'o', 'n'), 0, 0),
				new Nodo(new Stringa('t', 'a', 'n', 't', 'i'), 0, 0),
				null,
				null,
				null,
				new Nodo(new Stringa('n', 'o', 'd', 'i'), 0, 0),
				null,
				null);
				
		// Stampo gli alberi nei due modi indicati
		System.out.println("Depth-first search:" + alberoBinario.depthFirstSearch());
		System.out.println("\nBreadth-first search:" + alberoBinario.breadthFirstSearch());
	}
}

/*
OUTPUT

Depth-first search:
1 che
2 belli
4 alberi
8 con
9 tanti
3 gli
6 binari
13 nodi

Breadth-first search:
1 che
2 belli
3 gli
4 alberi
6 binari
8 con
9 tanti
13 nodi
*/
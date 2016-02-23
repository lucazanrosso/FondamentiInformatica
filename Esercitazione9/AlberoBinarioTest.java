public class AlberoBinarioTest {
	
	/*
	9.3
	Questo ultimo punto è stato scritto interamente da me senza prendere di riferimento
	nessun codice già scritto, perciò, anche se ho ricontrollato tutto molte volte e ho cercato
	di essere il più compatto possibile, alcuni pezzi potrebbero essere da ottimizzare.
	*/	
	public static void main(String[] args) {
		
		/*
		Creo un oggetto AlberoBinario e come parametri istanzio direttamente tutti gli oggetti 
		Nodo. Questo porta a ridurre di molto il codice, oltre che ad essere più performante.
		Posso passare come parametri quanti oggetti Nodo voglio, il perché è spiegato 
		nel costruttore della classe Stringa che, come struttura, è identico al costruttore 
		della classe AlberoBinario.
		Per le stringhe ho deciso di utilizzare la classe Stringa fatta nel punto 9.1, così da
		dimostrare che tutto funziona correttamente.
		In questo albero binario la radice parte dall'indice 1, come spiegato nell'alternativa
		del professore.
		CURIOSITÀ: è interessante vedere che se nei child (o nodo figlio o come lo si vuole chiamare)
		si inserisce per sbaglio (o apposta) un valore di un parent (o nodo genitore), 
		al posto di un altro child, l'algoritmo depthFirstSearch continuerà a passare dal child
		al parent e viceversa, e il programma andrà in loop. 
		A parole è difficile da spiegare ma basta, ad esempio, sostituire al nodo "albero" il 
		valore 2 come secondo parametro. Con la stessa logica è possibile fare molti altri esperimenti.
		NOTA: se nei nodi "belli" e "gli" inserisco come parametri 4, 5 e 6, 7, l'algoritmo
		funziona lo stesso, anche se nella posizione 5 e 6 non ci sono nodi.
		Infatti mettendo zero dove non si sono i child, il programma controlla
		cosa c'è nella posizione zero (cioè null), il che equivale a mettere il numero di child
		corretto, perché anche quelli sono null.
		*/
		AlberoBinario alberoBinario = new AlberoBinario(
				null,
				new Nodo(new Stringa('c', 'h', 'e'), 2, 3),
				new Nodo(new Stringa('b', 'e', 'l', 'l', 'i'), 4, 0),
				new Nodo(new Stringa('g', 'l', 'i'), 0, 7),
				new Nodo(new Stringa('a', 'l', 'b', 'e', 'r', 'i'), 0, 0),
				null,
				null,				
				new Nodo(new Stringa('b', 'i', 'n', 'a', 'r', 'i'), 0, 0));
				
		// Stampo gli alberi nei due modi indicati
		System.out.println(alberoBinario.depthFirstSearch());
		System.out.println(alberoBinario.breadthFirstSearch());
	}
}
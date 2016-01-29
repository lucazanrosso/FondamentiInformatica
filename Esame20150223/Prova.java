public class Prova {
	
	public static int[] vett;
	
	public static void main(String[] args) {
		vett = new int[6];
		// Scelti a caso non so se vuol dire scelti da noi o creati a random.
		for (int i = 0; i < vett.length; i++)
			vett[i] = (int) (Math.random() * 100);	
		System.out.println("Array disordinato");
		print();
		
		decrInsSort();
		System.out.println("Array ordinato");
		print();

		System.out.println(recBinSearch(77, 0, vett.length - 1));
	}
	
	public static void decrInsSort() {
		for (int i = 1; i < vett.length; i++) {
			int temp = vett[i];
			int j;
			// Occhio che è descrescente è bisogna invertire il minore che abbiamo fatto in classe
			for (j = i - 1; j >= 0 && vett[j] < temp; j--)
				vett[j + 1] = vett[j];
			vett[j + 1] = temp;
		}
	}
	
	public static int recBinSearch(int value, int from, int to) {
		if (from > to)
			return -1;
		int mid = (from + to) / 2;
		int middle = vett[mid];
		if (middle == value)
			return value;
		// l'array è descrescente quindi anche qui bisogna invertire il minore
		else if (middle > value)
			return recBinSearch(value, mid + 1, to);
		else
			return recBinSearch(value, from, mid - 1);
	}
	
	public static void print() {
		for (int v : vett)
			System.out.println(v);
	}
}

// Premetto che questi sono dati che si trovano anche nel veb, che però si discostano
// dagli appunti che ho preso in aula. Perciò o ho sbagliato io o ...

// Quando si fa riferimento al log si intende sempre log in base 2.

/*
3.2
La compessità temporale del programma è composta da due parti: dall'ordinamento
dell'array e dalla ricerca binaria.
La complessità dell'algoritmo Insertion Sort è di:
		- O(n^2) nel caso peggiore,
		- O(n) nel caso migliore,
		- O(n^2) nel caso medio.
La complessità dell'algoritmo di ricerca binaria invece è di:
		- O(long) nel caso peggiore,
		- O(1) nel caso migliore,
		- O(logn) nel caso medio.
Quindi si può dire che la complessità totale è di:
		- O(n^2) + O(logn) nel caso migliore,
		- O(n) + O(1) nel caso migliore,
		- O(n^2) + O(logn) nel caso medio.
*/

/*
3.3
Il vantaggio della ricerca lineare è che l'array non deve essere ordinato prima di effettuare
la ricerca, quindi mediamente è sempre vantaggioso usare la ricerca lineare al posto
dell'insertion sort più la ricerca bianria. In questo caso però ci viene detto che l'array è
già ordinato, perciò il confronto può essere fatto solo tra ricerca lineare e binaria,
e non nel programma complessivo.
La compessità della ricerca lineare è di:
		- O(n) nel caso peggiore,
		- O(1) nel caso migliore,
		- O(n/2) nel caso medio.
Quindi, considerando il caso medio e che l'array è già ordinato, è più conveniente 
usare la rierca binaria.
*/
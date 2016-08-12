public class SearchAndSort {
	
	public static int[] vett;
	
	public static void main(String[] args) {
		
		vett = new int[20];
		
		// Riempio l'array di 100 numeri casuali compresi tra 0 e 99
		for (int i = 0; i < vett.length; i++)
			vett[i] = (int) (Math.random() * 100);	
		
		System.out.println("\nArray disordinato");
		print();
		
		System.out.println("\nArray ordinato");
		//selectionSort();
		//insertionSort();
		bubbleSort();
		//sss();
		//mergeSort();
		print();
		
		System.out.println("\nposizione numero 46");
		System.out.println("Ricerca lineare " + linearSearch(46));
		System.out.println("Ricerca binaria " + recBinSearch(46));
		
		System.out.println("\nMax search 98");
		System.out.println("Posizione " + maxSearch(98));
		
		System.out.println("\nArray invertito");
		invert();
		print();
	}
	
	/*
	Ricerca lineare che ritorna la posizione del valore, se c'è
	*/
	public static int linearSearch(int value) {
		for  (int i = 0; i < vett.length; i++)
			if (vett[i] == value)
				// Per ritornare il valore basta cambiare i con value
				return i;
		return -1;
	}
	
	/*
	Ricerca binaria crescente che ritorna la posizione del valore, se c'è
	*/
	public static int recBinSearch(int value) {
		return recBinSearch(value, 0, vett.length - 1);
	}
	
	public static int recBinSearch(int value, int from, int to) {
		if (from > to)
			return -1;
		int mid = (from + to) / 2;
		int middle = vett[mid];
		if (middle == value)
			// Per ritornare il valore basta cambiare mid con value
			return mid;
		// Per la ricerca in forma descrescente basta cambiare il < con il >
		else if (middle < value)
			return recBinSearch(value, mid + 1, to);
		else
			return recBinSearch(value, from, mid - 1);
	}
	
	/*
	Max Search che ritorna la posizione del valore se c'è
	*/
	public static int maxSearch(int value) {
		int max = 0;
		for (int i = 0; i < vett.length; i++)
			// Per la ricerca del minimo basta cambiare il > con il <
			if (vett[i] > vett[max])
				max = i;
		if (value == vett[max])
			// Per ritornare il valore basta cambiare max con value
			return max;
		else
			return -1;
	}
	
	/*
	Invert
	*/
	public static void invert() {
		for (int i = 0; i < (vett.length / 2); i++) {
			int temp = vett[i];
			vett[i] = vett[vett.length - 1 - i];
			vett[vett.length - 1 - i] = temp;
		}
	}
	
	/*
	Selection Sort crescente in stile Canazza
	*/
	public static void selectionSort() {
		for(int i = 0; i < vett.length - 1; i++) {
			int minPos = findMinPos(i, vett.length);
			if (minPos != i)
				swap(minPos, i);
		}
	}
	
	public static int findMinPos(int from, int to) {
		int pos = from;
			for(int j = from + 1; j < to; j++) 
				// Per ordinarlo in forma descrescente basta cambiare il < con il >
				if (vett[j] < vett[pos])
					pos = j;			
		return pos;
	}
	
	public static void swap(int i, int j) {
		int temp = vett[i];
		vett[i] = vett[j];
		vett[j] = temp;
	}
		
	// SELECTION SORT COMPATTO CRESCENTE
	/*public static void selectionSort() {
		for(int i = 0; i < vett.length - 1; i++) {
			int minPos = i;
			for(int j = i + 1; j < vett.length; j++) {
				if (vett[j] > vett[minPos])
					minPos = j;
			}
			if (minPos != i) {
				int temp = vett[i];
				vett[i] = vett[minPos];
				vett[minPos] = temp;
			}
		}
	}*/
	
	/*
	Insertion Sort crescente
	*/
	public static void insertionSort() {
		for (int i = 1; i < vett.length; i++) {
			int temp = vett[i];
			int j;
			// Per ordinarlo in forma descrescente basta cambiare il < con il >
			for (j = i; j > 0 && temp > vett[j - 1]; j--)
				vett[j] = vett[j - 1];
			vett[j] = temp;
		}
	}
	
	/*
	Bubble Sort crescente
	*/
	public static void bubbleSort() {
		boolean scambio = true;
		int n = vett.length - 1;
		while (scambio) {
			scambio = false;
			for (int i = 0; i < n; i++) {
				// Per ordinarlo in forma descrescente basta cambiare il < con il >
				if (vett[i + 1] < vett[i]) {
					swap(i, i + 1);
					scambio = true;
				}
			}
			n--;
		}
	}
	
	/*
	Bubble Sort evoluzione
	*/
	public static void sss ( ) {
	for (int i = (vett.length - 1); i >= 1; i = i-1)
		for (int j = 0; j < i; j = j + 1)
			// Per ordinarlo in forma descrescente basta cambiare il > con il <
			if (vett [j] > vett [j+1] ) 
				swap (j , j+1);
	}
	
	/*
	Merge sort crescente in stile Canazza
	*/
	public static void mergeSort() {
		mergeSort(vett, vett.length);
	}
	
	private static void mergeSort(int[] v, int size) {
		if (size < 2)
			return;
		int mid = size / 2;
		int[] left = new int[mid];
		int[] right = new int[size - mid];
		System.arraycopy(v, 0, left, 0, mid);
		System.arraycopy(v, mid, right, 0, size - mid);
		mergeSort(left, mid);
		mergeSort(right, size - mid);
		merge(v, left, right);
	}
	
	private static void merge(int[] v, int[] v1, int[] v2) {
		int i = 0, i1 = 0, i2 = 0;
		while (i1 < v1.length && i2 < v2.length)
			// Per ordinarlo in forma descrescente basta cambiare il < con il >
			if (v1[i1] < v2[i2])
				v[i++] = v1[i1++];
			else
				v[i++] = v2[i2++];
		while (i1 < v1.length)
			v[i++] = v1[i1++];
		while (i2 < v2.length)
			v[i++] = v2[i2++];
	}
	
	public static void print() {
		for(int v : vett)
			System.out.println(v);
	}
}
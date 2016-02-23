public class StringaTest {
	
	private static Stringa[] stringhe;
	
	public static void main(String[] args) {
		
		/*
		9.1.11
		Testo tutti i metodi creati nella classe Stringa
		*/
		
		// Attenzione: Java riconosce 'a' come char, "a" come String.
		Stringa s1 = new Stringa('c');
		Stringa s2 = new Stringa('c', 'i', 'a', 'o');
		Stringa s3 = new Stringa('c', 'i', 'a', 'o');
		
		System.out.println("s1: " + s1.toString());
		System.out.println("s2: " + s2.toString());
		System.out.println("s3: " + s3.toString());
		
		System.out.println("s1 = s2: " + s1.equals(s2));
		System.out.println("s2 = s3: " + s2.equals(s3));
		
		System.out.println("s2 contiene 'c': " + s2.contains('c'));
		System.out.println("s2 contiene 'ci': " + s2.contains('c', 'i'));
		System.out.println("s2 contiene 'ao': " + s2.contains('a', 'o'));
		System.out.println("s2 contiene 'aoo': " + s2.contains('a', 'o', 'o'));
		System.out.println("s2 contiene 'ciii': " + s2.contains('a', 'i', 'i', 'i'));
		
		Stringa s4 = s2.substring(2, 4);		
		System.out.println("s4 substring di s2(1, 3): " + s4.toString());		
		System.out.println("s2 contiene s4: " + s2.contains(s4));
		System.out.println("s4 contiene s2: " + s4.contains(s2));
		
		Stringa s5 = s2.substring('c', 'a');		
		System.out.println("s5 substring di s2(c, a): " + s5.toString());
		
		Stringa s6 = s2.invert();
		System.out.println("s6 inverso di s2: " + s6.toString());
		
		Stringa s7 = s2.concat(s3);
		System.out.println("s7 concatenazione di s2 e s3: " + s7.toString());
				
		System.out.println("s2 comparato con s3: " + s2.compareTo(s3));
		System.out.println("s2 comparato con s4: " + s2.compareTo(s4));
		System.out.println("s4 comparato con s2: " + s4.compareTo(s2));
		System.out.println("s2 comparato con s7: " + s2.compareTo(s7));
		System.out.println("s7 comparato con s2: " + s7.compareTo(s2));
		
		Stringa s8 = new Stringa('c', 'h', 'e');
		Stringa s9 = new Stringa('b', 'e', 'l', 'l', 'o');
		Stringa s10 = new Stringa('j', 'a', 'v', 'a', 'r', 'e');
		
		stringhe = new Stringa[10];
		stringhe[0] = s1;
		stringhe[1] = s2;
		stringhe[2] = s3;
		stringhe[3] = s4;
		stringhe[4] = s5;
		stringhe[5] = s6;
		stringhe[6] = s7;
		stringhe[7] = s8;
		stringhe[8] = s9;
		stringhe[9] = s10;
		System.out.println("\nArray strighe: ");
		print(stringhe);
		
		//selectionSort();
		//insertionSort();
		//bubbleSort();
		mergeSort();
		System.out.println("\nArray strighe ordinato: ");
		print(stringhe);
	}
	
	// 9.2 Creo nella stessa classe anche tutti i metodi di ordinamento.
		
	/*
	9.2.1
	Metodo selectionSort decrescente
	Ho scritto l'algoritmo in un solo metodo.
	L'algoritmo inoltre può essere ottimizzato nel metodo findMinPos eliminando
	l'operazione min = v[i] all'interno del ciclo che di fatto non serve.
	Riporto il metodo che usa il while nel commento.
	*/
	public static void selectionSort() {
		for(int i = 0; i < stringhe.length - 1; i++) {
			int minPos = i;
			for(int j = i + 1; j < stringhe.length; j++) {
				if (stringhe[j].compareTo(stringhe[minPos]) > 0)
					minPos = j;
			}
			if (minPos != i) {
				Stringa temp = stringhe[i];
				stringhe[i] = stringhe[minPos];
				stringhe[minPos] = temp;
			}
		}
	}
	
	/*public static void selectionSort() {
		int i = 0;
		while(i < stringhe.length - 1) {
			int minPos = i;
			for(int j = i + 1; j < stringhe.length; j++) {
				if (stringhe[j].compareTo(stringhe[minPos]) > 0)
					minPos = j;
			}
			if (minPos != i) {
				Stringa temp = stringhe[i];
				stringhe[i] = stringhe[minPos];
				stringhe[minPos] = temp;
			}
			i++;
		}
	}*/
	
	/*
	9.2.2
	Metodo insertionSort decrescente
	In basso ho fatto lo stesso algoritmo in 3 forme diverse usando i while: 
	il primo è identico al metodo non commentato, ma usa il while al posto del for.
	Il secondo e il terzo, invece, ordinano l'array in modo crescente: il secondo parte a 
	ordinare dal primo indice dell'array, mentre il terzo parte dall'ultimo indice dell'array.
	*/
	public static void insertionSort() {
		for (int i = 1; i < stringhe.length; i++) {
			Stringa temp = stringhe[i];
			int j;
			for (j = i - 1; j >= 0 && stringhe[j].compareTo(temp) < 0; j--)
				stringhe[j + 1] = stringhe[j];
			stringhe[j + 1] = temp;
		}
	}
	
	/*public static void insertionSort() {
		for (int i = 1; i < stringhe.length; i++) {
			Stringa temp = stringhe[i];
			int j = i - 1;
			while(j >= 0 && stringhe[j].compareTo(temp) < 0)
				stringhe[j + 1] = stringhe[j--];
			stringhe[j + 1] = temp;
		}
	}*/
	
	/*public static void insertionSort() {
		for (int i = 1; i < stringhe.length; i++) {
			Stringa temp = stringhe[i];
			int j = i - 1;
			while(j >= 0 && stringhe[j].compareTo(temp) > 0)
				stringhe[j + 1] = stringhe[j--];
			stringhe[j + 1] = temp;
		}
	}*/
	
	/*public static void insertionSort() {
		for (int i = stringhe.length - 2; i >= 0; i--) {
			Stringa temp = stringhe[i];
			int j = i + 1;
			while(j <= stringhe.length - 1 && stringhe[j].compareTo(temp) < 0)
				stringhe[j - 1] = stringhe[j++];
			stringhe[j - 1] = temp;
		}
	}*/
	
	/*
	9.2.3
	Metodo bubbleSort decrescente
	Ho deciso di usare un'implementazione leggermente diversa rispetto a quella fatta 
	dal prof. Canazza.
	*/
	public static void bubbleSort() {
		boolean scambio = true;
		while (scambio) {
			scambio = false;
			for (int i = 0; i < stringhe.length - 1; i++) {
				if (stringhe[i].compareTo(stringhe[i + 1]) < 0) {
					Stringa temp = stringhe[i];
					stringhe[i] = stringhe[i + 1];
					stringhe[i + 1] = temp;
					scambio = true;
				}
			}
		}
	}
	
	/*
	9.2.4
	Metodo mergeSort decrescente
	In basso ho fatto anche un merge sort crescente dove, invece di passare 3 array come
	parametri, usa solo i valori di sinistra, centro e destra.
	*/
	public static void mergeSort() {
		mergeSort(stringhe, stringhe.length);
	}
	
	private static void mergeSort(Stringa[] v, int size) {
		if (size < 2)
			return;
		int mid = size / 2;
		Stringa[] left = new Stringa[mid];
		Stringa[] right = new Stringa[size - mid];
		System.arraycopy(v, 0, left, 0, mid);
		System.arraycopy(v, mid, right, 0, size - mid);
		mergeSort(left, mid);
		mergeSort(right, size - mid);
		merge(v, left, right);
	}
	
	private static void merge(Stringa[] v, Stringa[] v1, Stringa[] v2) {
		int i = 0, i1 = 0, i2 = 0;
		while (i1 < v1.length && i2 < v2.length)
			if (v1[i1].compareTo(v2[i2]) > 0)
				v[i++] = v1[i1++];
			else
				v[i++] = v2[i2++];
		while (i1 < v1.length)
			v[i++] = v1[i1++];
		while (i2 < v2.length)
			v[i++] = v2[i2++];
	}
	
	/*public static void mergeSort() {
		mergeSort(0, stringhe.length);
	}
	
	private static void mergeSort(int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(left, center);
			mergeSort(center + 1, right);
			merge(left, center, right);
		}
	}
	
	private static void merge(int left, int center, int right) {
		Stringa [] a = new Stringa[right - left + 1];
		int i = left;
		int j = center + 1;
		int k = 1;
		while (i <= center && j < right) {
			if (stringhe[j].compareTo(stringhe[i]) > 0)
				a[k++] = stringhe[i++];
			else
				a[k++] = stringhe[j++];
		}
		while (i <= center)
			a[k++] = stringhe[i++];
		while (j < right)
			a[k++] = stringhe[j++];
		for (i = left, k = 1; i < right; i++, k++)
			stringhe[i] = a[k];
	}*/
	
	public static void print(Stringa[] stringhe) {
		for(Stringa s : stringhe)
			System.out.println(s.toString());
	}
}

/*
OUTPUT

s1: c
s2: ciao
s3: ciao
s1 = s2: false
s2 = s3: true
s2 contiene 'c': true
s2 contiene 'ci': true
s2 contiene 'ao': true
s2 contiene 'aoo': false
s2 contiene 'ciii': false
s4 substring di s2(1, 3): ao
s2 contiene s4: true
s4 contiene s2: false
s5 substring di s2(c, a): ci
s6 inverso di s2: oaic
s7 concatenazione di s2 e s3: ciaociao
s2 comparato con s3: 0
s2 comparato con s4: 2
s4 comparato con s2: -2
s2 comparato con s7: -4
s7 comparato con s2: 4

Array strighe:
c
ciao
ciao
ao
ci
oaic
ciaociao
che
bello
javare

Array strighe ordinato:
oaic
javare
ciaociao
ciao
ciao
ci
che
c
bello
ao
*/
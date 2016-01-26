public class StringaTest {
	
	private static Stringa[] stringhe;
	
	public static void main(String[] args) {
		
		/*
		9.1.11
		Testo tutti i metodi creati nella classe Stringa
		*/
		
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
		
		//insertionSort();
		//selectionSort();
		bubbleSort();
		System.out.println("\nArray strighe selectionSort: ");
		print(stringhe);
	}
	
	// 9.2 Creo nella stessa classe amche tutti i metodi di ordinamento.
	// Non creo invece la variabile statica che rappresenta l'array di stringhe,
	// perché lo passo direttamente al metodo di ordinamento.
		
	/*
	9.2.1
	Metodo selectionSort decrescente
	Un algoritmo di ordinamento è basato esclusivamente sulla velocità. Creare tre metodi che
	si chiamano uno con l'altro invece di creare un unico metodo, rallenta di molto le
	prestazioni dell'algoritmo. Dal momento che sono solo 15 righe di codice, vale la pena
	scriverle in un metodo unico.
	L'algoritmo può inoltre essere ottimizzato nel primo for ponendo la lunghezza - 1 come
	valore finale.
	In ogni caso non riesco a trovare le slide del Prof. Canazza e non capisco bene cosa 
	cambi usare il while o il for. Usando il while infatti non si avrebbe
	comunque nessuna ottimizzazione, perché i cicli da esequire sono sempe n-1.
	Riporto tutti e due i metodi, con il while commentato.
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
	Metodo insertionSort decrescente.
	in basso invece ho fatto lo stesso algoritmo in ordine crescente in due forme diverse:
	Il primo parte dal primo indice dell'array mentre il secondo parte dall'ultimo indice
	dell'array;
	*/
	public static void insertionSort() {
		for (int i = 1; i < stringhe.length; i++) {
			Stringa temp = stringhe[i];
			int j = i - 1;
			while(j >= 0 && stringhe[j].compareTo(temp) < 0) {
				stringhe[j + 1] = stringhe[j];
				j--;
			}
			stringhe[j + 1] = temp;
		}
	}
	
	/*public static void insertionSort() {
		for (int i = 1; i < stringhe.length; i++) {
			Stringa temp = stringhe[i];
			int j = i - 1;
			while(j >= 0 && stringhe[j].compareTo(temp) > 0) {
				stringhe[j + 1] = stringhe[j];
				j--;
			}
			stringhe[j + 1] = temp;
		}
	}*/
	
	/*public static void insertionSort() {
		for (int i = stringhe.length - 2; i >= 0; i--) {
			Stringa temp = stringhe[i];
			int j = i + 1;
			while(j <= stringhe.length - 1 && stringhe[j].compareTo(temp) < 0) {
				stringhe[j - 1] = stringhe[j];
				j++;
			}
			stringhe[j - 1] = temp;
		}
	}*/
	
	/*
	9.2.3
	Metodo bubbleSort decrescente
	Anche se questa volta non è scritto, decido io di usare il while perché così l'argoritmo è
	più performante.
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
	
	public static void print(Stringa[] stringhe) {
		for(Stringa s : stringhe)
			System.out.println(s.toString());
	}
	
}
public class InsiemeNumeriNaturaliTest {
	
	public static void main(String[] args) {
		
		InsiemeNumeriNaturali i1 = new InsiemeNumeriNaturali(15);
		
		System.out.println("Inserito numero " + i1.inserisci(1) + " a i1");
		System.out.println("Inserito numero " + i1.inserisci(3) + " a i1");
		System.out.println("Inserito numero " + i1.inserisci(4) + " a i1");
		System.out.println("Inserito numero " + i1.inserisci(6) + " a i1");
		System.out.println("Inserito numero " + i1.inserisci(12) + " a i1");
		
		System.out.println("Cancellato numero " + i1.cancella(3) + " a i1");
		
		if (i1.controllaVuoto())
			System.out.println("L'insieme i1 \u00E8 vuoto");
		else
			System.out.println("L'insieme i1 non \u00E8 vuoto");
		
		if (i1.appartiene(1))
			System.out.println("1 appartiene all'insieme i1");
		else
			System.out.println("1 non appartiene all'insieme i1");		
		if (i1.appartiene(3))
			System.out.println("3 appartiene all'insieme i1");
		else
			System.out.println("3 non appartiene all'insieme i1");
		
		InsiemeNumeriNaturali i2 = new InsiemeNumeriNaturali(10);
		System.out.println("Inserito numero " + i2.inserisci(3) + " a i2");
		System.out.println("Inserito numero " + i2.inserisci(4) + " a i2");
		System.out.println("Inserito numero " + i2.inserisci(6) + " a i2");
		System.out.println("Inserito numero " + i2.inserisci(7) + " a i2");
		System.out.println("Inserito numero " + i2.inserisci(9) + " a i2");
		
		System.out.println("i1: " + i1.stampa());
		System.out.println("i2: " + i2.stampa());
		
		InsiemeNumeriNaturali i3 = InsiemeNumeriNaturali.unione(i1, i2);
		InsiemeNumeriNaturali i4 = InsiemeNumeriNaturali.intersezione(i1, i2);
		InsiemeNumeriNaturali i5 = InsiemeNumeriNaturali.complemento(i1, i2);
	
		System.out.println("i1 unito a i2: " + i3.stampa());
		System.out.println("i1 intersecato a i2: " + i4.stampa());
		System.out.println("Complemento di i1 e i2: " + i5.stampa());
	}
}

/*
OUTPUT

Inserito numero 1 a i1
Inserito numero 3 a i1
Inserito numero 4 a i1
Inserito numero 6 a i1
Inserito numero 12 a i1
Cancellato numero 3 a i1
L'insieme i1 non è vuoto
1 appartiene all'insieme i1
3 non appartiene all'insieme i1
Inserito numero 3 a i2
Inserito numero 4 a i2
Inserito numero 6 a i2
Inserito numero 7 a i2
Inserito numero 9 a i2
i1: 1, 4, 6, 12
i2: 3, 4, 6, 7, 9
i1 unito a i2: 1, 3, 4, 6, 7, 9, 12
i1 intersecato a i2: 4, 6
Complemento di i1 e i2: 3, 7, 9
*/
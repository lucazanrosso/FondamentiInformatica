import java.util.Scanner;
import java.util.Arrays;

/*
CLASSE ARITMETICA
Questa classe contiene tutti i metodi legati alle operazioni matematiche fatti nelle esercitazioni
0, 1, 2, 4, 7 e 8. In questa classe non ho mai usato i simboli +, -, *, /, %, ecc., ma ho usato 
sempre i metodi creati, quindi somma, differenzaRelativa, prodotto, ecc. Ho fatto questo
non per migliorare la leggibilità, che anzi peggiora, ma per dimostrare che i metodi funzionano.
*/
public class Aritmetica {
	
	public static Scanner in;
	public static final int OPERAZIONI = 50;
	public static final int OPERAZIONI_SOLO_X = 16;
	public static String[] operazioni;
	public static Integer[] operazioniSoloX;
	
	/*
	MAIN	
	Questo è il metodo principale della classe, dove vengono presi in input il tipo di operazione 
	che si vuole eseguire e i parametri dell'operazione.
	*/
	public static void main (String[] args) {
		inizializzaOperazioni();
		inizializzaOperazioniSoloX();
		
		System.out.println("\nScrivi il numero dell'operazione che vuoi eseguire tra quelle disponibili, quindi premi INVIO");
		for (int i = 0; i < operazioni.length; i++)
			System.out.println("\t" + i + " - " + operazioni[i]);
		
		in = new Scanner(System.in);
		int operazione = inserisciOperazione();
		System.out.println(operazioni[operazione]);
		
		System.out.print("x = ");
		
		int x = inserisciNumero();	
		int y = 0;
		if (! Arrays.asList(operazioniSoloX).contains(operazione)) {
			System.out.print("y = ");
			y = inserisciNumero();
		}
		
		eseguiOperazione(operazione, x, y);
		
		//IL FOR SERVE PER TESTARE TUTTI I METODI CONTEPORANEAMENTE
		/*int x = 3;
		int y = 5;
		for (int i = 0; i < operazioni.length; i++) {
			System.out.println("\n" + operazioni[i]);
			eseguiOperazione(i, x, y);
		}*/
	}
	
	/*
	INIZIALIZZA OPERAZIONI
	Questo metodo ha il compito di inizializzare l'array operazioni con tutti i nomi delle operazioni.
	*/
	public static void inizializzaOperazioni() {
		operazioni = new String[OPERAZIONI];
		operazioni[0] = "Zero";
		operazioni[1] = "Identit\u00E0";
		operazioni[2] = "Successore";
		operazioni[3] = "Prececessore";
		operazioni[4] = "Somma";
		operazioni[5] = "Differenza Relativa";
		operazioni[6] = "Prodotto";
		operazioni[7] = "Quoziente";
		operazioni[8] = "Resto";
		operazioni[9] = "Potenza";
		operazioni[10] = "MCD";
		operazioni[11] = "MCD Alternativo";
		operazioni[12] = "Quadrato";
		operazioni[13] = "Reverse Engeneering";
		operazioni[14] = "Potenza Alternativa";
		operazioni[15] = "Segnatura";
		operazioni[16] = "Contro Segnatura";
		operazioni[17] = "Differenza Assoluta";
		operazioni[18] = "Equals";
		operazioni[19] = "Not";
		operazioni[20] = "And";
		operazioni[21] = "Or";
		operazioni[22] = "Less";
		operazioni[23] = "Massimo";
		operazioni[24] = "Minimo";
		operazioni[25] = "Fattoriale";
		operazioni[26] = "Fattoriale Ricorsivo";
		operazioni[27] = "Predecessore Kleene";
		operazioni[28] = "Differenza Relativa Kleene";
		operazioni[29] = "Somma Kleene";
		operazioni[30] = "Prodotto Kleene";
		operazioni[31] = "Esponenziale Kleene";
		operazioni[32] = "Differenza Assoluta Kleene";
		operazioni[33] = "Radice Quadrata Perfetta";
		operazioni[34] = "Parte Intera Radice Quadrata";
		operazioni[35] = "Multiplo";
		operazioni[36] = "Parte Intera Logaritmo";
		operazioni[37] = "Funzione di Ackermann McCarthy";
		operazioni[38] = "Funzione di Ackermann Iterativa";
		operazioni[39] = "Predecessore McCarthy";
		operazioni[40] = "Somma McCarthy";
		operazioni[41] = "Prodotto McCarthy";
		operazioni[42] = "Differenza McCarthy";
		operazioni[43] = "Minore o Uguale McCarthy";
		operazioni[44] = "Minore McCarthy";
		operazioni[45] = "Quoziente McCarthy";
		operazioni[46] = "Resto McCarthy";
		operazioni[47] = "Divisibile McCarthy";
		operazioni[48] = "Sequenza Fibonacci Ricorsiva";
		operazioni[49] = "Sequenza Fibonacci Iterativa";
	}
	
	
	/*
	OPERAZIONI SOLO X
	Questo metodo inizializza l'array operazioniSoloX, che conterrà le operazioni che richiedono
	un solo parametro.
	*/
	public static void inizializzaOperazioniSoloX() {
		operazioniSoloX = new Integer[OPERAZIONI_SOLO_X];
		operazioniSoloX[0] = 0;
		operazioniSoloX[1] = 1;
		operazioniSoloX[2] = 2;
		operazioniSoloX[3] = 4;
		operazioniSoloX[4] = 12;
		operazioniSoloX[5] = 15;
		operazioniSoloX[6] = 16;
		operazioniSoloX[7] = 19;
		operazioniSoloX[8] = 25;
		operazioniSoloX[9] = 26;
		operazioniSoloX[10] = 27;
		operazioniSoloX[11] = 33;
		operazioniSoloX[12] = 34;
		operazioniSoloX[13] = 39;
		operazioniSoloX[14] = 48;
		operazioniSoloX[15] = 49;
	}
	
	/*
	INSERISCI NUMERO
	Controlla che il numero inserito sia intero e positivo.
	*/
	public static int inserisciNumero() {
		int x = in.nextInt();
		while (x < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			x = in.nextInt();
		}
		return x;
	}
	
	/*
	INSERISCI OPERAZIONE
	Controlla che il numero inserito sia compreso tra le operazioni disponibili.
	*/
	public static int inserisciOperazione() {
		int operazione = in.nextInt();
		while (operazione < 0 || operazione > OPERAZIONI - 1) {
			System.out.println("Hai inserito un'operazione sbagliata, inserisci un numero tra quelli disponibili");
			operazione = in.nextInt();
		}
		return operazione;
	}
	
	/*
	ESEGUI OPERAZIONE
	Esegue l'operazione con i parametri passati in input.
	*/
	public static void eseguiOperazione(int operazione, int x, int y) {
		System.out.print("Risultato: ");
		switch(operazione) {
			case 0:
				System.out.println(zero(x));
				break;
			case 1:
				System.out.println(identita(x));
				break;
			case 2:
				System.out.println(successore(x));
				break;
			case 3:
				System.out.println(predecessore(x));
				break;
			case 4:
				System.out.println(somma(x, y));
				break;
			case 5:
				System.out.println(differenzaRelativa(x, y));
				break;
			case 6:
				System.out.println(prodotto(x, y));
				break;
			case 7:
				if (y == 0)
					System.out.println("Impossibile dividere per 0");
				else
					System.out.println(divisione(x, y, true));
				break;
			case 8:
				if (y == 0)
					System.out.println("Impossibile dividere per 0");
				else
					System.out.println(divisione(x, y, false));
				break;
			case 9:
				if (x == 0 && y == 0)
					System.out.println("Impossibile elevare 0 alla 0");
				else
				System.out.println(potenza(x, y));
				break;
			case 10:
				System.out.println(mcd(x, y));
				break;
			case 11:
				System.out.println(mcdAlternativo(x, y));
				break;
			case 12:
				System.out.println(quadrato(x));
				break;
			case 13:
				System.out.println(reverseEngineering(x, y));
				break;
			case 14:
				if (x == 0 && y == 0)
					System.out.println("Impossibile elevare 0 alla 0");
				else
				System.out.println(potenzaAlternativa(x, y));
				break;
			case 15:
				System.out.println(segnatura(x));
				break;
			case 16:
				System.out.println(controSegnatura(x));
				break;
			case 17:
				System.out.println(differenzaAssoluta(x, y));
				break;
			case 18:
				System.out.println(equals(x, y));
				break;
			case 19:
				System.out.println(not(x));
				break;
			case 20:
				System.out.println(and(x, y));
				break;
			case 21:
				System.out.println(or(x, y));
				break;
			case 22:
				System.out.println(less(x, y));
				break;
			case 23:
				System.out.println(massimo(x, y));
				break;
			case 24:
				System.out.println(minimo(x, y));
				break;
			case 25:
				System.out.println(fattoriale(x));
				break;
			case 26:
				System.out.println(fattorialeRicorsivo(x));
				break;
			case 27:
				System.out.println(predecessoreKleene(x));
				break;
			case 28:
				System.out.println(differenzaRelativaKleene(x, y));
				break;
			case 29:
				System.out.println(sommaKleene(x, y));
				break;
			case 30:
				System.out.println(prodottoKleene(x, y));
				break;
			case 31:
				System.out.println(esponenzialeKleene(x, y));
				break;
			case 32:
				System.out.println(differenzaAssolutaKleene(x, y));
				break;
			case 33:
				if (controllaQuadratoPerfetto(x))
					System.out.println(radiceQuadrataPerfetta(x));
				else
					System.out.println(x + " non \u00E8 un quadrato perfetto");
				break;
			case 34:
				System.out.println(parteInteraRadiceQuadrata(x));
				break;
			case 35:
				if (y == 0)
					System.out.println("Non esiste un numero multiplo di 0");
				else if (controllaMultiplo(x, y))
					System.out.println(x + " \u00E8 un multiplo di " + y);
				else
					System.out.println(x + " non \u00E8 un multiplo di " + y);
				break;
			case 36:
				if (x == 0)
					System.out.println("Non esiste il logaritmo di 0");	
				else if (y == 0)
					System.out.println("Non esiste il logaritmo in base 0");
				else if (y == 1)
					System.out.println("Non esiste il logaritmo in base 1");			
				else
					System.out.println(parteInteraLogaritmo(x, y));
				break;
			case 37:
				System.out.println(funzioneAckermannMcCarthy(x, y));
				break;
			case 38:
				System.out.println(funzioneAckermannIterativa(x, y));
				break;
			case 39:
				System.out.println(predecessoreMcCarthy(x));
				break;
			case 40:
				System.out.println(sommaMcCarthy(x, y));
				break;
			case 41:
				System.out.println(prodottoMcCarthy(x, y));
				break;
			case 42:
				System.out.println(differenzaRelativaMcCarthy(x, y));
				break;	
			case 43:
				if (minoreUgualeMcCarthy(x, y))
					System.out.println(x + " \u00E8 minore o uguale di " + y);
				else
					System.out.println(x + " non \u00E8 minore o uguale di " + y);
				break;
			case 44:
				if (minoreMcCarthy(x, y))
					System.out.println(x + " \u00E8 minore di " + y);
				else
					System.out.println(x + " non \u00E8 minore di " + y);
				break;
			case 45:
				if (y == 0)
					System.out.println("Impossibile dividere per 0");
				else
					System.out.println(quozienteMcCarthy(x, y));
				break;
			case 46:
				if (y == 0)
					System.out.println("Impossibile dividere per 0");
				else
					System.out.println(restoMcCarthy(x, y));
				break;
			case 47:
				if (y == 0)
					System.out.println("Non esiste un numero divisibile per 0");
				else if (divisibileMcCarthy(x, y))
					System.out.println(x + " \u00E8 divisibile per " + y);
				else
					System.out.println(x + " non \u00E8 divisibile per " + y);
				break;
			case 48:
				System.out.println(sequenzaFibonacciRicorsiva(x));
				System.out.println("Iterazioni " + contaFibRic);
				break;
			case 49:
				System.out.println(sequenzaFibonacciIterativa(x));
				System.out.println("Iterazioni " + contaFibIte);
				break;
		}
	}
	
	
	public static int zero(int x) {
		return 0;
	}
	
	public static int identita(int x) {
		return x;
	}
	
	public static int successore(int x) {
		return ++x;
	}
	
	/*
	1.2.1
	PREDECESSORE
	*/
	public static int predecessore(int x) {	
		int y = 0;
		int z = y;
		while (x != y) {
			z = y;
			y = successore(y);
		}
		return z;
	}
	
	/*
	1.1
	SOMMA
	*/
	public static int somma(int x, int y) {
		while (y != 0) {
			x = successore(x);
			y = predecessore(y);
		}
		return x;
	}
	
	/*
	1.2.2
	DIFFERENZA RELATIVA
	*/
	public static int differenzaRelativa(int x, int y) {
		while (y != 0) {
			x = predecessore(x);
			y = predecessore(y);
		}
		return x;
	}
	
	/*
	1.2.3
	PRODOTTO
	*/
	public static int prodotto(int x, int y) {
		int z = 0;
		while (y != 0) {
			z = somma(z, x);
			y = predecessore(y);
		}
		return z;
	}
	
	/*
	1.2.4
	DIVISIONE
	Ricordo che il terzo parametro viene usato a seconda se come risultato voglio il 
	quoziente o il resto: true per il quoziente, false per il resto.
	*/
	public static int divisione(int x, int y, boolean isQuotient) {	
		int z = 0;	
		while (x >= y) {
			z = successore(z);
			x = differenzaRelativa(x, y);
		}		
		if (isQuotient)
			return z;
		else
			return x;
	}
	
	/*
	1.2.5 e 2.4
	POTENZA
	*/
	public static int potenza(int x, int y) {
		int z = x;	
		if (y == 0)
			return 1;
		while (y != 1) {
			z = prodotto(z, x);
			y = predecessore(y);
		}	
		return z;
	}

	
	/*
	2.1
	MCD
	Ho deciso di usare 3 cicli while al posto di 1 ciclo do-while e 2 cicli while.
	*/
	public static int mcd(int x, int y) {
		if (x == 0 || y == 0)
			return 0;
		while (x != y) {
			while (x > y)
				x = differenzaRelativa(x, y);
			while (x < y)
				y = differenzaRelativa(y, x);
		}	
		return x;
	}
	
	/*
	MCD ALTERNATIVO
	Un MCD più performante rispetto al precedente.
	*/
	public static int mcdAlternativo(int x, int y) {
		int parcheggio;		
		if (x < y) {
			parcheggio = x;
			x = y;
			y = parcheggio;
		}		
		if (y == 0)
			return 0;
		while (y != 0) {
			parcheggio = y;
			y = divisione(x, y, false);
			x = parcheggio;
		}		
		return x;
	}
	
	/*
	2.2
	QUADRATO
	*/
	public static int quadrato(int x) {		
		int controller = 0;
		int quadrato = 0;		
		while (x != controller) {
			quadrato = somma(quadrato, somma(prodotto(controller, 2), 1));
			controller = successore(controller);
		}		
		return quadrato;
	}
	
	/*
	2.3
	REVERSE ENGINEERING
	Questo algoritmo funziona nella stessa identia maniera del prodotto. L'unica differenza 
	è che se immettiamo 0 come y, invece di restituirci 0 come avviene nel prodotto, ci 
	restituirà il valore di x dato in input. Se scriviamo reverseEngineering(6, 1) o 
	reverseEngineering(6, 0) ci verrà restituito sempre 6.
	*/
	public static int reverseEngineering(int x, int y) {
		int z = 0;		
		do {
			z = somma(z, x);
			y = predecessore(y);
		} while (y != 0);		
		return z;
	}

	/*
	2.5
	POTENZA ALTERNATIVA
	Metodo alternativo alla potenza e che diventa sempre più performante all'aumentare 
	dell'esponente.
	*/
	public static int potenzaAlternativa(int x, int y) {
		int z = 1;		
		while (y != 0) {
			/*
			Questo è il test che viene fatto per vedere se un numero è pari o dispari. Non ho
			usato il sistema fatto dal professore (pongo n1 = n div 2, e se n = (n1 * 2) + 1 allora
			n è dispari altrimenti è pari), ma ho testato il resto di y diviso 2. 
			Se il resto è 0 allora è pari, se il resto è 1 allora è dispari.
			*/
			if (divisione(y, 2, false) == 1)
				z = prodotto(z, x);
			x = quadrato(x);
			y = divisione(y, 2, true);
		}		
		return z;
	}

	
	/*
	4.2.1
	Segnatura e contro segnatura
	NON ho usato i while program.
	*/
	public static int segnatura(int x) {
		if (x == 0)
			return zero(x);
		return successore(zero(x));
	}
	
	public static int controSegnatura(int x) {
		return differenzaRelativa(1, segnatura(x));
	}
	
	/*
	4.2.2
	Valore assoluto della differenza
	*/
	public static int differenzaAssoluta(int x, int y) {
		return somma(differenzaRelativa(x, y), differenzaRelativa(y, x));
	}
	
	/*
	4.2.3
	Uguaglianza
	*/
	public static int equals(int x, int y) {
		return controSegnatura(differenzaAssoluta(x, y));
	}
	
	/*
	4.2.tra il 3 e il 4
	Operatori logici booleani
	*/
	public static int not(int x) {
		return controSegnatura(x);
	}
	
	public static int and(int x, int y) {
		return segnatura(prodotto(x, y));
	}
	
	public static int or(int x, int y) {
		return segnatura(somma(x, y));
	}
	
	public static int less(int x, int y) {
		return segnatura(differenzaRelativa(x, y));
	}
	
	/*
	4.2.4
	Minimo e massimo
	NON ho usato i while program
	*/
	public static int massimo(int x, int y) {
		return somma(x, differenzaRelativa(y, x));
	}
	
	public static int minimo(int x, int y) {
		return differenzaRelativa(x, differenzaRelativa(x, y));
	}
	
	
	/*
	7.1
	Metodi fattoriale e fattorialeRicorsivo
	*/
	public static int fattoriale(int x) {
		int s = 0;
		int z = 1;
		while (x != s) {
			s = successore(s);
			z = prodotto(z, s);
		}
		return z;
	}
	
	public static int fattorialeRicorsivo(int x) {
		if (x == 0)
			return 1;
		return x * fattorialeRicorsivo(predecessore(x));
	}
	
	/*
	7.2.1
	Predecessore costruito con il formalismo di Kleene
	*/
	public static int predecessoreKleene(int x) {
		if (x == 0)
			return zero(x);
		return identita(x) - 1;
	}
	
	/*
	7.2.2
	Differenza relativa costruita con il formalismo di Kleene.
	*/
	public static int differenzaRelativaKleene(int x, int y) {
		if (y == 0)
			return x;
		return predecessoreKleene(differenzaRelativaKleene(x, predecessoreKleene(y)));
	}
	
	/*
	7.2.3
	Somma, prodotto e esponenziale costruiti con il formalismo di Kleene
	*/
	public static int sommaKleene(int x, int y) {
		if (x == 0)
			return y;
		else if (y == 0)
			return x;
		else
			return successore(sommaKleene(x, predecessoreKleene(y)));
	}
	
	public static int prodottoKleene(int x, int y) {
		if (x == 0 || y == 0)
			return 0;
		else
			return sommaKleene(x, prodottoKleene(x, predecessoreKleene(y)));
	}
	
	public static int esponenzialeKleene(int x, int y) {
		if (y == 0)
			return 1;
		else
			return prodottoKleene(x, esponenzialeKleene(x, predecessoreKleene(y)));
	}

	/*
	7.2.4
	Differenza Assoluta Riorsiva. Avevo già fatto lo stesso metodo in qualche esercitazione
	fa usando la minimalizzazione, ma lo rifaccio usando i nuovi metodi ricorsivi appena creati.
	*/
	public static int differenzaAssolutaKleene(int x, int y) {
		return sommaKleene(differenzaRelativaKleene(x, y), differenzaRelativaKleene(y, x));
	}
	
	/*
	7.3.1
	Metodo controllaQuadratoPerfetto e radiceQuadrataPerfetta. Faccio anche il metodo di 
	controllo per rendere anche la semplice radice quadrata una funzione totale.
	*/
	public static boolean controllaQuadratoPerfetto(int x) {
		int y = 0;
		while (differenzaRelativaKleene(x, prodottoKleene(y, y)) != 0)
			y = successore(y);
		if (x == prodottoKleene(y, y))
			return true;
		return false;
	}
	
	public static int radiceQuadrataPerfetta(int x) {
		int y = 0;
		while (differenzaRelativaKleene(x, prodottoKleene(y, y)) != 0)
			y = successore(y);
		return y;
	}
	
	/*
	7.3.2
	Metodo parteInteraRadiceQuadrata
	*/
	public static int parteInteraRadiceQuadrata(int x) {
			int y = 0;
			while (differenzaRelativaKleene(x, predecessoreKleene(prodottoKleene(successore(y), successore(y)))) != 0)
				y = successore(y);
			return y;
	}
	
	/*
	7.3.3
	Metodo controllaMultiplo e multiplo. Ho introdotto una seconda variabile in input in modo
	da generalizzare il metodo, quindi x non deve essere per forza multiplo 33. 
	*/
	public static boolean controllaMultiplo(int x, int y) {
		int z = 0;
		while (differenzaRelativaKleene(x, prodottoKleene(y, z)) != 0)
			z = successore(z);
		if (x == prodottoKleene(y, z))
			return true;
		return false;
	}
	
	public static int multiplo(int x, int y) {
		int z = 0;
		while (differenzaRelativaKleene(x, prodottoKleene(y, z)) != 0)
			z = successore(z);
		return z;
	}
	
	/*
	7.3.4
	Metodo parteInteraLogaritmo. Ho deciso di usare anche una seconda variabile in modo da
	poter decidere al momento la base del logaritmo. Bisogna quindi limitare anche la base 
	del logaritmo che dovra essere >= 2. 
	*/
	public static int parteInteraLogaritmo(int x, int y) {
		int z = 0;
		while (differenzaRelativaKleene(successore(x), esponenzialeKleene(y, z + 1)) != 0)
			z = successore(z);
		return z;
	}
	
	
	/*
	8.1
	Metodi funzioneAckermannMcCarthy e funzioneAckermannIterativa. Quando si testano è meglio 
	usare numeri piccoli, altrimenti il programma va in loop o restituisce l'eccezione 
	ArrayIndexOutOfBoundsException (nel caso del metodo iterativo).
	*/
	public static int funzioneAckermannMcCarthy(int x, int y) {
		if (x == 0)
			return successore(y);
		else if (y == 0)
			return funzioneAckermannMcCarthy(predecessore(x), 1);
		else
			return funzioneAckermannMcCarthy(predecessore(x), funzioneAckermannMcCarthy(x, predecessore(y)));
	}
	
	public static int funzioneAckermannIterativa(int x, int y) {
		int[] z = new int[1024];
		z[1] = x;
		z[2] = y;
		int i = 2;
		while (i != 1) {				
			if (z[predecessore(i)] == 0) {
				z[predecessore(i)] = successore(z[i]);
				i = predecessore(i);
			} else if (z[i] == 0) {
				z[predecessore(i)] = predecessore(z[predecessore(i)]);
				z[i] = 1;
			} else {
				z[successore(i)] = predecessore(z[i]);
				z[i] = z[predecessore(i)];
				z[predecessore(i)] = predecessore(z[predecessore(i)]);
				i = successore(i);
			}
		}
		return z[1];
	}
	
	/*
	8.2.1
	Metodi predecessore, somma, prodotto, differenzaRelativa nel formalismo di McCarthy.
	Il predecessore, così come descritto nell'esercitazione, non funziona se si inserisce 0
	come parametro, perchè andrà in loop. Inserisco quindi un controllo nel prececessore.
	*/	
	public static int predecessoreMcCarthy(int x) {
		if (x == 0)
			return 0;
		return predecessoreMcCarthy(x, 0);
	}
	
	public static int predecessoreMcCarthy(int x, int y) {
		if (successore(y) == x)
			return y;
		return predecessoreMcCarthy(x, successore(y));
	}
	
	public static int sommaMcCarthy(int x, int y) {
		if (y == 0)
			return x;
		return sommaMcCarthy(successore(x), predecessoreMcCarthy(y));
	}
	
	public static int prodottoMcCarthy(int x, int y) {
		if (y == 0)
			return 0;
		return sommaMcCarthy(x, prodottoMcCarthy(x, predecessoreMcCarthy(y)));
	}
	
	public static int differenzaRelativaMcCarthy(int x, int y) {
		if (y == 0)
			return x;
		return differenzaRelativaMcCarthy(predecessoreMcCarthy(x), predecessoreMcCarthy(y));
	}
	
	/*
	8.2.2
	Metodi not, and, or, implica, minoreUguale, minore, quoziente, resto, divisibile,
	creati usando il formalismo di McCarthy. Anche se i nomi not, and, or sono già stati usati
	per altri metodi, java non genera errori, perché i parametri in questo caso sono 
	di tipo boolean, quindi si tratta di overlaod.
	Faccio un appunto importante per il metodo minoreUguale e divisibile. Se si usa il metodo 
	and come descritto nell'esercitazione, il programma andrà sempre in loop. Questo perché il 
	metodo and non implementa la logica dello short circuit. Con lo short circuit, infatti, 
	appena viene trovato un valore false vengono saltati tutti gli altri controlli, 
	perché non necessari. In questo caso al metodo and vengono passati sempre tutti i valori,
	anche nel caso in cui il primo valore sia false, perciò, usando la ricorsione in questa
	maniera si andrà sempre un loop. Lo stesso discorso vale per il metodo or e implica.
	*/
	public static boolean not(boolean x) {
		if (x)
			return false;
		return true;
	}
	
	public static boolean and(boolean x, boolean y) {
		if (x)
			return y;
		return false;
	}
	
	public static boolean or(boolean x, boolean y) {
		if (x)
			return true;
		return y;
	}
	
	public static boolean implica (boolean x, boolean y) {
		if (x)
			return y;
		return true;
	}
	
	public static boolean minoreUgualeMcCarthy(int x, int y) {
		//return or(x == 0, and(not(y == 0), (minoreUguale(predecessore(x), predecessore(y)))));
		return or(x == 0, (not(y == 0) && minoreUgualeMcCarthy(predecessore(x), predecessore(y))));
	}

	public static boolean minoreMcCarthy(int x, int y) {
		return and(minoreUgualeMcCarthy(x, y), not(x == y));
	}

	public static int quozienteMcCarthy(int x, int y) {
		if (minoreMcCarthy(x, y))
			return 0;
		return successore(quozienteMcCarthy(differenzaRelativaKleene(x, y), y));
	}
	
	public static int restoMcCarthy(int x, int y) {
		if (minoreMcCarthy(x, y))
			return x;
		return restoMcCarthy(differenzaRelativaKleene(x, y), y);
	}
	
	public static boolean divisibileMcCarthy(int x, int y) {
		return or(x == 0, (not(minoreMcCarthy(x, y)) && divisibileMcCarthy(differenzaRelativaMcCarthy(x, y), y)));
	}
	
	/*
	8.2.3 e 8.2.4
	Tutti i metodi richiesti sono già stati fatti nell'esercitazione 4 e sono presenti anche sopra.
	*/
	
	/*
	8.3
	Metodi sequenzaFibonacciRicorsiva e sequenzaFibonacciIterativa.
	Testando la sequenza di Fibonacci, ad esempio, con il numero nove, 
	si ottengono 67 chiamate per il metodo sequenzaFibonacciRicorsiva e 7 iterazioni
	per il metodo sequenzaFibonacciIterativa. La crescita delle chiamate del metodo
	sequenzaFibonacciRicorsiva sarà esponenziale rispetto al numero scelto, mentre il numero
	di iterazioni del metodo sequenzaFibonacciIterativa sarà sempre il numero scelto - 2.
	*/
	public static int contaFibRic = 0;
	public static int sequenzaFibonacciRicorsiva(int x) {
		contaFibRic++;
		if (x <= 2)
			return 1;
		return somma(sequenzaFibonacciRicorsiva(predecessore(x)), sequenzaFibonacciRicorsiva(predecessore(predecessore(x))));
	}
	
	public static int contaFibIte = 0;
	public static int sequenzaFibonacciIterativa(int x) {
		int j = 0;
		if (x <= 2)
			return 1;
		int a = 1;
		int b = 1;
		int c = 1;
		for (int i = 3; i <= x; i++) {
			c = somma(a, b);
			a = b;
			b = c;
			contaFibIte++;
		}
		return c;		
	}
}

/*
OUTPUT
x = 3
y = 5

Zero
Risultato: 0

Identità
Risultato: 3

Successore
Risultato: 4

Prececessore
Risultato: 2

Somma
Risultato: 8

Differenza Relativa
Risultato: 0

Prodotto
Risultato: 15

Quoziente
Risultato: 0

Resto
Risultato: 3

Potenza
Risultato: 243

MCD
Risultato: 1

MCD Alternativo
Risultato: 1

Quadrato
Risultato: 9

Reverse Engeneering
Risultato: 15

Potenza Alternativa
Risultato: 243

Segnatura
Risultato: 1

Contro Segnatura
Risultato: 0

Differenza Assoluta
Risultato: 2

Equals
Risultato: 0

Not
Risultato: 0

And
Risultato: 1

Or
Risultato: 1

Less
Risultato: 0

Massimo
Risultato: 5

Minimo
Risultato: 3

Fattoriale
Risultato: 6

Fattoriale Ricorsivo
Risultato: 6

Predecessore Kleene
Risultato: 2

Differenza Relativa Kleene
Risultato: 0

Somma Kleene
Risultato: 8

Prodotto Kleene
Risultato: 15

Esponenziale Kleene
Risultato: 243

Differenza Assoluta Kleene
Risultato: 2

Radice Quadrata Perfetta
Risultato: 3 non è un quadrato perfetto

Parte Intera Radice Quadrata
Risultato: 1

Multiplo
Risultato: 3 non è un multiplo di 5

Parte Intera Logaritmo
Risultato: 0

Funzione di Ackermann McCarthy
Risultato: 253

Funzione di Ackermann Iterativa
Risultato: 253

Predecessore McCarthy
Risultato: 2

Somma McCarthy
Risultato: 8

Prodotto McCarthy
Risultato: 15

Differenza McCarthy
Risultato: 0

Minore o Uguale McCarthy
Risultato: 3 è minore o uguale di 5

Minore McCarthy
Risultato: 3 è minore di 5

Quoziente McCarthy
Risultato: 0

Resto McCarthy
Risultato: 3

Divisibile McCarthy
Risultato: 3 non è divisibile per 5

Sequenza Fibonacci Ricorsiva
Risultato: 2
Iterazioni 3

Sequenza Fibonacci Iterativa
Risultato: 2
Iterazioni 1
*/
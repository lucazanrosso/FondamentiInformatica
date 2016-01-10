import java.util.Scanner;
import java.util.Arrays;

public class Aritmetica {
	
	public static Scanner in;
	public static final int OPERAZIONI = 50;
	public static final int OPERAZIONI_SOLO_X = 16;
	public static String[] operazioni;
	public static int[] operazioniSoloX;
	
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
		
		
		//IL FOR SERVE PER TESTARE TUTTI I METODI IN POCHE RIGHE
		/*int x = 4;
		int y = 3;
		for (int i = 0; i < operazioni.length; i++) {
			System.out.println("\n" + operazioni[i]);
			eseguiOperazione(i, x, y);
		}*/
	}
	
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
		operazioni[27] = "Predecessore Ricorsivo";
		operazioni[28] = "Differenza Relativa Ricorsiva";
		operazioni[29] = "Somma Ricorsiva";
		operazioni[30] = "Prodotto Ricorsivo";
		operazioni[31] = "Esponenziale Ricorsivo";
		operazioni[32] = "Differenza Assoluta Ricorsiva";
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
	
	public static void inizializzaOperazioniSoloX() {
		operazioniSoloX = new int[OPERAZIONI_SOLO_X];
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
		operazioniSoloX[13] = 48;
		operazioniSoloX[13] = 49;
	}
	
	public static int inserisciNumero() {
		int x = in.nextInt();
		while (x < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			x = in.nextInt();
		}
		return x;
	}
	
	public static int inserisciOperazione() {
		int operazione = in.nextInt();
		while (operazione < 0 || operazione > OPERAZIONI - 1) {
			System.out.println("Hai inserito un'operazione sbagliata, inserisci un numero tra quelli disponibili");
			operazione = in.nextInt();
		}
		return operazione;
	}
	
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
				System.out.println(predecessoreRicorsivo(x));
				break;
			case 28:
				System.out.println(differenzaRelativaRicorsiva(x, y));
				break;
			case 29:
				System.out.println(sommaRicorsiva(x, y));
				break;
			case 30:
				System.out.println(prodottoRicorsivo(x, y));
				break;
			case 31:
				System.out.println(esponenzialeRicorsivo(x, y));
				break;
			case 32:
				System.out.println(differenzaAssolutaRicorsiva(x, y));
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
				if (minore(x, y))
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
				break;
			case 49:
				System.out.println(sequenzaFibonacciIterativa(x));
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
	
	public static int predecessore(int x) {	
		int y = 0;
		int z = y;
		while (x != y) {
			z = y;
			y = successore(y);
		}
		return z;
	}
	
	public static int somma(int x, int y) {
		while (y != 0) {
			x = successore(x);
			y = predecessore(y);
		}
		return x;
	}
	
	public static int differenzaRelativa(int x, int y) {
		while (y != 0) {
			x = predecessore(x);
			y = predecessore(y);
		}
		return x;
	}
	
	public static int prodotto(int x, int y) {
		int z = 0;
		while (y != 0) {
			z = somma(z, x);
			y = predecessore(y);
		}
		return z;
	}
	
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
	
	public static int quadrato(int x) {		
		int controller = 0;
		int quadrato = 0;		
		while (x != controller) {
			quadrato = somma(quadrato, somma(prodotto(controller, 2), 1));
			controller = successore(controller);
		}		
		return quadrato;
	}
	
	public static int reverseEngineering(int x, int y) {
		int z = 0;		
		do {
			z = somma(z, x);
			y = predecessore(y);
		} while (y != 0);		
		return z;
	}

	public static int potenzaAlternativa(int x, int y) {
		int z = 1;		
		while (y != 0) {
			if (divisione(y, 2, false) == 1)
				z = prodotto(z, x);
			x = quadrato(x);
			y = divisione(y, 2, true);
		}		
		return z;
	}

	
	public static int segnatura(int x) {
		if (x == 0)
			return zero(x);
		return successore(zero(x));
	}
	
	public static int controSegnatura(int x) {
		return differenzaRelativa(1, segnatura(x));
	}
	
	public static int differenzaAssoluta(int x, int y) {
		return somma(differenzaRelativa(x, y), differenzaRelativa(y, x));
	}
	
	public static int equals(int x, int y) {
		return controSegnatura(differenzaAssoluta(x, y));
	}
	
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
	
	public static int massimo(int x, int y) {
		return somma(x, differenzaRelativa(y, x));
	}
	
	public static int minimo(int x, int y) {
		return differenzaRelativa(x, differenzaRelativa(x, y));
	}
	
	
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
	
	public static int predecessoreRicorsivo(int x) {
		if (x == 0)
			return zero(x);
		return identita(x) - 1;
	}
	
	public static int differenzaRelativaRicorsiva(int x, int y) {
		if (y == 0)
			return x;
		return predecessoreRicorsivo(differenzaRelativaRicorsiva(x, predecessoreRicorsivo(y)));
	}
	
	public static int sommaRicorsiva(int x, int y) {
		if (x == 0)
			return y;
		else if (y == 0)
			return x;
		else
			return successore(sommaRicorsiva(x, predecessoreRicorsivo(y)));
	}
	
	public static int prodottoRicorsivo(int x, int y) {
		if (x == 0 || y == 0)
			return 0;
		else
			return sommaRicorsiva(x, prodottoRicorsivo(x, predecessoreRicorsivo(y)));
	}
	
	public static int esponenzialeRicorsivo(int x, int y) {
		if (y == 0)
			return 1;
		else
			return prodottoRicorsivo(x, esponenzialeRicorsivo(x, predecessoreRicorsivo(y)));
	}

	public static int differenzaAssolutaRicorsiva(int x, int y) {
		return sommaRicorsiva(differenzaRelativaRicorsiva(x, y), differenzaRelativaRicorsiva(y, x));
	}
	
	public static boolean controllaQuadratoPerfetto(int x) {
		int y = 0;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, y)) != 0)
			y = successore(y);
		if (x == prodottoRicorsivo(y, y))
			return true;
		return false;
	}
	
	public static int radiceQuadrataPerfetta(int x) {
		int y = 0;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, y)) != 0)
			y = successore(y);
		return y;
	}
	
	public static int parteInteraRadiceQuadrata(int x) {
			int y = 0;
			while (differenzaRelativaRicorsiva(x, predecessoreRicorsivo(prodottoRicorsivo(successore(y), successore(y)))) != 0)
				y = successore(y);
			return y;
	}
	
	public static boolean controllaMultiplo(int x, int y) {
		int z = 0;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, z)) != 0)
			z = successore(z);
		if (x == prodottoRicorsivo(y, z))
			return true;
		return false;
	}
	
	public static int multiplo(int x, int y) {
		int z = 0;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, z)) != 0)
			z = successore(z);
		return z;
	}
	
	public static int parteInteraLogaritmo(int x, int y) {
		int z = 0;
		while (differenzaRelativaRicorsiva(successore(x), esponenzialeRicorsivo(y, z + 1)) != 0)
			z = successore(z);
		return z;
	}
	
	/*
	8.1
	Metodi funzioneAckermannMcCarthy e funzioneAckermannIterativa
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
		int[] z = {0, x, y, 0};
		int i = 2;
		if (i == 1)
			return z[1];
		else if (z[predecessore(i)] == 0) {
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
		return 0;
	}
	
	/*
	8.2.1
	Metodi sommaMcCarthy, sommaMcCarthy, sommaMcCarthy,
	I metodi predecessore, somma, prodotto e differenza sono già stati definiti con la
	logica ricorsiva con il formalismo di Kleene (se non sbaglio), ma li riscrivo usando
	il formalismo di McCarthy.
	Ho notato che il predecessore non funziona se y >= x. Si potrebbe correggere ponendo 
	y = 0 se y >= x, ma dal momento che deve essere usato solo il metodo con un solo parametro
	non lo faccio.
	Per quanto riguarda la differenza, il programma va in loop se se x >= y, perciò
	aggiungo un controllo per evitare che questo accada.
	*/
	
	public static int predecessoreMcCarthy(int x) {
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
		if (x < y)
			return 0;
		if (y == 0)
			return x;
		return differenzaRelativaMcCarthy(predecessoreMcCarthy(x), predecessoreMcCarthy(y));
	}
	
	/*
	8.2.2
	Metodi not, and, or, implica, minoreUguale, minore, quoziente, resto, divisibile
	creati usando il formalismo di McCarthy. Anche se i nomi not, and, or sono già stati usati
	per altri metodi, java non genera errori, perché il tipo di ritorno e i parametri 
	in questo caso sono di tipo boolean, quindi si tratta di overlaod.
	Faccio un appunto importante per il metodo minoreUguale e divisibile. Se si usa il metodo 
	and come descritto nell'esercitazione, il programma andrà sempre in loop. Questo perché il 
	metodo and (e anche or) non implementa la logica dello short circuit, cioè, appena viene 
	trovato un valore false (true nel caso dell'or) vengono saltati tutti gli altri controlli, 
	perché non necessari. In questo caso al metodo and vengono passati sempre tutti i valori,
	anche nel caso in cui il primo valore sia false, perciò, in un metodo ricorsivo questo genera 
	un loop.
	Ci sono poi alcuni errori nelle descrizioni dei metodi:
	1) Nella descrizione del metodo rem (che io ho chiamato restoRicorsivo), dove c'è 
	lo / della divisione, in realtà bisogna mettere una virgola.
	2) nella descrizione del metodo | (che io ho chiamato divisibieRicorsivo), 
	il metodo m >= n si ottiene nagando il metodo m < n, non m <= n.
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
	
/*
	public static boolean implicaMcCarthy (boolean x, boolean y) {
		if (segnatura(x) == 1)
			return 1;
		return segnatura(y);
	}*/
	
	public static boolean minoreUgualeMcCarthy(int x, int y) {
		//return or(x == 0, and(not(y == 0), (minoreUguale(predecessore(x), predecessore(y)))));
		return or(x == 0, (not(y == 0) && minoreUgualeMcCarthy(predecessore(x), predecessore(y))));
	}

	public static boolean minore(int x, int y) {
		return and(minoreUgualeMcCarthy(x, y), not(x == y));
	}

	public static int quozienteMcCarthy(int x, int y) {
		if (minore(x, y))
			return 0;
		return successore(quozienteMcCarthy(differenzaRelativaRicorsiva(x, y), y));
	}
	
	public static int restoMcCarthy(int x, int y) {
		if (minore(x, y))
			return x;
		return restoMcCarthy(differenzaRelativaRicorsiva(x, y), y);
	}
	
	public static boolean divisibileMcCarthy(int x, int y) {
		return or(x == 0, (not(minore(x, y)) && divisibileMcCarthy(differenzaRelativaMcCarthy(x, y), y)));
	}
	
	/*
	8.2.3 e 8.2.4
	Tutti i metodi che sono richiesti sono già stati fatti nell'esercitazione 4 e 7.
	*/
	
	/*
	8.3
	Metodi sequenzaFibonacciRicorsiva e sequenzaFibonacciIterativa
	*/
	public static int sequenzaFibonacciRicorsiva(int x) {
		if (x <= 2)
			return 1;
		return somma(sequenzaFibonacciRicorsiva(predecessore(x)), sequenzaFibonacciRicorsiva(predecessore(predecessore(x))));
	}
	
	public static int sequenzaFibonacciIterativa(int x) {
		if (x <= 2)
			return 1;
		int a = 1;
		int b = 1;
		int c = 1;
		for (int i = 3; i <= x; i++) {
			c = somma(a, b);
			a = b;
			b = c;
		}
		return c;		
	}
}
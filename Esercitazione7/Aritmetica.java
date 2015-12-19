import java.util.Scanner;
import java.util.Arrays;

public class Aritmetica {
	
	public static Scanner in;
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
		/*int x = 8;
		int y = 2;
		for (int i = 0; i < operazioni.length; i++) {
			System.out.println();
			System.out.println(operazioni[i]);
			eseguiOperazione(i, x, y);
		}*/
	}
	
	public static void inizializzaOperazioni() {
		operazioni = new String[37];
		operazioni[0] = "Zero";
		operazioni[0] = "Identit\u00E0";
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
	}
	
	public static void inizializzaOperazioniSoloX() {
		operazioniSoloX = new int[13];
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
		while (operazione < 0 || operazione > 36) {
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
				System.out.println(differenzaAssolutaRelativa(x, y));
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
				if (controllaMultiplo(x, y))
					System.out.println(multiplo(x, y));
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
	
	public static int divisione(int dividendo, int divisore, boolean isQuotient) {
		
		int quoziente = 0;
		int resto = dividendo;
		
		while (resto >= divisore) {
			quoziente = successore(quoziente);
			resto = differenzaRelativa(resto, divisore);
		}
		
		if (isQuotient)
			return quoziente;
		else
			return resto;
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

		int mcd = x;
		int mcd2 = y;
		
		if (mcd == 0 || mcd2 == 0)
			return 0;
		while (mcd != mcd2) {
			while (mcd > mcd2)
				mcd = differenzaRelativa(mcd, mcd2);
			while (mcd < mcd2)
				mcd2 = differenzaRelativa(mcd2, mcd);
		}
		
		return mcd;
	}
	
	public static int mcdAlternativo(int x, int y) {
		
		int mcd = x;
		int resto = y;
		int parcheggio;
		
		if (mcd < resto) {
			parcheggio = mcd;
			mcd = resto;
			resto = parcheggio;
		}
		
		if (resto == 0)
			return 0;
		while (resto != 0) {
			parcheggio = resto;
			resto = divisione(mcd, resto, false);
			mcd = parcheggio;
		}
		
		return mcd;
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
			return 0;
		return 1;
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
	Prececessore "ricorsivo". Ho usato il --x perché facendo x-- sarei andato sempre in loop.
	Volendo si può usare tranquillamente x -= 1, x = x - 1, ecc.
	*/
	public static int predecessoreRicorsivo(int x) {
		if (x == 0)
			return zero(x);
		return identita(x) - 1;
	}
	
	/*
	7.2.2
	Differenza relativa ricorsiva.
	*/
	public static int differenzaRelativaRicorsiva(int x, int y) {
		if (y == 0)
			return x;
		return predecessoreRicorsivo(differenzaRelativaRicorsiva(x, predecessoreRicorsivo(y)));
	}
	
	/*
	7.2.3
	Somma, prodotto e esponenziale ("esponenziazione") ricorsivi
	*/
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
	
	/*
	7.2.4
	Differenza Assoluta Riorsiva. Avevo già fatto lo stesso metodo in qualche esercitazione
	fa usando la minimalizzazione, ma lo rifaccio usando i nuovi metodi appena creati.
	*/
	public static int differenzaAssolutaRelativa(int x, int y) {
		return sommaRicorsiva(differenzaRelativaRicorsiva(x, y), differenzaRelativaRicorsiva(y, x));
	}
	
	/*
	7.3.1
	Metodo controllaQuadratoPerfetto e radiceQuadrataPerfetta. Faccio anche il metodo di 
	controllo per rendere anche la semplice radice quadrata una funzione totale.
	*/
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
	
	/*
	7.3.2 (ci sono due 7.3.4 ma manca il 7.3.2)
	Metodo parteInteraRadiceQuadrata
	*/
	public static int parteInteraRadiceQuadrata(int x) {
			int y = 0;
			while (differenzaRelativaRicorsiva(x, predecessoreRicorsivo(prodottoRicorsivo(successore(y), successore(y)))) != 0)
				y = successore(y);
			return y;
	}
	
	/*
	7.3.3
	Metodo controllaMultiplo e multiplo. Ho indrodotto una seconda variabile in input in modo
	da generalizzare il multiplo, che quindi non deve essere per forza 33. 
	*/
	public static boolean controllaMultiplo(int x, int y) {
		int z = 1;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, z)) != 0)
			z = successore(z);
		if (x == prodottoRicorsivo(y, z))
			return true;
		return false;
	}
	
	public static int multiplo(int x, int y) {
		int z = 1;
		while (differenzaRelativaRicorsiva(x, prodottoRicorsivo(y, z)) != 0)
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
		while (differenzaRelativaRicorsiva(successore(x), esponenzialeRicorsivo(y, z + 1)) != 0)
			z = successore(z);
		return z;
	}
}
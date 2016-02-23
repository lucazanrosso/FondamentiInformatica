/*
I commenti che ho scritto per le esercitazioni precedenti valgono per questa e per le future 
esercitazioni, ma non li riporto ogni volta perché altrimenti risulterebbe troppo confusionario.
Anche se mi piacerebbe molto farlo, nelle esercitazioni non usero mai direttamente gli operatori (+, -, *, ecc),
ma chiamerò sempre i rispettivi metodi contruiti da noi (somma, differenza, prodotto, ecc).
*/

import java.util.Scanner;

public class Aritmetica {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		// Ho sfoltito parecchio il metodo main, che ora contiene solo gli input ricevuti e lo switch dell'operazione.

		System.out.println("Scrivi il primo operando che deve essere un numero positivo, quindi premi INVIO");
		System.out.println("Scrivi poi il simbolo dell'operazione matematica che vuoi fare (+, -, *, /, %, ^, mcd, mcd2, q, reveng, e2), quindi premi INVIO");
		System.out.println("Infine, scrivi, se necessario, il secondo operando che deve essere un numero positivo (e diverso da 0 nel caso della divisione), quindi premi INVIO");
		
		int operando1 = in.nextInt();
		// Viene controllato se il numero è negativo. Il metodo si trova subito dopo il main.
		operando1 = controllaNegativo(operando1);
		
		String operatore = in.next();
		// Viene controllato se l'operatore è corretto. Il metodo si trova subito dopo a controllaNegativo.
		operatore = controllaOperatore(operatore);
		
		int operando2 = 0;
		// Se l'operatore è il quadrato allora non serve inserire il secondo operando.
		if (! operatore.equals("q")) {
			operando2 = in.nextInt();
			operando2 = controllaNegativo(operando2);
		}
		
		switch(operatore) {
			case "+":
				System.out.println(somma(operando1, operando2));
				break;
			case "-":
				System.out.println(differenza(operando1, operando2));
				break;
			case "*":
				System.out.println(prodotto(operando1, operando2));
				break;
			case "/":
				if (operando2 == 0)
					System.out.println("Impossibile dividere per 0");
				else
					System.out.println(divisione(operando1, operando2, true));
				break;
			case "%":
				if (operando2 == 0)
					System.out.println("Impossibile dividere per 0");
				else
				System.out.println(divisione(operando1, operando2, false));
				break;
			case "^":
				if (operando1 == 0 && operando2 == 0)
					System.out.println("Impossibile elevare 0 alla 0");
				else
				System.out.println(potenza(operando1, operando2));
				break;
			case "mcd":
				System.out.println(mcd(operando1, operando2));
				break;
			case "mcd2":
				System.out.println(mcdAlternativo(operando1, operando2));
				break;
			case "q":
				System.out.println(quadrato(operando1));
				break;
			case "reveng":
				System.out.println(reverseEngineering(operando1, operando2));
				break;
			case "e2":
				if (operando1 == 0 && operando2 == 0)
					System.out.println("Impossibile elevare 0 alla 0");
				else
				System.out.println(potenzaAlternativa(operando1, operando2));
				break;
		}
		
		// Test
		/*
		int x = 10;
		int y = 4;
		System.out.println(somma(x, y));
		System.out.println(differenza(x, y));
		System.out.println(prodotto(x, y));
		System.out.println(divisione(x, y, true));
		System.out.println(divisione(x, y, false));
		System.out.println(potenza(x, y));
		System.out.println(mcd(x, y));
		System.out.println(mcdAlternativo(x, y));
		System.out.println(quadrato(x));
		System.out.println(reverseEngineering(x, y));	
		System.out.println(potenzaAlternativa(x, y));			
		*/
		
	}
	
	/*
	Questo metodo e il successivo sono i due metodi che sostitiuscono tutti i controlli fatti
	nello scorso esercizio nel metodo main. Il primo controlla se il numero è negativo, 
	il secondo se l'operatore è compreso tra quelli disponibili. I metodi però non si limitano solo 
	a dei controlli: infatti se il numero o l'operatore inserito è sbagliato ci verrà chiesto di inserirne
	uno di corretto, e il numero o l'operatore corretto sarà ritornato e sovrascriverà quello sbagliato.
	Non è niente di nuovo rispetto ai controlli fatti nella prima esercitazione, solo che adesso
	sono divisi dal metodo main per rendere tutto più corretto e leggibile.
	*/
	public static int controllaNegativo(int numero) {
		
		while (numero < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			numero = in.nextInt();
		}
		
		return numero;
	}
	
	public static String controllaOperatore(String operatore) {
		while (! (operatore.equals("+") ||
					 operatore.equals("-") ||
					 operatore.equals("*") ||
					 operatore.equals("/") ||
					 operatore.equals("%") ||
					 operatore.equals("^") ||
					 operatore.equals("mcd") ||
					 operatore.equals("mcd2") ||
					 operatore.equals("q") ||
					 operatore.equals("reveng") ||
					 operatore.equals("e2"))) {
			System.out.println("Hai inserito un operatore sbagliato, gli operatori sono +, -, *, /, %, ^, mcd, mcd2, q, reveng, e2");
			operatore = in.next();
		}
		return operatore;
	}
	
	// Ho creato un nuovo metodo successore che andrà a sostituire tutti i "nomeVaribile++"
	public static int successore(int numero) {
		
		int successore = numero;
		successore++;
		
		return successore;
	}
	
	public static int predecessore(int numero) {
		
		int controller = 0;
		int predecessore = controller;
		
		while (numero != controller) {
			predecessore = controller;
			controller = successore(controller);
		}
		
		return predecessore;
	}
	
	public static int somma(int addendo1, int addendo2) {
		
		int somma = addendo1;
		
		while (addendo2 != 0) {
			somma = successore(somma);
			addendo2 = predecessore(addendo2);
		}
		
		return somma;
	}
	
	public static int differenza(int minuendo, int sottraendo) {

		int differenza = minuendo;
		
		while (sottraendo != 0) {
			differenza = predecessore(differenza);
			sottraendo = predecessore(sottraendo);
		}
		
		return differenza;
	}
	
	public static int prodotto(int moltiplicando, int moltiplicatore) {

		int prodotto = 0;
		
		while (moltiplicatore != 0) {
			prodotto = somma(prodotto, moltiplicando);
			moltiplicatore = predecessore(moltiplicatore);
		}
		
		return prodotto;
	}
	
	/*
	Ricordo che il terzo parametro viene usato a seconda se come risultato voglio il 
	quoziente o il resto: true per il quoziente, false per il resto.
	*/
	public static int divisione(int dividendo, int divisore, boolean isQuotient) {
		
		int quoziente = 0;
		int resto = dividendo;
		
		while (resto >= divisore) {
			quoziente = successore(quoziente);
			resto = differenza(resto, divisore);
		}
		
		if (isQuotient)
			return quoziente;
		else
			return resto;
	}
	
	/*
	2.4
	POTENZA
	*/
	public static int potenza(int base, int esponente) {
		
		int potenza = base;
		
		if (esponente == 0)
			return 1;
		while (esponente != 1) {
			potenza = prodotto(potenza, base);
			esponente = predecessore(esponente);
		}
		
		return potenza;
	}
	
	/*
	2.1
	MCD
	L'unica cosa diversa rispetto al while program fatto dal professore è che ho usato
	3 cicli while al posto di 1 ciclo do-while e 2 cicli while. Il motivo è semplice:
	non ha senso testare alla fine se "a" è diverso da "b", perché se "a" dovessere essere uguale
	a "b" bisogna entrare nel do-while, controllare se "a" > "b" (falso), quindi controllare
	"a" < "b" (falso), e solo alla fine controllare se "a" diverso da "b" (falso). Tanto vale
	testare subito con un normale while "a" diverso da "b".
	*/
	public static int mcd(int numeroA, int numeroB) {

		int mcd = numeroA;
		int mcd2 = numeroB;
		
		if (mcd == 0 || mcd2 == 0)
			return 0;
		while (mcd != mcd2) {
			while (mcd > mcd2)
				mcd = differenza(mcd, mcd2);
			while (mcd < mcd2)
				mcd2 = differenza(mcd2, mcd);
		}
		
		return mcd;
	}
	
	/*
	Un MCD alternativo rispetto al while program fatto dal professore. Segue lo stesso 
	ragionamento che aveva fatto il professore con la divisione e il resto. 
	Questo algoritmo è più performante rispetto al primo.
	*/
	public static int mcdAlternativo(int numeroA, int numeroB) {
		
		int mcd = numeroA;
		int resto = numeroB;
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
	
	/*
	2.2
	QUADRATO
	*/
	public static int quadrato(int numero) {
		
		int controller = 0;
		int quadrato = 0;
		
		while (numero != controller) {
			/*
			Questa è una concatenazione di un metodo che ne chiama un'altro che ne chiama
			un'altro ancora. Non è niente di difficile, basta seguire le operazioni con ordine, partendo da quella 
			più interna, cioè il prodotto: svolgo il prodotto tra "controller" e 2, il risultato lo sommo a 1,
			e il nuovo risultato lo sommo nuovamente a "quadrato". In pratica è come scrivere "quadrato + controller * 2 + 1".
			*/
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
	public static int potenzaAlternativa(int base, int esponente) {

		int potenza = 1;
		
		while (esponente != 0) {
			/*
			Questo è il test che viene fatto per vedere se un numero è pari o dispari. Non ho
			usato il sistema fatto dal professore (pongo n1 = n div 2, e se n = (n1 * 2) + 1 allora
			n è dispari altrimenti è pari), perché il mio ragionamento è più semplice e di fatto nella
			programmazione viene sempre usato questo per determinare se un numero è pari o dispari: basta 
			testare se il resto di un numero diviso per 2 è 0 o 1. Se il resto è 0 allora è pari, se il
			resto è 1 allora è dispari.
			*/
			if (divisione(esponente, 2, false) == 1)
				potenza = prodotto(potenza, base);
			base = quadrato(base);
			esponente = divisione(esponente, 2, true);
		}
		
		return potenza;
	}
}
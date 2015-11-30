import java.util.Scanner;

public class Aritmetica {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.println("Scrivi il simbolo dell'operazione matematica che vuoi fare (+, -, *, /, %, ^, mcd, mcd2, q, reveng, e2, sg, sg*, absd, max, min), quindi premi INVIO");
		System.out.println("Scrivi poi il primo operando che deve essere un numero positivo, quindi premi INVIO");
		System.out.println("Infine, scrivi, se necessario, il secondo operando che deve essere un numero positivo (e diverso da 0 nel caso della divisione), quindi premi INVIO");
		
		String operatore = in.next();
		operatore = controllaOperatore(operatore);
		
		int operando1 = in.nextInt();
		operando1 = controllaNegativo(operando1);
		
		int operando2 = 0;
		if (! (operatore.equals("q") ||
				operatore.equals("sg") ||
				operatore.equals("sg*") ||
				operatore.equals("exp"))) {
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
			case "sg":
				System.out.println(segnatura(operando1));
				break;
			case "sg*":
				System.out.println(controSegnatura(operando1));
				break;
			case "absd":
				System.out.println(valoreAssolutoDifferenza(operando1, operando2));
				break;
			case "max":
				System.out.println(massimo(operando1, operando2));
				break;
			case "min":
				System.out.println(minimo(operando1, operando2));
				break;
			case "exp":
				System.out.println(exp(operando1));
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
					 operatore.equals("e2") ||
					 operatore.equals("sg") ||
					 operatore.equals("sg*") ||
					 operatore.equals("absd") ||
					 operatore.equals("eq") ||
					 operatore.equals("max") ||
					 operatore.equals("min") ||
					 operatore.equals("exp"))) {
			System.out.println("Hai inserito un operatore sbagliato, gli operatori sono +, -, *, /, %, ^, mcd, mcd2, q, reveng, e2");
			operatore = in.next();
		}
		return operatore;
	}
	
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
	
	public static int quadrato(int numero) {
		
		int controller = 0;
		int quadrato = 0;
		
		while (numero != controller) {
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

	public static int potenzaAlternativa(int base, int esponente) {

		int potenza = 1;
		
		while (esponente != 0) {

			if (divisione(esponente, 2, false) == 1)
				potenza = prodotto(potenza, base);
			base = quadrato(base);
			esponente = divisione(esponente, 2, true);
		}
		
		return potenza;
	}
	
	public static int segnatura(int x) {
		if (x == 0)
			return 0;
		return 1;
	}
	
	public static int controSegnatura(int x) {
		return differenza(1, segnatura(x));
	}
	
	public static int valoreAssolutoDifferenza(int x, int y) {
		return differenza(x, y) + differenza(y, x);
	}
	
	public static int equals(int x, int y) {
		return controSegnatura(valoreAssolutoDifferenza(x, y));
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
		return segnatura(differenza(x, y));
	}
	
	public static int massimo(int x, int y) {
		return somma(x, differenza(y, x));
	}
	
	public static int minimo(int x, int y) {
		return differenza(x, differenza(x, y));
	}
	
	//6.10
	public static int exp(int x) {
		int t = 1;
		int j = 0;
		int s = t;
		while (t > 0.0001) {
			j = successore(j);
			t = prodotto(t, divisione(x, j, true));
			s = somma(s, t);
		}
		return s;
	}
}
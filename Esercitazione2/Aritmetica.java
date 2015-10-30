import java.util.Scanner;

public class Aritmetica {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args) {

		System.out.println("Scrivi il primo operando che deve essere un numero positivo, quindi premi INVIO");
		System.out.println("Scrivi poi il simbolo dell'operazione matematica che vuoi fare (+, -, *, /, %, ^), quindi premi INVIO");
		System.out.println("Scrivi, infine, il secondo operando che deve essere un numero positivo (e diverso da 0 nel caso della divisione), quindi premi INVIO");
		
		int operando1 = in.nextInt();

		while(operando1 < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			operando1 = in.nextInt();
		}
		
		String operatore = in.next();
		String validOperators = "+-*/%^";

		while(! validOperators.contains(operatore) || operatore.length() != 1) {
			System.out.println("Hai inserito un operatore sbagliato. Gli operatori sono +, -, *, /, %, ^");
			operatore = in.next();
		}
		
		int operando2 = in.nextInt();
		while(operando2 < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			operando2 = in.nextInt();
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
				System.out.println(divisione(operando1, operando2, true));
				break;
			case "%":
				System.out.println(divisione(operando1, operando2, false));
				break;
			case "^":
				System.out.println(potenza(operando1, operando2));
				break;
		}
		
		// Test
		/*int x = 9;
		int y = 4;
		System.out.println(somma(x, y));
		System.out.println(differenza(x, y));
		System.out.println(prodotto(x, y));
		System.out.println(divisione(x, y, true));
		System.out.println(divisione(x, y, false));
		System.out.println(potenza(x, y));*/
		
	}
	
	public static int predecessore(int numero) {
		int controller = 0;
		int predecessore = controller;
		while(numero != controller) {
			predecessore = controller;
			controller++;
		}
		return predecessore;
	}
	
	public static int somma(int addendo1, int addendo2) {
		int somma = addendo1;
		while(addendo2 != 0) {
			somma++;
			addendo2 = predecessore(addendo2);
		}
		return somma;
	}
	
	public static int differenza(int minuendo, int sottraendo) {
		int differenza = minuendo;
		while(sottraendo != 0) {
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
		while (divisore <= 0) {
			if (divisore == 0) {
				System.out.println("Hai inserito un divisore uguale a zero, inserisci un divisore positivo e diverso da zero");
				divisore = in.nextInt();
			} else {
				System.out.println("Hai inserito un divisore negativo, inserisci un divisore positivo e diverso da zero");
				divisore = in.nextInt();
			}
		}
		int quoziente = 0;
		int resto = dividendo;
		while (resto >= divisore) {
			quoziente++;
			resto = differenza(resto, divisore);
		}
		if (isQuotient)
			return quoziente;
		else
			return resto;
	}
	
	public static int potenza(int base, int esponente) {
		if (base == 0 && esponente == 0) {
			while (esponente <= 0) {
			if (esponente == 0) {
				System.out.println("Hai inserito un esponente uguale a zero con una base uguale a 0, inserisci un esponente positivo e diverso da zero");
				esponente = in.nextInt();
			} else {
				System.out.println("Hai inserito un esponente negativo, inserisci un esponente positivo e diverso da zero");
				esponente = in.nextInt();
			}
		}
		}
		int potenza = base;
		if (esponente == 0)
			return 1;
		while(esponente != 1) {
			potenza = prodotto(potenza, base);
			esponente = predecessore(esponente);
		}
		return potenza;
	}
}
import java.util.Scanner;

public class Esponenziale {
	
	/*
	6.1.1
	Ho separato il metodo exp dalla classe Aritmetica per un motivo fondamentale:
	per ottenere un risultato approssimato ma comunque molto vicino al vero risultato
	bisogna utilizzare numeri double anziché int, e utilizzare gli operatori +,* e / al
	posto dei metodi somma, prodotto e divisione, proprio perché questi metodi restituiscono
	numeri int.
	*/	
	public static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("Scrivi il grado dell'esponenziale");	
		double x = in.nextDouble();
		System.out.println("Risultato dell'esponenziale: " + exp(x));			
	}

	public static double exp(double x) {
		double t = 1;
		int j = 0;
		double s = t;
		while (t > 0.0001) {
			j++;
			t = t * x / j;
			s += t;
		}
		return s;
	}
}

/*
OUTPUT

Scrivi il grado dell'esponenziale
5
Risultato dell'esponenziale: 148.41314706738177
*/
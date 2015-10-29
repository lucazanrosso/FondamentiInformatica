import java.util.Scanner;

// È buona cosa mettere le parentesi graffe aperte a destra del nome della classe come in basso.
// La stessa cosa vale per i metodi e statement vari
public class Aritmetica {
	
	/*
	Ho dichiarato la variabile d'istanza "in" fuori dai metodi. Questo è utile quando voglio usare la
	stessa variabile in diversi metodi senza doverla ricostruire ogni volta. Se dichiariamo la variabile 
	"in" all'interno del metodo "main", come ha fatto il professore, questa potrà essere usata solo dal
	metodo main. Così, invece, la variabile "in" può essere usata da qualsiasi metodo. L'unica pecca è che
	bisogna dichiarare la variabile static, perché altrimenti non può essere usata da metodi statici.
	*/
	public static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args) {
		/*
		Ho modificato leggermente il metodo "main" rispetto a quanto scritto nell'esercitazione per un motivo 
		fondamentale. Il professore non ha ancora spiegato cosa solo le eccezioni, ma a noi basta sapere che 
		quando si lancia un'eccezione il programma si blocca e non si può più intervenire in alcun modo a meno 
		che non si riavvii il programma. Dal momento che una persona può sbagliare a digitare un numero
		negativo non ha senso bloccare l'intero programma. Bisogna invece mandare un messaggio che invita a 
		reinserire un numero corretto.
		Ho deciso poi di migliorare il programma introducendo l'operatore, per fare in modo che possiamo 
		decidere noi stessi quando il programma è in esecuzione se fare un'addizione (+), una differenza (-), 
		un prodotto (*), un quoziente (/), un resto (%) o una potenza (^). In questo caso viene usato uno switch 
		statement, che altro non è che una concatenazione di if statement, per controllare che operazione 
		abbiamo scelto. Questo programma segue la stessa logica che ha una normale calcolatrive. 
		L'unico presupposto è che si inseriscano dei numeri (anche negativi) come operandi. Se viene inserito 
		qualsiasi altro tipo di carattere al posto di un numero il programma lancerà automaticamente 
		un'eccezione.
		*/
		System.out.println("Scrivi il primo operando che deve essere un numero positivo, quindi premi INVIO");
		System.out.println("Scrivi poi il simbolo dell'operazione matematica che vuoi fare (+, -, *, /, %, ^), quindi premi INVIO");
		System.out.println("Scrivi, infine, il secondo operando che deve essere un numero positivo (e diverso da 0 nel caso della divisione), quindi premi INVIO");
		
		int operando1 = in.nextInt();
		/*
		Se inseriamo un numero negativo un ciclo continuerà a chiederci di inserire un numero positivo.
		Ho deciso di fare qui un controllo generale perché risultava più lungo e ripetitivo fare il controllo
		all'iterno di ogni metodo. L'unico controllo aggiuntivo è presente per il divisore all'interno del
		metodo divisione perché deve essere, oltre che positivo, anche diverso da 0.
		*/
		while(operando1 < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			operando1 = in.nextInt();
		}
		
		String operatore = in.next();
		String validOperators = "+-*/%^";
		/*
		Questo è probabilmente il controllo più difficile da capire. Ho inizializzato una variabile
		"validOperators" che è una stringa contenente i sei operatori matematici fatti fino a questo momento.
		Nel while sottostante controllo per PRIMO se l'operatore che ho inserito non è tra quelli disponibili,
		e per SECONDO controllo se l'operatore ha più di un carattere. Il secondo controllo viene fatto
		perché la classe Scanner non permette di prendere in input tipi char (che sono dei singoli caratteri),
		ma devo per forza prendere in input una stringa, che può invece essere composta da molti caratteri.
		Perciò, se io scrivo come operatore matematico "+-*" e non faccio il secondo controllo, il primo 
		risulterà vero perchè effettivamente la stringa "validOperator" contiene in sequenza i caratteri "+-*",
		quindi non potrò entrare all'interno del ciclo e non otterrò errori. Di fatto questo controllo dice: 
		"se operatore non è contenuto in validOperators o operatore non ha lunghezza 1, allora entra nel ciclo".
		Un'alternativa a questo controllo è quest'altro controllo, più lungo da scrivere ma più semplice da 
		capire: 
		"while(operatore != "+" && operatore != "-" && operatore != "*" && operatore != "/" && operatore != "%" && operatore != "^")"
		La scelta di non inserire il controllo appena scritto sopra è dovuta dal fatto che se devo inserire una
		nuova operazione mi basta inserire il carattere dentro la stringa "validOperators", che è quindi più 
		corretto e si risparmia anche tempo.
		*/
		while(! validOperators.contains(operatore) || operatore.length() != 1) {
			System.out.println("Hai inserito un operatore sbagliato. Gli operatori sono +, -, *, /, %, ^");
			operatore = in.next();
		}
		
		int operando2 = in.nextInt();
		while(operando2 < 0) {
			System.out.println("Hai inserito un numero negativo, inserisci un numero positivo");
			operando2 = in.nextInt();
		}	
		
		/*
		Questo è uno switch statement e funziona con la stessa logica dell'if statement, solo che in 
		determinati casi, come questo, è più pratico usare lo switch. In poche parole questo controllo dice:
		"se operatore = +, allora esegui somma, se operatore = -, allora esegui differenza, ecc.". Il break
		serve semplicemente per dire "se hai trovato il mio caso, fermati e non andare oltre perché tanto
		non serve". In java gli statement sono 6: if, switch, while, do while, for e for migliorato (foreach).
		*/
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
				// Spiego nel metodo divisione perché ho inserito un valore booleano come terzo parametro
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
			// L'istruzione controller++ corrisponde a fare controller = controller + 1
			controller++;
		}
		return predecessore;
	}
	
	/*
	Per tutti i metodi ho deciso di non assegnare i parametri ad altre variabili locali come fatto in aula 
	(ad esempio int s = x;), perché è una cosa inutile che non si usa nella programmazione. 
	Avrebbe senso assegnare i valori ad altre variabili solo se il nome della variabile rispetta il contenuto.
	Nell'esempio, la variabile "s" non mi da nessuna indicazione sul contenuto,
	quindi tanto vale lasciare la "x". Sarebbe logicamente diverso scrivere "somma" al posto di "s"
	perché così con un colpo d'occhio capisco che la variabile somma conterrà la somma dei due addendi.
	Ho perciò adottato questo ultimo ragionamento.
	*/
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
		/*
		Il professore qui aveva creato una variabile "t" in più, inizializzata a 0, che
		veniva incrementata di 1 ad ogni ripetizione del ciclo fino a quando non fosse stata
		uguale a "sottraendo". Si vede facilmente che "t" si può anche non usare perché basta decrementare
		"sottraendo" fino a quando non è uguale a 0 (stessa logica dell'addizione).
		*/
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
	
	/*
	Il metodo divisione è un metodo delicato, primo perché non si possono fare divisioni per 0, e quindi
	bisogna fare un controllo aggiuntivo, e secondo perché i risultati della divisione sono due,
	quoziente e resto. il terzo parametro booleano "isQuotient" serve proprio per questo, cioé per scegliere se come
	risultato voglio il quoziente o il resto. Non ha senso scrivere due metodi identici con solo il return
	di diverso. Ha senso piuttosto fare un controllo, dove, se voglio il quoziente mi restituisce il
	quoziente, mentre se voglio il resto mi restituisce il resto. Tutto questo viene fatto senza il nostro
	consenso. Se noi infatti abbiamo digitato "/" come operatore, la variabile "isQuotient" sarà impostata
	automaticamente a true e il metodo ritornerà il quoziente, mentre se abbiamo digitato "%", "isQuotient"
	sarà falso e quindi il valore restituiro sarà il resto.
	*/
	public static int divisione(int dividendo, int divisore, boolean isQuotient) {
		// Ho creato qui il controllo della divisione per 0 perché se veniva fatto nel metodo main dava un problema
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
	
	public static int potenza(int radice, int esponente) {
		int potenza = radice;
		if (esponente == 0)
			return 1;
		while(esponente != 1) {
			potenza = prodotto(potenza, radice);
			esponente = predecessore(esponente);
		}
		return potenza;
	}
}
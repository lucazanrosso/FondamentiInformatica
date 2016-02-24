public class Stringa {
	
	/*
	9.1.1
	Dichiaro l'array di caratteri che conterrà la stringa.
	Nei due costruttori inizializzo l'array, a seconda che vengano o meno passati dei
	caratteri come parametri. 
	Faccio un appunto importante sul parametro del secondo costruttore: non mi sembra ci sia
	indicata questa soluzione nelle slide caricate insieme all'esercitazione, ma Java offre
	un potente strumento (che si chiama varargs) per l'inserimento di una quantità variabile 
	di parametri, purché siano dello stesso tipo (char in questo caso). Come si può notare 
	dalla classe di test, utilizzando questo metodo non occorre istanziare un array e poi 
	passarlo al costruttore come parametro, ma basta passare direttamente dei char. 
	Questi char verranno poi trasformati direttamente in un array di char.
	Dopo i costruttori ho scritto i soliti metodi set e get.
	*/
	private char[] stringa;
	
	public Stringa() {}
	
	public Stringa(char... chars) {
		this.stringa = chars;
	}
	
	public void set(char... chars) {
		this.stringa = chars;
	}
	
	private char[] get() {
		return this.stringa;
	}
	
	/*
	9.1.2
	Metodo length
	*/
	public int length() {
		return this.stringa.length;
	}
	
	/*
	9.1.3
	Metodo equals (Override del metodo equals della classe Object)
	*/
	public boolean equals(Object o) {
		Stringa s2 = (Stringa) o;
		char[] stringa2 = s2.get();
		if (this.stringa.length != stringa2.length)
			return false;
		/*if (this.stringa.length < stringa2.length)
			length = this.stringa.length;
		else
			length = stringa2.length;*/
		for (int i = 0; i < this.stringa.length; i++) {
			if (this.stringa[i] != stringa2[i])
				return false;
		}
		return true;
	}
	
	/*
	9.1.4
	Metodo contains
	Ho voluto personalizzare questo metodo per renderlo identico (come funzionalità) al
	metodo contains della classe String. Questo metodo, oltre alla semplice ricerca di un
	carattere dentro alla stringa, permette anche la ricerca di più caratteri.
	*/
	public boolean contains(char... chars) {
		boolean contains = false;
		for (int i = 0; i < this.stringa.length - chars.length + 1; i++) {
			if (this.stringa[i] == chars[0]) {
				contains = true;
				for (int j = 1; j < chars.length; j++) {
					if (this.stringa[i + j] != chars[j])
						contains = false;
				}
			}
		}
		return contains;
	}
	
	/*
	9.1.5
	Metodo substring
	Dal momento che non posso passare al costruttore un array di char (java consente di usare
	o "char... chars" o "char[] chars", ma non tutti e due insieme) devo istanziare
	un oggetto Stringa con nessun parametro e modificare direttamente la variabile stringa.
	*/
	public Stringa substring(int start, int end) {
		Stringa s2 = new Stringa();
		s2.stringa = new char[end - start];
		for (int i = start; i < end; i++) {
			s2.stringa[i - start] = this.stringa[i];
		}
		return s2;
	}
	
	/*
	9.1.6
	Metodo contains
	Questo è un overload del metodo contains fatto nel punto 9.1.4. È possibile quindi
	verificare sia se una stringa contiene dei char, sia se una stinga contiene
	unl'altra stringa.
	*/
	public boolean contains(Stringa s2) {
		boolean contains = false;
		for (int i = 0; i < this.stringa.length - s2.stringa.length + 1; i++) {
			if (this.stringa[i] == s2.stringa[0]) {
				contains = true;
				for (int j = 1; j < s2.stringa.length; j++) {
					if (this.stringa[i + j] != s2.stringa[j])
						contains = false;
				}
			}
		}
		return contains;
	}
	
	/*
	9.1.7
	Metodo substring
	Anche questo è un overload del metodo fatto nel punto 9.1.5. In questo caso vengono
	passati in input due char. Nel testo dell'esercitazione non è specificato bene,
	però penso che il professore intenda che bisogna restituire una substring dal primo char
	passato come parametro (se c'è) fino al secondo char passato come parametro (il primo
	che si trova, se c'è), incluso il primo, escluso il secondo (proprio come nel metodo
	substring).
	Se si inseriscono dei char che non ci sono, oppure se non viene trovata nessuna substring 
	tra i due char verrà restituito un valore null;
	*/
	public Stringa substring(char start, char end) {
		for (int i = 0; i < stringa.length; i++) {
			if (this.stringa[i] == start) {				
				int startInt = i;
				int j;
				for (j = i + 1; j < stringa.length; j++) {				
					if (this.stringa[j] == end) {
						int endInt = j;
						return substring(startInt, endInt);
					}
				}
				i = j;
			}
		}
		return null;
	}
	
	/*
	9.1.8
	Metodo invert
	*/
	public Stringa invert() {
    Stringa s2 = new Stringa();
		s2.stringa = new char[this.stringa.length];
		for (int i = 0; i < (this.stringa.length / 2); i++) {
      s2.stringa[i] = this.stringa[this.stringa.length - 1 - i];
      s2.stringa[this.stringa.length - 1 - i] = this.stringa[i];
    }
		return s2;
  }
	
	/*
	9.1.9
	Metodo concat (Usando oggetti String equivale a fare stringa1 + stringa2)
	*/
	public Stringa concat(Stringa s2) {
    Stringa s3 = new Stringa();
		s3.stringa = new char[this.stringa.length + s2.stringa.length];
		int i;
		for (i = 0; i < this.stringa.length; i++)
			s3.stringa[i] = this.stringa[i];
		for (int j = 0; j < s2.stringa.length; j++)
			s3.stringa[j + i] = s2.stringa[j];
		return s3;
  }
	
	/*
	9.1.10
	Metodo compareTo e forcing
	In realtà il metodo compareTo della classe String è un po' più complesso rispetto a come
	viene presentato nell'esercitazione. Prima di tutto il metodo compareTo confronta una
	stringa con un'altra stringa, e più precisamente confronta il char nella posizione i della
	prima stringa con il char nella posizione i della seconda stringa, con i < della lunghezza
	della stringa più corta (altrimenti java lancerebbe una ArrayIndexOutOfBoundsException)
	e restituisce un'intero. 
	Questo int assume diversi valori a seconda della condizione che si verifica. Se, durante
	il confronto, un char è diverso rispetto all'altro char, bisogna restituire la differenza
	(che avviene automaticamente, dal momento che i char si possono considerare come interi).
	Se i char confrontati sono tutti uguali, bisogna restituire la differenza di lunghezza
	tra una stringa e l'altra. Se le lunghezze sono uguali, vuol dire che anche le stringhe
	sono uguali, perciò si restituisce 0.
	Di fatto qui ho ricostruito il metodo compareTo della classe String e usato il cosiddetto
	"forcing" nello stesso metodo, perciò non ho creato due metodi.
	Preciso  e ripeto che anche se non si vede il cast (int), questo avviene in maniera 
	automanica perché i char possono essere considerati come degli int. infatti se si hanno
	char a = 'a';
	char b = 'b';
	e si prova a sommarli, non si ottiene 'ab', ma 195.
	*/
	public int compareTo(Stringa s2) {
		int length;
		if (this.stringa.length <= s2.stringa.length)
			length = this.stringa.length;
		else
			length = s2.stringa.length;
		for (int i = 0; i < length; i++) {
			if (this.stringa[i] != s2.stringa[i])
				return this.stringa[i] - s2.stringa[i];			
		}
		if (this.stringa.length != s2.stringa.length)
				return this.stringa.length - s2.stringa.length;	
		return 0;
	}
	
	// Metodo toString che serve per stampare gli elementi come se fossero parole.
	@Override
	public String toString() {	
		if (stringa == null)
			return null;
		String s = "";
		for (char c : this.stringa) {
			s += c;
		}
		return s;
	}
}
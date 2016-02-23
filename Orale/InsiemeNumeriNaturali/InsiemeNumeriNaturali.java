public class InsiemeNumeriNaturali {
	
	private boolean[] insieme;
	
	public InsiemeNumeriNaturali() {
		this.insieme = new boolean[0];
	}
	
	public InsiemeNumeriNaturali(int dimensione) {
		this.insieme = new boolean[dimensione];
	}
	
	public boolean[] get() {
		return this.insieme;
	}
	
	public void set(boolean[] insieme) {
		this.insieme = insieme;
	}
	
	/*
	8.4.1
	Operazioni di base.
	*/	
	public int inserisci(int numero) {
		this.insieme[numero] = true;
		return numero;
	}
	
	public int cancella(int numero) {
		this.insieme[numero] = false;
		return numero;
	}
	
	public boolean controllaVuoto() {
		for (boolean posizione : this.insieme) {
			if (posizione)
				return false;
		}
		return true;
	}
	
	public boolean appartiene(int numero) {
		return this.insieme[numero];
	}
	
	/*
	8.4.2
	Metodi unione, intersezione e complemento.
	Ho deciso di fare i metodi statici, così, se voglio ad esempio unire due insiemi, 
	non modifico permanentemente i due insiemi dati in input, ma prendo solamente i loro valori 
	e ne creo un terzo (che corrisponderà all'unione dei due).
	I metodi inoltre sono complicati perché ho previsto l'uso di insiemi di dimensioni diverse.
	Se tutti gli insiemi fossero creati con la stessa dimensione allora i metodi si potrebbero
	semplificare, ma, nel caso di insiemi di dimensioni diverse, i metodi semplificati
	porterebbero ad un ArrayOutOfBoudsException. In ogni caso in basso si trovano anche i
	metodi semplici commentati che prevedono insiemi della stessa dimensione.
	NOTA PERSONALE
	L'uso del metodo set all'interno del metodo statico unione non funziona, perché gli array 
	sono oggetti. Se viene usato, infatti, anche l'oggetto con lunghezza di array maggiore tra i 
	due oggetti passati in input assumerà gli stessi valori dell'array dell'oggetto insiemeUnione.
	Bisogna quindi fare due cicli.
	*/
	public static InsiemeNumeriNaturali unione(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		int length;
		if (insieme2.length > insieme1.length)
			length = insieme2.length;
		else
			length = insieme1.length;
		InsiemeNumeriNaturali insiemeUnione = new InsiemeNumeriNaturali(length);		
		//insiemeUnione.set(insieme1);
		for (int i = 0; i < insieme1.length; i++)
			if (insieme1[i])
				insiemeUnione.inserisci(i);
		for (int i = 0; i < insieme2.length; i++)
			if (insieme2[i])
				insiemeUnione.inserisci(i);
		return insiemeUnione;
	}
	
	public static InsiemeNumeriNaturali intersezione(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		int length;
		if (insieme2.length < insieme1.length)
			length = insieme2.length;
		else
			length = insieme1.length;
		InsiemeNumeriNaturali insiemeIntersezione = new InsiemeNumeriNaturali(length);
		for (int i = 0; i < length; i++)
			if (insieme1[i] && insieme2[i])
				insiemeIntersezione.inserisci(i);
		return insiemeIntersezione;
	}
	
	public static InsiemeNumeriNaturali complemento(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		int length;
		if (insieme2.length < insieme1.length)
			length = insieme2.length;
		else
			length = insieme1.length;
		InsiemeNumeriNaturali insiemeComplemento = new InsiemeNumeriNaturali(insieme2.length);
		for (int i = 0; i < insieme2.length; i++)
			if (insieme2[i])
				insiemeComplemento.inserisci(i);
		for (int i = 0; i < length; i++)
			if (insieme1[i])
				insiemeComplemento.cancella(i);
		return insiemeComplemento;
	}
	
	/*
	public static InsiemeNumeriNaturali unione(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		InsiemeNumeriNaturali insiemeUnione = new InsiemeNumeriNaturali(insieme1.length);		
		for (int i = 0; i < insieme1.length; i++)
			if (insieme1[i] || insieme2[i])
				insiemeUnione.inserisci(i);
		return insiemeUnione;
	}
	
	public static InsiemeNumeriNaturali intersezione(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		InsiemeNumeriNaturali insiemeIntersezione = new InsiemeNumeriNaturali(insieme1.length);
		for (int i = 0; i < insieme1.length; i++)
			if (insieme1[i] && insieme2[i])
				insiemeIntersezione.inserisci(i);
		return insiemeIntersezione;
	}
	
	public static InsiemeNumeriNaturali complemento(InsiemeNumeriNaturali i1, InsiemeNumeriNaturali i2) {
		boolean[] insieme1 = i1.get();
		boolean[] insieme2 = i2.get();
		InsiemeNumeriNaturali insiemeComplemento = new InsiemeNumeriNaturali(insieme1.length);
		for (int i = 0; i < insieme1.length; i++)
			if (insieme2[i] && !insieme1[i])
				insiemeComplemento.inserisci(i);
		return insiemeComplemento;
	}
	*/
	
	// Metodo stampa che serve per stampare gli elementi dell'insieme sepati da virgole.
	public String stampa() {	
		String elementi = null;
		boolean primoElemento = true;
		for (int i = 0; i < insieme.length; i++)
			if (insieme[i])
				if(primoElemento) {
					elementi = String.valueOf(i);
					primoElemento = false;
				} else
					elementi += (", " + i);
		return elementi;
	}
}
public class Libretto {
	
	/*
	5.7
	Variabili di istanza
	Non ho scritto la variabile contatoreLibretti perché viene inizializzata e poi non viene
	più usata.
	*/
	private Dipendente dipendente;
	private int anniValidita;
	private double benefit;
	
	/*
	5.8
	Costruttore
	Anche qui, come nella classe Dipendente, non scrivo il costruttore di "default"
	per gli stessi motivi.
	*/	
	public Libretto(Dipendente dipendente, int anniValidita, double benefit) {
		this.dipendente = dipendente;
		this.anniValidita = anniValidita;
		this.benefit = benefit;
	}
	
	/*
	5.9
	Metodi getter
	*/
	public Dipendente getDipendente() {
		return this.dipendente;
	}
	
	public int getAnniValidita() {
		return this.anniValidita;
	}
	
	public double getBenefit() {
		return this.benefit;
	}
	
	/*
	5.10
	Metodi setter
	Il metodo setBenefici proposto nell'esercitazione è sbagliato. Nella descrizione infatti
	c'è scritto che una volta istanziato un oggetto Libretto, il benefit iniziale può essere solo
	decurtato o aumentato, ma non risettato. Infatti, essendo pubblico il metodo può essere
	chiamato direttamente dall'oggetto, e non per forza solo dal metodo aggiornaBenefit.
	*/
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	
	public void setAnniValidita(int anniValidita) {
		this.anniValidita = anniValidita;
	}
	
	/*
	5.11
	Metodo aggiornaBenefit
	Dal momento che la variabile benefit è double, è meglio mettere anche il parametro in input
	somma di tipo double.
	*/
	public static void aggiornaBenefit(Libretto libretto, double somma) {
		libretto.benefit += somma;
	}
	
	/*
	5.12
	Sovrascrivo il metodo toString
	*/
	@Override
	public String toString() {
		return this.dipendente.toString() + "\n" +
				"Anni validit\u00E0: " + this.anniValidita + "\n" +
				"Benefit: " + this.benefit + "\n";
	}
	
}
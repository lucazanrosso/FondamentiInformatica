public class CartaFedelta {
	
	// Variabili di istanza
	private Cliente cliente;
	private int anniValidita;
	private int punti = 1000;
	
	/*
	4.1.7
	Costruttore
	*/
	public CartaFedelta(Cliente cliente, int anniValidita) {
		this.cliente = cliente;
		this.anniValidita = anniValidita;
	}
	
	/*
	4.1.8
	Metodi getter
	*/
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getAnniValidita() {
		return this.anniValidita;
	}
	
	public int getPunti() {
		return this.punti;
	}
	
	/*
	4.1.9
	Metodo statico aggiornaPunti
	*/
	public static void aggiornaPunti(CartaFedelta cartaFedelta, int punti) {
		cartaFedelta.punti += punti;
	}
	
	/*
	4.1.10
	Sovrascrivo il metodo toString della superclasse Object
	*/
	public String toString() {
		return "Nome Cliente: " + this.cliente.getCognomeNome() + "\n" +
				"Identificatore: " + this.cliente.getIdentificatore() + "\n" + 
				"Anno rilascio tesserino: " + this.cliente.getAnno() + "\n" + 
				"Anni validit\u00E0 carta fedelt\u00E0: " + this.anniValidita + "\n" +
				"Punti carta fedelt\u00E0: " + this.punti;
	}
}
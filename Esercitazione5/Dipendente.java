public class Dipendente {
	
	/*
	5.1
	Variabili di istanza
	*/
	private String cognome;
	private String nome;
	private int matricola;
	private String tipoContratto; //Ho sostituito qualifica a tipoContratto perché più adatto al contenuto.
	private int annoAssunzione;
	private static int contaDipendenti;
	
	/*
	5.2
	Costruttore
	Non faccio il costruttore di "default" perché di fatto è inutile e anche sbagliato.
	Quando si istanzia un nuovo oggetto Dipendente si devono passare subito come parametri
	il nome, il cognome, il tipo di contratto e l'anno di assunzione.
	Un dipendente non può chiamarsi "".
	*/
	public Dipendente(String cognome, String nome, String tipoContratto, int annoAssunzione) {
		this.contaDipendenti++;
		this.cognome = cognome;
		this.nome = nome;
		this.matricola = contaDipendenti;
		this.tipoContratto = tipoContratto;
		this.annoAssunzione = annoAssunzione;
	}
	
	/*
	5.3
	Metodi getter
	*/
	public String getCognomeNome() {
		return this.cognome + " " + nome;
	}
	
	public String getMatricola() {
		return String.format("%05d", matricola);
	}
	
	public String getTipoContratto() {
		return this.tipoContratto;
	}
	
	public String getIdentificatore() {
		return getMatricola() + getTipoContratto();
	}
	
	public int getAnnoAssunzione() {
		return this.annoAssunzione;
	} 
	
	/*
	5.4
	Metodi setter
	Il metodo setIdentificatore proposto nell'esercitazione 5 presenta un errore.
	Il metodo è public, quindi può essere chiamato un qualsiasi momento, e il metodo stesso,
	oltre che modificare il tipo di contratto del dipendente,	va a modificare anche la matricola, 
	che invece dovrebbe restare sempre univoca. In questa classe non ho usato nessun metodo
	generaMatricola, perché con il metodo statico format della classe String garantisco lo
	stesso risultato in modo più semplice e con molte meno righe di codice.
	*/
	public void setCognomeNome(String cognome, String nome) {
		this.cognome = cognome;
		this.nome = nome;
	}
	
	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}
	
	public void setAnnoAssunzione(int annoAssunzione) {
		this.annoAssunzione = annoAssunzione;
	}
	
	/*
	5.5
	Metodi accessori
	Come spiegato prima, in questa classe non servono metodi accessori.
	*/
	
	/*
	5.6
	Sovrascrivo i metodi equals e toString
	Nel metodo equals non confronto anche il nome e il cognome come fatto nell'esercitazione, 
	perché è sbagliato. Due dipendenti possono avere lo stesso nome e cognome. 
	L'unica cosa che identifica univocamente il dipendente è la matricola.
	*/
	public boolean equals(Object o) {
		Dipendente dipendente = (Dipendente) o;
		return this.getMatricola().equals(dipendente.getMatricola());
	}
	
	public String toString() {
		return "Dipendente: " + this.getCognomeNome() + "\n" +
				"Identificatore: " + this.getIdentificatore() + "\n" + 
				"Anno Assunzione: " + this.getAnnoAssunzione() + "\n";
	}
}
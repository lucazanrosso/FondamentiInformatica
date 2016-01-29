public class Auto {

	// Variabili di istanza
	private String nome;
	private String cognome;
	private String codiceImmatricolazione;
	private String provincia;
	private int annoImmatricolazione;
	
	// Variabili che serviranno per la generazione del codice di immatricolazione.
	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static int contaMoto = 0;
	
	// Costruttore
	public Auto(String nome, String cognome, String provincia, int annoImmatricolazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.provincia = provincia;
		this.codiceImmatricolazione = setCodiceImmatricolazione();
		this.annoImmatricolazione = annoImmatricolazione;	
	}
	
	private String setCodiceImmatricolazione() {
		char primoCarattere = this.alfabeto.charAt((int) (Math.random() * 26));
		char secondoCarattere = this.alfabeto.charAt((int) (Math.random() * 26));
		this.contaMoto++;
		String terzoQuartoQuintoSestoCarattere = String.format("%04d", this.contaMoto);
		String codiceImmatricolazione = primoCarattere + "" +  secondoCarattere + terzoQuartoQuintoSestoCarattere;
		return codiceImmatricolazione;
	}
	
	// Metodi getter
	public String getProprietario() {
		return this.nome + " " + this.cognome;
	}
	
	public String getTarga() {
		return this.codiceImmatricolazione + this.provincia;
	}
	
	public String getProvincia() {
		return this.provincia;
	}
	
	public int getAnnoImmatricolazione() {
		return this.annoImmatricolazione;
	}
	
	// Metodo statico cambiaProvincia
	public static void cambiaProvincia(Auto auto, String provincia) {
		auto.provincia = provincia;
	}
	
	// Metodo cambiaProprietario
	public void cambiaProprietario(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	// Metodo equals
	public boolean equals(Object o) {
		Auto moto = (Auto) o;
		if (this.getTarga() == moto.getTarga())
			return true;
		return false;
	}
}
public class Moto {

	private String nome;
	private String cognome;
	// Non capisco come una stringa possa essere progressiva.
	// Realizzare un programma che calcola automaticamente una targa prograssiva 
	// con solo numeri e lettere maiuscole richiede un'algoritmo abbastanza soffisticato.
	// Comunque giusto per precisare le targhe delle moto hanno 6 caratteri alfanumerici,
	// sono le auto che hanno 5 caratteri alfanumerici e la sigla della provincia.
	private String codiceImmatricolazione = "";
	private String provincia;
	private int annoImmatricolazione;
	
	public Moto(String nome, String cognome, String provincia, int annoImmatricolazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.provincia = provincia;
		this.annoImmatricolazione = annoImmatricolazione;
	}
	
	public String getProprietario() {
		return this.nome + " " + this.cognome;
	}
	
	public String getTarga() {
		return this.provincia;
	}
	
	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	
	// Metodo STATICO cambiaProvincia???????????????????????????????????????????????????????????
	// Bisogna avere il riferimento dell'oggetto per cambiare la provincia.
	/*public static void cambiaProvincia(String targa) {
		
	}*/
	
	public void cambiaProprietario(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public boolean equals(Moto moto) {
		if (this.getTarga() == moto.getTarga())
			return true;
		return false;
	}
}
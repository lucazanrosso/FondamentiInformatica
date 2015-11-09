import java.util.Random;

public class Moto {

	/*
	3.2.1
	Dichiaro le variabili di istanza necessari per la classe Moto.
	*/
	private String nome;
	private String cognome;
	private String codiceImmatricolazione;
	private String provincia;
	private int annoImmatricolazione;
	
	// Variabili che serviranno per la generazione del codice di immatricolazione.
	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static int contaMoto = 0;
	
	/*
	3.2.3
	Costruttore, che prende in input nome, cognome, provincia e anno di immatricolazione.
	*/
	public Moto(String nome, String cognome, String provincia, int annoImmatricolazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.provincia = provincia;
		this.codiceImmatricolazione = setCodiceImmatricolazione();
		this.annoImmatricolazione = annoImmatricolazione;	
	}
	
	/*
	Questo metodo e il metdodo randomInt sono abbastanza complicati, e servono per generare 
	il codice di immatricolazione. I primi due caratteri sono due lettere dell'alfabeto maiuscole
	prese a random dalla variabile di istanza alfabeto.
	Gli ultimi tre caratteri sono tre cifre progressive formattate con il metodo statico
	format della classe String che, in questo caso, permette di stampare sempre tre cifre, 
	anche se contaMoto è uguale a 1 (verrà stampato 001).
	È un algoritmo difficile e trovo strano che il professore voglia una cosa cosi complessa,
	però di fatto c'è scritto cosi nell'esercitazione.
	*/
	private String setCodiceImmatricolazione() {
		char primoCarattere = this.alfabeto.charAt(this.randomInt(0, 25));
		char secondoCarattere = this.alfabeto.charAt(this.randomInt(0, 25));
		this.contaMoto++;
		String terzoQuartoQuintoCarattere = String.format("%03d", this.contaMoto);
		String codiceImmatricolazione = primoCarattere + "" +  secondoCarattere + terzoQuartoQuintoCarattere;
		return codiceImmatricolazione;
	}
	
	private int randomInt(int min, int max) {
		Random random = new Random();
		int randomInt = min + random.nextInt((max - min) + 1);
		return randomInt;
	}
	
	/*
	3.2.4
	Metodi getter.
	*/
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
	
	/*
	3.2.5
	Metodo statico che prende in input un oggetto Moto e la sigla della provincia.
	L'oggetto moto è necessario perché, essendo un metodo statico, non c'è nessun riferimento
	all'oggetto
	*/
	public static void cambiaProvincia(Moto moto, String provincia) {
		moto.provincia = provincia;
	}
	
	/*
	Nota: il metodo cambiaProvincia non statico risulterebbe così:
	public void cambiaProvincia(String provincia) {
		this.provincia = provincia;
	}
	*/
	
	/*
	3.2.6
	Metodo cambiaProprietario.
	*/
	public void cambiaProprietario(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	/*
	3.2.7
	Scrivendo le seguenti righe si sovrascrive il metodo equals della classe Object. Ora
	quando si chiamerà il metodo equals per gli oggetti Moto sarà preso di riferimento
	sempre questo e non quello della classe Object.
	La variabile che rende univoco ogni oggetto Moto è la targa, quindi utilizziamo la targa
	di due oggetti moto per fare il confronto.
	*/
	public boolean equals(Moto moto) {
		if (this.getTarga() == moto.getTarga())
			return true;
		return false;
	}
}
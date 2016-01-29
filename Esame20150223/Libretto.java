public class Libretto {

	// Variabili d'istanza.
	private Auto auto;
	private int anniGaranzia;
	private int kilometraggio = 500;
	
	// Costruttore
	public Libretto(Auto auto, int anniGaranzia) {
		this.auto = auto;
		this.anniGaranzia = anniGaranzia;
	}
	
	// Metodi getter
	public Auto getAuto() {
		return this.auto;
	}
	
	public int getAnniGaranzia() {
		return this.anniGaranzia;
	}
	
	public int getKilometraggio() {
		return this.kilometraggio;
	}
	
	// Metodo statico aggiornaKilometraggio.
	public static void aggiornaKilometraggio(Libretto libretto, int kilometraggio) {
		libretto.kilometraggio += kilometraggio;
	}
	
	// Metodo toString
	public String toString() {
		return "Proprietario: " + auto.getProprietario() + "\n" +
				"Targa: " + auto.getTarga() + "\n" +
				"Anno Immatricolazione: " + auto.getAnnoImmatricolazione() + "\n" + 
				"Durata Garanzia in anni: " + this.getAnniGaranzia() + "\n" + 
				"Kilometraggio: " + this.getKilometraggio() + "\n";
	}
}
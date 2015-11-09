public class Polizza {

	/*
	3.2.8
	Variabili d'istanza.
	*/
	private Moto moto;
	private int anniDurata;
	private int annoStipula;
	private int bonusMalus = 1000;
	
	/*
	3.2.9
	Costruttore che prende in input un oggetto Moto, gli anni di durata della polizza e 
	l'anno di stipula.
	*/
	public Polizza(Moto moto, int anniDurata, int annoStipula) {
		this.moto = moto;
		this.anniDurata = anniDurata;
		this.annoStipula = annoStipula;
	}
	
	/*
	3.2.10
	Metodi getter.
	*/
	public Moto getMoto() {
		return this.moto;
	}
	
	public int getAnniDurata() {
		return this.anniDurata;
	}
	
	public int getAnnoStipula() {
		return this.annoStipula;
	}
	
	public int getBonusMalus() {
		return bonusMalus;
	}
	
	/*
	3.2.11
	Metodo statico aggiornaBonusMalus.
	*/
	public static void aggiornaBonusMalus(Polizza polizza, int bonusMalus) {
		polizza.bonusMalus += bonusMalus;
	}
	
	/*
	Questo è il metodo non statico alternativo al metodo statico aggiornaBonusMalus. 
	public void aggiornaBonusMalus(int bonusMalus) {
		this.bonusMalus += bonusMalus;
	}
	*/
	
	/*
	3.2.12
	Sovrascrivo il metodo toString. Vale lo stesso discorso fatto per il metodo equals della
	classe Moto.
	*/
	public String toString() {
		return "Proprietario: " + moto.getProprietario() + "\n" +
				"Targa: " + moto.getTarga() + "\n" +
				"Anno Immatricolazione: " + moto.getAnnoImmatricolazione() + "\n" + 
				"Durata Polizza in anni: " + this.getAnniDurata() + "\n" + 
				"Anno di stipula della Polizza: " + this.getAnnoStipula() + "\n" + 
				"Bonus Malus: " + this.getBonusMalus() + "\n";
	}
}
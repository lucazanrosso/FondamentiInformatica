public class Polizza {

	private Moto moto;
	private int anniDurata;
	private int annoStipula;
	private int bonusMalus = 1000;
	
	public Polizza(Moto moto, int anniDurata, int annoStipula) {
		this.moto = moto;
		this.anniDurata = anniDurata;
		this.annoStipula = annoStipula;
	}
	
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
	
	public static void aggiornaBonusMalus(Polizza polizza, int bonusMalus) {
		polizza.bonusMalus += bonusMalus;
	}
	
	// Non è il massimo usare il metodo toString per visualizzare cosi tanti dati
	public String toString() {
		return "Proprietario: " + moto.getProprietario() + "\n" +
				"Targa: " + moto.getTarga() + "\n" +
				"Anno Immatricolazione: " + moto.getAnnoImmatricolazione() + "\n" + 
				"Durata Polizza in anni: " + this.getAnniDurata() + "\n" + 
				"Anno di stipula della Polizza: " + this.getAnnoStipula() + "\n" + 
				"Bonus Malus: " + this.getBonusMalus() + "\n";
	}

}
public class Cane {
	
	private String razza;
	//private int matricola;
	private int abilita;
	private Cinofilo cinofilo;
	private int annoNascita;
	private int annoAdesione;
	private String identificativo;
	private static int contaCane;
	
	public Cane(String razza, Cinofilo cinofilo, int annoNascita, int annoAdesione) {
		this.razza = razza;
		this.cinofilo = cinofilo;
		this.annoNascita = annoNascita;
		this.annoAdesione = annoAdesione;
		this.contaCane++;
		//this.matricola = this.contaCane;
		this.setIdentificativo();
	}
	
	private void setIdentificativo() {
		this.identificativo = this.razza + String.format("%05d", this.contaCane) + String.format("%02d", this.abilita);
	}
	
	public String getIdentificativo() {
		return this.identificativo;
	}
	
	/*public String getIdentificativo() {
		return this.razza + String.format("%05d", this.matricola) + String.format("%02d", this.abilita);
	}*/
	
	public String getRazza() {
		return this.razza;
	}
	
	/*public String getMatricola() {
		return String.format("%05d", this.matricola);
	}*/
	
	public int getAbilita() {
		return this.abilita;
	}
	
	public Cinofilo getCinofilo() {
		return this.cinofilo;
	}
	
	public int getAnnoNascita() {
		return this.annoNascita;
	}
	
	public int getAnnoAdesione() {
		return this.annoAdesione;
	}
	
	@Override
	public boolean equals(Object o) {
		Cane cane = (Cane) o;
		if (this.getIdentificativo() == cane.getIdentificativo())
			return true;
		return false;
	}
	
	public void modificaRazza(String razza) {
		this.razza = razza;
	}
	
	public static void aggiornaAbilita(Cane cane, int nuoveAbilita) {
		cane.abilita += nuoveAbilita;
	}
	
	@Override
	public String toString() {
		return "Identificativo: " + this.getIdentificativo() + "\n" +
				"Cinofilo: " + this.cinofilo.getNomeCognome() + "\n" + 
				"Anno nascita: " + this.getAnnoNascita() + "\n" + 
				"Anno adesione: " + this.getAnnoAdesione();
	}
}
public class Contratto {
	
	private Cane cane;
	private int annoStipula;
	private int coefficente;
	
	public Contratto(Cane cane, int annoStipula) {
		this.cane = cane;
		this.annoStipula = annoStipula;
		this.coefficente = this.cane.getAbilita();
	}
	
	public Cane getCane() {
		return this.cane;
	}
	
	public int getAnnoStipula() {
		return annoStipula;
	}
	
	public int getCoefficente() {
		return this.coefficente;
	}
	
	public void aggiornaCoefficente() {
		this.coefficente = this.cane.getAbilita();
	}
	
	@Override
	public String toString() {
		return this.cane + "\n" +
			"Anno stipula contratto: " + this.annoStipula;
	}
}
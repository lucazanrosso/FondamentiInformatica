public class Cinofilo {
	
	private String nome;
	private String cognome;
	private Cane cane;
	private int annoIscrizione;
	private int durataIscrizione;
	
	public Cinofilo(String nome, String cognome, int annoIscrizione, int durataIscrizione) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoIscrizione = annoIscrizione;
		this.durataIscrizione = durataIscrizione;
	}
	
	public String getNomeCognome() {
		return this.nome + " " + this.cognome;
	}
	
	public Cane getCane() {
		return cane;
	}
	
	public int getAnnoIscrizione() {
		return this.annoIscrizione;
	}
	
	public int getDurataIscrizione() {
		return this.durataIscrizione;
	}
	
	public void setCane(Cane cane) {
		this.cane = cane;
	}
	
	public int getScadenzaIscrizione() {
		return this.annoIscrizione + this.durataIscrizione;
	}
	
}
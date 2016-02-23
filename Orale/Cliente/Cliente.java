public class Cliente {
	
	/*
	4.1.1 e 4.1.2
	Variabili di istanza
	*/
	private static int contaClienti;
	private String cognome;
	private String nome;
	private String matricola;
	private String categoria;
	private int anno;
	
	/*
	4.1.3
	Costruttore
	*/
	public Cliente(String cognome, String nome, String categoria, int anno) {
		this.contaClienti++;
		this.cognome = cognome;
		this.nome = nome;
		this.matricola = String.format("%06d", contaClienti);
		this.categoria = categoria;
		this.anno = anno;
	}
	
	/*
	4.1.4
	Metodi getter
	*/
	public String getCognomeNome() {
		return this.cognome + " " +  this.nome;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public String getIdentificatore() {
		return this.matricola + this.categoria;
	}
	
	public int getAnno() {
		return this.anno;
	}
	
	/*
	4.1.5
	Metodo cambiaCategoria
	Non c'è scritto che bisogna farlo statico, però c'è scritto che deve prendere in input
	un identificatore di un Cliente (quindi un oggetto Cliente). Ho deciso comunque
	di farlo non statico.	
	*/
	public void cambiaCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/*
	4.1.6
	Sovrascittura del metodo equals
	*/
	@Override
	public boolean equals(Object o) {
		Cliente cliente = (Cliente) o;
		if (this.getIdentificatore().equals(cliente.getIdentificatore()))
			return true;
		return false;
	}	
}
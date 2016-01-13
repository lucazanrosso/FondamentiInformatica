public class InsiemeNumeriNaturali {
	
	private boolean[] insieme;
	
	public InsiemeNumeriNaturali() {
		this.insieme = new boolean[0];
	}
	
	public InsiemeNumeriNaturali(int dimensione) {
		this.insieme = new boolean[dimensione];
	}
	
	public boolean[] get() {
		return this.insieme;
	}
	
	public void set(boolean[] insieme) {
		this.insieme = insieme;
	}
	
	public int inserisci(int numero) {
		this.insieme[numero] = true;
		return numero;
	}
	
	public int cancella(int numero) {
		this.insieme[numero] = false;
		return numero;
	}
	
	public boolean controllaVuoto() {
		for (boolean posizione : this.insieme) {
			if (posizione)
				return false;
		}
		return true;
	}
	
	public boolean appartiene(int numero) {
		return this.insieme[numero];
	}
	
	public InsiemeNumeriNaturali unione(InsiemeNumeriNaturali insieme2) {
		InsiemeNumeriNaturali insiemeUnione = new InsiemeNumeriNaturali();
		boolean[] i1 = this.insieme;
		boolean[] i2 = insieme2.get();
		if (i2.length > i1.length) {
			boolean[] temp = i1;
			i1 = i2;
			i2 = temp;
		}		
		insiemeUnione.set(i1);
		for (int i = 0; i < i2.length; i++) {
			if (i2[i])
				insiemeUnione.inserisci(i);
		}
		return insiemeUnione;
	}
	
	/*public void intersezione(int[] insieme2) {
		boolean[] insieme2 = insiemeUnione.get();
		if (insieme2.length < this.insieme.length) {
			boolean[] temp = this.insieme;
			this.insieme = insieme2;
			insieme2 = temp;
		}			
		for (int i = 0; i < insieme2.length; i++) {
			if (insieme[i] || insieme2[i])
				this.insieme[i] = false;
		}
	}*/
	
	public void complemento(int[] insieme2) {
		
	}
	
	public String stampa() {	
		String elementi = null;
		boolean primoElemento = true;
		for (int i = 0; i < insieme.length; i++) {
			if (insieme[i]) {
				if(primoElemento) {
					elementi = String.valueOf(i);
					primoElemento = false;
				} else
					elementi += (", " + i);
			}
		}
		return elementi;
	}
}
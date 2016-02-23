public class Complex {
	
	/*
	6.2.1
	Inizializzo due oggetti NumeroReale e NumeroImmaginario.
	Queste due classi non sono altro che dei double mascherati.
	Il numero è accessibile attraverso il metodo get(), 
	mentre è modificabile attraverso il metodo set().
	*/
	private NumeroReale re;
	private NumeroImmaginario im;
	
	/*
	6.2.2
	Costruttori
	*/
	public Complex() {
		this.re = new NumeroReale(0);
		this.im = new NumeroImmaginario(0);
	}
	
	public Complex(NumeroReale re, NumeroImmaginario im) {
		this.re = re;
		this.im = im;
	}
	
	/*
	6.2.3
	Metodi getter
	*/	
	public NumeroReale getRe() {
		return this.re;
	}
	
	public NumeroImmaginario getIm() {
		return this.im;
	}
	
	/*
	6.2.4
	Metodi setter
	*/
	public void setRe(NumeroReale re) {
		this.re.set(re.get());
	}
	
	public void setIm(NumeroImmaginario im) {
		this.im.set(im.get());
	}
	
	public void set(NumeroReale re, NumeroImmaginario im) {
		this.re.set(re.get());
		this.im.set(im.get());
	}
	
	/*
	6.2.5
	Metodi della classe
	*/
	public Complex add (Complex b) {
		Complex ret = new Complex();
		ret.re.set(this.re.get() + b.re.get());
		ret.im.set(this.im.get() + b.im.get());
		return ret;
	}
	
	public Complex sub(Complex b) {
		Complex ret = new Complex();
		ret.re.set(this.re.get() - b.re.get());
		ret.im.set(this.im.get() - b.im.get());
		return ret;
	}
	
	public double mod() {
		return Math.sqrt(this.re.get() * this.re.get() + this.im.get() * this.im.get());
	}
	
	public double fase() {
		return Math.atan2(this.im.get(), this.re.get());
	}
	
	/*
	6.2.6
	Metodo complexUguali
	Questo metodo ha la stessa funzionalità del metodo equals, solo che prende
	in input fin da subito un oggetto Complex, quindi non è necessatio fare il cast.
	*/
	public boolean complexUguali(Complex complex) {
		if (this.re.get() == complex.re.get() && this.im.get() == complex.im.get())
			return true;
		return false;
	}
	
	/*
	6.2.7
	Override dei metodi equals e toString
	*/
	@Override
	public boolean equals(Object o) {
		Complex complex = (Complex) o;
		if (this.re.get() == complex.re.get() && this.im.get() == complex.im.get())
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return this.re.get() + "+" + this.im.get() + "i";
	}
}
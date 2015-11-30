import java.lang.Math;

public class Complex {
	
	private NumeroReale re;
	private NumeroImmaginario im;
	
	public Complex() {
		this.re = new NumeroReale(0);
		this.im = new NumeroImmaginario(0);
	}
	
	public Complex(double re, double im) {
		this.re = new NumeroReale(re);
		this.im = new NumeroImmaginario(im);
	}
	
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
	
	public double getRe() {
		return this.re.get();
	}
	
	public double getIm() {
		return this.im.get();
	}
	
	public void setRe(double re) {
		this.re.set(re);
	}
	
	public void setIm(double im) {
		this.im.set(im);
	}
	
	public void set(double re, double im) {
		this.re.set(re);
		this.im.set(im);
	}
	
	public double mod() {
		return Math.sqrt(this.re.get() * this.re.get() + this.im.get() * this.im.get());
	}
	
	public double fase() {
		return Math.atan2(this.im.get(), this.re.get());
	}
	
	public boolean complexUguali(Complex complex) {
		if (this.re.get() == complex.re.get() && this.im.get() == complex.im.get())
			return true;
		return false;
	}
	
	public boolean equals(Object o) {
		Complex complex = (Complex) o;
		if (this.re.get() == complex.re.get() && this.im.get() == complex.im.get())
			return true;
		return false;
	}
	
	public String toString() {
		return this.re.get() + "+" + this.im.get() + "i";
	}
}
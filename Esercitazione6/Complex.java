import java.lang.Math;

public class Complex {
	
	private double re;
	private double im;
	
	public Complex() {
		this.re = 0;
		this.im = 0;
	}
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public Complex add (Complex b) {
		Complex ret = new Complex();
		ret.re = this.re + b.re;
		ret.im = this.im + b.im;
		return ret;
	}
	
	public Complex sub(Complex b) {
		Complex ret = new Complex();
		ret.re = this.re - b.re;
		ret.im = this.im - b.im;
		return ret;
	}
	
	public double getRe() {
		return this.re;
	}
	
	public double getIm() {
		return this.im;
	}
	
	public void setRe(double re) {
		this.re = re;
	}
	
	public void setIm(double im) {
		this.im = im;
	}
	
	public void set(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double mod() {
		return Math.sqrt(this.re * this.re + this.im * this.im);
	}
	
	public double fase() {
		return Math.atan2(this.im, this.re);
	}
	
	public boolean complexUguali(Complex complex) {
		if (this.re == complex.re && this.im == complex.im)
			return true;
		return false;
	}
	
	public boolean equals(Object o) {
		Complex complex = (Complex) o;
		if (this.re == complex.re && this.im == complex.im)
			return true;
		return false;
	}
	
	public String toString() {
		return this.re + "+" + this.im + "i";
	}
}
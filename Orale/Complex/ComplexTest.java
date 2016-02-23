public class ComplexTest {
	
	public static void main(String[] args) {
		
		/*
		6.2.8
		Istanzio due oggetti Complex
		Non serve inizializzare anche gli oggetti NumeroReale e NumeroImmaginario,
		perché non ci servono per fare operazioni, quindi vengono creati direttamente
		quando si istanzia l'oggetto Complex.
		*/		
		Complex a = new Complex(new NumeroReale(0), new NumeroImmaginario(1));
		Complex b = new Complex();
		
		/*
		6.2.9
		Stampo i due oggetti Complex
		*/
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		/*
		6.2.10
		Testo i metodi della classe Complex
		*/
		System.out.println("a + b = " + a.add(b));
		System.out.println("a - b = " + a.sub(b));
		System.out.println("mod a = " + a.mod());
		System.out.println("fase a = " + a.fase());
		
		/*
		6.2.11
		Creo due nuovi oggetti Complex e li stampo
		*/
		Complex c = a.add(b);
		System.out.println("c = a + b = " + c);	
		Complex d = new Complex(new NumeroReale(5), new NumeroImmaginario(7));
		System.out.println("d = " + d);
		
		/*
		6.2.12
		Testo se due oggetti Complex sono uguali attraverso i metodi complexUguali e equals
		*/
		if (a.complexUguali(b))
			System.out.println("I due numeri complessi sono uguali");
		else
			System.out.println("I due numeri complessi sono diversi");
		
		if (a.equals(b))
			System.out.println("I due numeri complessi sono uguali");
		else
			System.out.println("I due numeri complessi sono diversi");
	}
}

/*
OUTPUT

a = 0.0+1.0i
b = 0.0+0.0i
a + b = 0.0+1.0i
a - b = 0.0+1.0i
mod a = 1.0
fase a = 1.5707963267948966
c = a + b = 0.0+1.0i
d = 5.0+7.0i
I due numeri complessi sono diversi
I due numeri complessi sono diversi
*/
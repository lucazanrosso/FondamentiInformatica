public class ComplexTest {
	
	public static void main(String[] args) {
		Complex a = new Complex(0, 1);
		Complex b = new Complex();
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		System.out.println("a + b = " + a.add(b));
		System.out.println("a - b = " + a.sub(b));
		System.out.println("mod a = " + a.mod());
		System.out.println("fase a = " + a.fase());
		
		Complex c = a.add(b);
		System.out.println("c = a + b = " + c);
		
		Complex d = new Complex(5, 7);
		System.out.println("d = " + d);
	}
}
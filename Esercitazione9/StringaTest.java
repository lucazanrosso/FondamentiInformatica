public class StringaTest {
	
	public static void main(String[] args) {
		
		/*
		9.1.11
		Testo tutti i metodi creati nella classe Stringa
		*/
		
		Stringa s1 = new Stringa();
		Stringa s2 = new Stringa('c', 'i', 'a', 'o');
		Stringa s3 = new Stringa('c', 'i', 'a', 'o');
		
		System.out.println("s1: " + s1.toString());
		System.out.println("s2: " + s2.toString());
		System.out.println("s3: " + s3.toString());
		
		System.out.println("s1 = s2: " + s1.equals(s2));
		System.out.println("s2 = s3: " + s2.equals(s3));
		
		System.out.println("s2 contiene 'c': " + s2.contains('c'));
		System.out.println("s2 contiene 'ci': " + s2.contains('c', 'i'));
		System.out.println("s2 contiene 'ao': " + s2.contains('a', 'o'));
		System.out.println("s2 contiene 'aoo': " + s2.contains('a', 'o', 'o'));
		System.out.println("s2 contiene 'ciii': " + s2.contains('a', 'i', 'i', 'i'));
		
		Stringa s4 = s2.substring(1, 3);		
		System.out.println("s4 substring di s2(1, 3): " + s4.toString());		
		System.out.println("s2 contiene s4: " + s2.contains(s4));
		System.out.println("s4 contiene s2: " + s4.contains(s2));
		
		Stringa s5 = s2.substring('i', 'o');		
		System.out.println("s5 substring di s2(i, o): " + s5.toString());
		
		Stringa s6 = s2.invert();
		System.out.println("s6 inverso di s2: " + s6.toString());
		
		Stringa s7 = s2.concat(s3);
		System.out.println("s7 concatenazione di s2 e s3: " + s7.toString());
				
		System.out.println("s2 comparato con s3: " + s2.compareTo(s3));
		System.out.println("s2 comparato con s4: " + s2.compareTo(s4));
		System.out.println("s4 comparato con s2: " + s4.compareTo(s2));
		System.out.println("s2 comparato con s7: " + s2.compareTo(s7));
		System.out.println("s7 comparato con s2: " + s7.compareTo(s2));
	}
}
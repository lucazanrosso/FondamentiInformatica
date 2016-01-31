public class NewCompitoFeb2015 {
	static String a;
	static String b;
	
	public static void main(String[] args) {
		int v[];
		v = new int[10];
		
		System.out.println("PRIMA STAMPA");
		System.out.println(v[0]);
		System.out.println(v[1]);
		System.out.println(v.length);
		
		modifica(v);
		
		System.out.println("TERZA STAMPA");
		System.out.println(v[0]);
		System.out.println(v[1]);
		System.out.println(v.length);
		
		a = "121";
		b = "212";
		change(a, b, v);
		a = a + v[1];
		
		System.out.println("QUINTA STAMPA");
		System.out.println(a);
		System.out.println(b);
		System.out.println(v[0]);
		System.out.println(v[1]);
	}
	
	public static void modifica(int[] a) {
		a[0] = 66;
		a[1] = 11;
		a = new int[20];
		
		System.out.println("SECONDA STAMPA");
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a.length);
	}
	
	public static void change(String a, String b, int z[]) {
		String temp = a;
		z[1] = z[1] + z[2];
		a = b + z[2];
		b = temp;

		System.out.println("QUARTA STAMPA");
		System.out.println(a);
		System.out.println(b);
		System.out.println(z[0]);
		System.out.println(z[1]);
	}
}

/*
OUTPUT:

PRIMA STAMPA
0
0
10
SECONDA STAMPA
0
0
20
TERZA STAMPA
66
11
10
QUARTA STAMPA
2120
121
66
11
QUINTA STAMPA
121
212
66
11
*/
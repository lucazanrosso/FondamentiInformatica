public class Prova {

	static private int[] a;

	public static void main(String[] args) {
		a = new int[7];
		a[0] = 22;
		a[1] = 57;
		a[2] = 33;
		a[3] = 11;
		a[4] = 12;
		a[5] = 100;
		a[6] = 99;
		
		stampa();
		
		fff();
		ggg();
		//fff();
		
		stampa();
		
		System.out.println(recLinearSearch(99));
		System.out.println(recBinarySearch(99, 0, 6));	
	}
	
	public static void fff() {
		boolean scambio = true;
		while (scambio) {
			scambio = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i + 1] > a[i]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					scambio = true;
				}
			}
		}
	}
	
	public static void ggg() {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
	}
	
	public static int recLinearSearch(int n) {
		return recLinearSearch(n, 0);
	}
	
	public static int recLinearSearch(int n, int pos) {
		if (pos == a.length)
			return -1;
		else if (n == a[pos])
			return pos;
		else
			return recLinearSearch(n, pos + 1);
	}
	
	public static int recBinarySearch(int n, int from, int to) {
		if (from > to)
			return -1;
		int mid = (from + to) / 2;
		int middle = a[mid];
		if (middle == n)
			return mid;
		else if (middle > n)
			return recBinarySearch(n, mid + 1, to);
		else
			return recBinarySearch(n, from, mid - 1);
	}
	
	public static void stampa() {
		for (int n : a)
			System.out.println(n);
	}
}
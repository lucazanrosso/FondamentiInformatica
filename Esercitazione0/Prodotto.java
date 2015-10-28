public class Prodotto {
	public static void main(String[] args) {
		int x = 4;
		int y = 7;

		int z = 0;
		int v = y;

		while (v != 0) {
			z = z + x;
			v = v - 1;
		}
		System.out.println(z);
	}
}
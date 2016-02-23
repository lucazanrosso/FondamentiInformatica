public class Divisione {
	public static void main(String[] args) {
		int x = 29;
		int y = 7;

		int q = 0;
		int r = x;

		while (r >= y) {
			q = q + 1;
			r = r - y;
		}
		System.out.println(q);
	}
}
public class Somma {
	public static void main(String[] args) {
		int x = 4;
		int y = 7;

		int s = x;
		int t = y;

		while (t != 0) {
			s = s + 1;
			t = t - 1;
		}
		System.out.println(s);
	}
}
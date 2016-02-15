public class Point {
	
	private static double a, b, c, d;
	private double x, y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double dist(Point p) {
		double base = this.x - p.x;
		double altezza = this.y - p.y;
		return Math.sqrt(base * base + altezza * altezza);
	}
	
	public static void main(String[] args) {
		
	}
	
	@Override
	public String toString() {
		return "x: " + this.x + "\n" + 
				"y: " + this.y;
	}
	
	public static void main(String[] args) {
		Point vett[] = new Point;
	}
	
}
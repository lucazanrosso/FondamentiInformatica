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
	
	@Override
	public String toString() {
		return "x: " + this.x + "y: " + this.y;
	}
	
	public static void main(String[] args) {
		Point vett[] = new Point[4];
		a = 4;
		b = 3;
		Point p1 = new Point();
		Point p2 = new Point(a, b);
		vett[1] = p1;
		vett[2] = p2;
		double dist21 = p1.dist(p2);
		
		for(int i = 0; i < vett.length; i++)
			System.out.println(vett[i]);
		System.out.println(dist21);
		
		modifica(vett, p1);
		dist21 = p1.dist(p2);
		
		for(int i = 0; i < vett.length; i++)
			System.out.println(vett[i]);
		System.out.println(dist21);
	}
	
	public static void modifica(Point aaa[], Point z) {
		c = a + a;
		d = b + b;
		Point p2 = new Point();
		Point p3 = new Point(c, d);
		aaa[1] = z;
		aaa[2] = p2;
		aaa[3] = p3;
		double dist32 = aaa[2].dist(aaa[3]);
		
		for (int i = 0; i < aaa.length; i++)
			System.out.println(aaa[i]);
		System.out.println(dist32);
		
		z = new Point(a, b);
		aaa[2] = aaa[3];
		aaa = new Point[5];
		
		for (int i = 0; i < aaa.length; i++)
			System.out.println(aaa[i]);
	}
}

/*
null
x: 0.0y: 0.0
x: 4.0y: 3.0
null
5.0
null
x: 0.0y: 0.0
x: 0.0y: 0.0
x: 8.0y: 6.0
10.0
null
null
null
null
null
null
x: 0.0y: 0.0
x: 8.0y: 6.0
x: 8.0y: 6.0
5.0
*/
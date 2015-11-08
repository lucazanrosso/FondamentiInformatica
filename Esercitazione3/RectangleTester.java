import java.awt.Rectangle;

	public class RectangleTester {
		
		public static void main(String[] args) {
			// Istanzio un nuovo oggetto di tipo Rectangle
			Rectangle rectangle = new Rectangle(0, 0, 20, 30);
			// Chiamo il metodo rectangleArea che restituirà l'area dell'oggetto rectangle
			double area = rectangleArea(rectangle);
			/*
			Se provate a stampare l'oggetto rectangle vi verrà stampata questa riga:
			java.awt.Rectangle[x=0,y=0,width=20,height=30].
			Questo perchè la classe Rectangle contine un metodo toString che viene chiamato
			automaticamente quando si passa come parametro l'oggetto rectangle a System.out.println(),
			e che stamperà a video la posizione nello spazio, la base e l'altezza del rettangolo.
			*/
			System.out.println(rectangle);
			System.out.println("Rectangle area: " + area);
		}
		
		public static double rectangleArea(Rectangle rectangle) {
			/*
			getWidth e getHeight sono due metodi della classe Rectangle che ritornano
			rispettivamente la base e l'altezza del rettangolo.
			*/
			double area = rectangle.getWidth() * rectangle.getHeight();
			return area;
		}
		
}
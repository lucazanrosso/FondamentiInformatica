// DA FINIRE

import java.awt.Rectangle;

	public class RectangleTester {
		
		public static void main(String[] args) {
			// Istanzio tre nuovi oggetti di tipo Rectangle
			Rectangle rectangle1 = new Rectangle(15, 15, 20, 30);
			Rectangle rectangle2 = new Rectangle(10, 0, 10, 30);
			Rectangle rectangle3 = new Rectangle(0, 25, 20, 40);
			
			/*
			Penso che per ridenominare si intenda dare nuovi valori di base e altezza.
			setSize serve per settare base e altezza, non esiste il metodo setHeight o setWidth.
			*/
			rectangle2.setSize(40, 10);
			rectangle3.setSize(20, 30);
			
			/*
			Con la traslazione i rettangolo non si spostano alla x e y passati come parametro,
			ma semplicemente la loro posizione viene incrementate di x e y. 
			Per cambiare i valori di x e y bisogna usare il metodo setLocation(int x, int y).
			*/
			rectangle1.translate(5, 10);
			
			/*
			Se provate a stampare l'oggetto rectangle vi verrà stampata questa riga:
			java.awt.Rectangle[x=0,y=0,width=20,height=30].
			Questo perchè la classe Rectangle contine un metodo toString che viene chiamato
			automaticamente quando si passa come parametro l'oggetto rectangle a System.out.println(),
			e che stamperà a video la posizione nello spazio, la base e l'altezza del rettangolo.
			*/
			System.out.println(rectangle1);
			System.out.println(rectangle2);
			System.out.println(rectangle3);
			
			// Confrontare i rettangoli traslati con quelli istanziati all'inizio???????????????????
			
			// Chiamo il metodo rectangleArea che restituirà l'area dell'oggetto rectangle
			double area1 = rectangleArea(rectangle1);
			double area2 = rectangleArea(rectangle2);
			double area3 = rectangleArea(rectangle3);
			
			if (area1 == area2)
				System.out.println("Il primo rettangolo è uguale al secondo");
			else
				System.out.println("Il primo rettangolo non è uguale al secondo");
			
			if (area2 == area3)
				System.out.println("Il secondo rettangolo è uguale al terzo");
			else
				System.out.println("Il secondo rettangolo non è uguale al terzo");
			
			if (area1 == area3)
				System.out.println("Il primo rettangolo è uguale al terzo");
			else
				System.out.println("Il primo rettangolo non è uguale al terzo");
			
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
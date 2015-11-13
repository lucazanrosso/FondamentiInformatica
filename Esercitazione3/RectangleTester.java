//3.1.1
import java.awt.Rectangle;

	public class RectangleTester {
		
		public static void main(String[] args) {
			/*
			3.1.2
			Istanzio due nuovi oggetti di tipo Rectangle
			*/
			Rectangle rectangle1 = new Rectangle(15, 15, 20, 30);
			Rectangle rectangle2 = new Rectangle(10, 0, 10, 30);
			Rectangle rectangle3 = new Rectangle(40, 25, 20, 30);
			
			/*
			3.1.3
			Il professore Bortoletto mi ha detto che ridenominare vuol dire inizializzare una nuova
			variabile e assegnare un'oggetto già esistente alla variabile. Poi bisogna portare
			la prima variabile a null (in questo caso rectangle1). 
			*/
			Rectangle rect1 = rectangle1;
			rectangle1 = null;
			
			/*
			3.1.4
			Se provate a stampare l'oggetto rectangle vi verrà stampata questa riga:
			java.awt.Rectangle[x=0,y=0,width=20,height=30].
			Questo perchè la classe Rectangle contine un metodo toString che viene chiamato
			automaticamente quando si passa come parametro l'oggetto rectangle a System.out.println(),
			e che stamperà a video la posizione, la base e l'altezza del rettangolo.
			Nota: se stampo rectangle1 verrà visualizzata la parola null, perché ora rectangle1
			è un oggetto Rectangle vuoto. Se si prova a interagire con rectagle1, java ci
			bloccherà con una NullPointerExeption.
			*/
			System.out.println();
			System.out.println("rectangle1: " + rectangle1);
			System.out.println("rect1: " + rect1);
			System.out.println("rectangle2: " + rectangle2);
			System.out.println("rectangle3: " + rectangle3);
			
			/*
			3.1.5
			Con la traslazione i rettangolo non si spostano alla x e y passati come parametro,
			ma semplicemente la loro posizione viene incrementata di x e y. 
			Per cambiare i valori di x e y bisogna usare il metodo setLocation(int x, int y).
			Per prima cosa, quindi, salvo su due variabili il valore di x e y prima della traslazione,
			che serviranno per fare il confronto del punto 3.1.6, poi traslo un rettangolo.
			*/
			int xBeforeTranslate = (int) rect1.getX();
			int yBeforeTranslate = (int) rect1.getY();
			rect1.translate(5, 10);
			
			/*
			3.1.6
			Confronto rect1, che è stato traslato, con i valori di rectangle1 prima della traslazione.
			Nota: \u00E8 corrisponde alla lettera accentata. Bisogna scriverlo perché Java non
			codifica autonomamente i caratteri speciali.
			*/
			System.out.println();
			if (rect1.getX() == xBeforeTranslate && rect1.getY() == yBeforeTranslate)
				System.out.println("rect1 traslato ha la stessa posizione di rect1 prima della traslazione");
			else
				System.out.println("rect1 traslato non ha la stessa posizione di rect1 prima della traslazione");
			
			/*
			3.1.7
			Chiamo il metodo rectangleArea che restituirà l'area dell'oggetto Rectangle passato
			come parametro. Successivamente faccio due confronti di area tra rect1 e rectangle2,
			e tra rect1 e rectangle3.
			*/
			double rect1Area = rectangleArea(rect1);
			double rectangle2Area = rectangleArea(rectangle2);
			double rectangle3Area = rectangleArea(rectangle3);
			
			if (rect1Area == rectangle2Area)
				System.out.println("rect1 ha la stessa area di rectangle2");
			else
				System.out.println("rect1 non ha la stessa area di rectangle2");
			
			if (rect1Area == rectangle3Area)
				System.out.println("rect1 ha la stessa area di rectangle3");
			else
				System.out.println("rect1 non ha la stessa area di rectangle3");
		
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
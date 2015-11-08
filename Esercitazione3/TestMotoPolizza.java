// DA FINIRE

public class TestMotoPolizza {

	public static void main(String[] args) {
		
		Moto honda = new Moto("Luca", "Zanrosso", "VI", 2015);
		Polizza polizzaHonda = new Polizza(honda, 1, 2015);
		
		Moto yamaha = new Moto("Andrea", "Zanrosso", "VI", 2015);
		Polizza polizzaYamaha = new Polizza(yamaha, 3, 2015);
		
		if (honda.equals(yamaha))
			System.out.println("Attenzione: le due moto sono uguali");
		else
			System.out.println("Bene, le due moto sono diverse");
		
		System.out.println(polizzaHonda);
		System.out.println(polizzaYamaha);
		
	}

}
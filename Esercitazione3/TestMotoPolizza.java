// DA FINIRE

public class TestMotoPolizza {

	public static void main(String[] args) {
		
		Moto honda = new Moto("Luca", "Zanrosso", "VI", 2015);
		Polizza polizzaHonda = new Polizza(honda, 1, 2015);
		
		Moto yamaha = new Moto("Andrea", "Zanrosso", "VI", 2015);
		Polizza polizzaYamaha = new Polizza(yamaha, 3, 2015);
		
		System.out.println(honda.getTarga());
		System.out.println(yamaha.getTarga());
		
		// IL METODO EQUALS DEFINITO NELLA CLASSE MOTO NON FUNZIONA
		//if (honda.equals(yamaha))
		if (honda.getTarga() == yamaha.getTarga())
			System.out.println("Attenzione: le due moto sono uguali");
		else
			System.out.println("Bene, le due moto sono diverse");
		
		
	}

}
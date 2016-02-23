// DA FINIRE

public class TestMotoPolizza {

	public static void main(String[] args) {
		
		/*
		3.2.13 e 3.2.14
		Istanzio 2 nuovi oggetti Moto e due nuovi oggetti Polizza.
		*/
		Moto honda = new Moto("Luca", "Zanrosso", "VI", 2015);
		Polizza polizzaHonda = new Polizza(honda, 1, 2015);
		
		Moto yamaha = new Moto("Andrea", "Zanrosso", "VI", 2015);
		Polizza polizzaYamaha = new Polizza(yamaha, 3, 2015);
		
		/*
		3.2.15
		Controllo con il metodo equals sovrascritto nella classe Moto se i due oggetti Moto
		hanno la stessa targa.
		*/
		System.out.println();
		if (honda.equals(yamaha))
			System.out.println("Attenzione: le due moto sono uguali");
		else
			System.out.println("Bene, le due moto sono diverse");
		System.out.println();
		
		/*
		3.2.16
		Cambio la provincia dell'oggetto honda.
		*/
		Moto.cambiaProvincia(yamaha, "PU");
		
		/*
		3.2.17
		Cambio il proprietario dell'oggetto yamaha.
		*/
		yamaha.cambiaProprietario("Valentino", "Rossi");
		
		/*
		3.2.18
		Stampo le polizze con il metodo toString sovrascritto nella classe Polizza.
		*/
		System.out.println(polizzaHonda);
		System.out.println(polizzaYamaha);
		
		/*
		3.2.19
		Prima verifico, attraverso la polizza, se le moto hanno la stessa provincia,
		poi verifico se le moto hanno lo stesso proprietario.
		*/
		if (polizzaHonda.getMoto().getProvincia() == polizzaYamaha.getMoto().getProvincia())
			System.out.println("Dalla polizza si legge che le due moto sono della stessa provincia");
		else
			System.out.println("Dalla polizza si legge che le due moto non sono della stessa provincia");
		
		if (polizzaHonda.getMoto().getProprietario() == polizzaYamaha.getMoto().getProprietario())
			System.out.println("Dalla polizza si legge che le due moto hanno lo stesso proprietario");
		else
			System.out.println("Dalla polizza si legge che le due moto hanno proprietari diversi");
		
		/*
		3.2.20
		Aggiorno il bonus malus di +150.
		*/
		Polizza.aggiornaBonusMalus(polizzaHonda, 150);
	}
}
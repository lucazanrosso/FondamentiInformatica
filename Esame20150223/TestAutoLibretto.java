public class TestAutoLibretto {
	
	public static void main(String[] args) {
	
		// Istanzio due oggetti Auto
		Auto a1 = new Auto("Luca", "Zanrosso", "VI", 2012);
		Auto a2 = new Auto("Antonio", "Zanrosso", "VI", 2015);
		
		// Istanzio due oggetti Libretto
		Libretto l1 = new Libretto(a1, 3);
		Libretto l2 = new Libretto(a2, 5);
		
		// Controllo se i due oggetti Auto sono uguali con il metodo equals
		System.out.println("\nLe due auto sono uguali? " + a1.equals(a2) + "\n");
		
		// Cambio provincia del primo oggetto Auto
		Auto.cambiaProvincia(a1, "PD");
		
		// Cambio proprietario del secondo oggetto Auto
		a2.cambiaProprietario("Andrea", "Zanrosso");
		
		// Stampo i due libretti con il metodo toString
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		
		// Controllo, attraverso gli oggetti Libretto, se i due oggetti Auto hanno la stessa provincia e/o lo stesso proprietario
		System.out.println("Le due auto hanno la stessa provincia? " + 
				(l1.getAuto().getProvincia() == l2.getAuto().getProvincia()) + "\n");
		System.out.println("Le due auto hanno lo stesso proprietario? " + 
				(l1.getAuto().getProprietario() == l2.getAuto().getProprietario()));
		
		// Aggiorno il kilometraggio del primo oggetto Libretto
		Libretto.aggiornaKilometraggio(l1, 4600);
	}
}
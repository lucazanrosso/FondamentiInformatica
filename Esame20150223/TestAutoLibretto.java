public class TestAutoLibretto {
	
	public static void main(String[] args) {
	
		Auto a1 = new Auto("Luca", "Zanrosso", "VI", 2012);
		Auto a2 = new Auto("Antonio", "Zanrosso", "VI", 2015);
		
		Libretto l1 = new Libretto(a1, 3);
		Libretto l2 = new Libretto(a2, 5);
		
		System.out.println("\nLe due auto sono uguali? " + a1.equals(a2) + "\n");
		
		Auto.cambiaProvincia(a1, "PD");
		
		a2.cambiaProprietario("Andrea", "Zanrosso");
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		
		System.out.println("Le due auto hanno la stessa provincia? " + 
				(boolean) (l1.getAuto().getProvincia() == l2.getAuto().getProvincia()) + "\n");
				
		System.out.println("Le due auto hanno lo stesso proprietario? " + 
				(boolean) (l1.getAuto().getProprietario() == l2.getAuto().getProprietario()));
		
		Libretto.aggiornaKilometraggio(l1, 4600);
	}
}
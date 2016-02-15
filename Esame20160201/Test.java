public class Test {
	
	public static void main(String[] args) {
		Cinofilo c1 = new Cinofilo("Luca", "Zanrosso", 2013, 3);
		Cinofilo c2 = new Cinofilo("Andrea", "Zanrosso", 2015, 5);
		
		Cane ca1 = new Cane("ZZZ", c1, 2008, 2013);
		Cane ca2 = new Cane("ABC", c2, 2012, 2015);
		
		c1.setCane(ca1);
		c2.setCane(ca2);
		
		Contratto co1 = new Contratto(ca1, 2013);
		Contratto co2 = new Contratto(ca2, 2015);
		
		System.out.println(co1);
		System.out.println(co2);
		
		System.out.println("I due cani sono uguali? " + ca1.equals(ca2));
		
		ca1.modificaRazza("ABC");
		
		Cane.aggiornaAbilita(ca1, 5);
		
		co1.aggiornaCoefficente();
		
		System.out.println("I due cani hanno la stessa razza? " + co1.getCane().getRazza().equals(co2.getCane().getRazza()));
		System.out.println("I due cani hanno lo stesso proprietario? " + co1.getCane().getCinofilo().getNomeCognome().equals(co2.getCane().getCinofilo().getNomeCognome()));
	}
}
public class TestLibrettoDipendente {
	
	public static void main(String[] args) {
		
		/*
		5.13
		Istanzio due oggetti Dipendenti
		*/
		Dipendente d1 = new Dipendente("Pagello", "Enrico", "PRA", 1983);
		Dipendente d2 = new Dipendente("Bortoletto", "Roberto", "MSC", 2011);
		
		/*
		5.14
		Stampo i due oggetti Dipendenti con il metodo toString sovrascitto
		*/
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		
		/*
		5.15
		Stampo matricola e tipo di contratto del secondo dipendente
		*/
		System.out.println("Matricola d2: " + d2.getMatricola());
		System.out.println("Tipo Contratto d2: " + d2.getTipoContratto() + "\n");
		
		/*
		5.16
		Verifico se i due dipendenti sono oggetti uguali
		*/
		if (d1.equals(d2))
			System.out.println("I due dipendenti sono la stessa persona \n");
		else
			System.out.println("I due dipendenti sono persone diverse \n");
		
		/*
		5.17
		Cambio il tipo di contratto del primo dipendente
		*/
		d1.setTipoContratto("PRO");
		System.out.println("Tipo contratto d1: " + d1.getTipoContratto() + "\n");
		
		/*
		5.18
		Istanzio due oggetti libretto
		*/
		Libretto lb1 = new Libretto(d1, 10, 1000);
		Libretto lb2 = new Libretto(d2, 10, 1000);
		
		/*
		5.20
		Stampo i due oggetti Libretto
		*/
		System.out.println(lb1.toString());
		System.out.println(lb2.toString());
		
		/*
		5.21
		Verifico, attraverso il libretto, se i due dipendenti hanno lo stesso tipo di contratto
		*/
		if (lb1.getDipendente().getTipoContratto().equals(lb2.getDipendente().getTipoContratto()))
			System.out.println("I due dipendenti hanno lo stesso tipo di contratto \n");
		else
			System.out.println("I due dipendenti non hanno lo stesso tipo di contratto \n");
		
		/*
		5.22
		Aggiorno il benefit del primo dipendente
		*/
		Libretto.aggiornaBenefit(lb1, 5000);
		System.out.println("Benefit lb1: " + lb1.getBenefit());
	}
}
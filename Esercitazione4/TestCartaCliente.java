public class TestCartaCliente {
	
	public static void main(String[] args) {
		
		/*
		4.1.11
		Istanzio due oggetti Cliente
		*/
		Cliente cliente1 = new Cliente("Zanrosso", "Luca", "SIG", 2015);
		Cliente cliente2 = new Cliente("Zanrosso", "Andrea", "JUN", 2015);
		
		/*
		4.1.12
		Confonto se i due clienti sono uguali con il metodo equals sovrascritto nella classe Cliente
		*/
		System.out.println();
		if (cliente1.equals(cliente2))
			System.out.println("Attenzione, i due clienti sono la stessa persona");
		else
			System.out.println("Bene, i due clienti sono persone diverse");
		
		/*
		4.1.13
		Cambio la categoria di un cliente
		*/
		cliente2.cambiaCategoria("SIG");
		
		/*
		4.1.14
		Istanzio due oggetti CartaFedelta
		*/
		CartaFedelta cartaFedelta1 = new CartaFedelta(cliente1, 3);
		CartaFedelta cartaFedelta2 = new CartaFedelta(cliente2, 5);
		
		/*
		4.1.15
		Stampo le due carte con il metodo toString sovrascritto nella classe CartaFedelta
		*/
		System.out.println();
		System.out.println(cartaFedelta1.toString());
		System.out.println();
		System.out.println(cartaFedelta2.toString());
		
		/*
		4.1.16
		Confonto le categorie dei clienti attraverso la carta fedeltà
		*/
		System.out.println();
		if (cartaFedelta1.getCliente().getCategoria() == cartaFedelta2.getCliente().getCategoria())
			System.out.println("I due clienti hanno la stessa categoria");
		else
			System.out.println("I due clienti non hanno la stessa categoria");
		
		/*
		4.1.17
		Aggiorno i punti fedeltà usando il metodo statico aggiornaPunti della classe CartaFedelta
		*/
		CartaFedelta.aggiornaPunti(cartaFedelta1, 300);
	}
}
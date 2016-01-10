public class InsiemeNumeriNaturaliTest {
	
	public static void main(String[] args) {
		
		InsiemeNumeriNaturali n1 = new InsiemeNumeriNaturali(10);
		
		n1.inserisci(1);
		n1.inserisci(3);
		
		n1.cancella(3);
		
		if (n1.controllaVuoto())
			System.out.println("L'insieme \u00E8 vuoto");
		else
			System.out.println("L'insieme non \u00E8 vuoto");
		
		if (n1.appartiene(1))
			System.out.println("1 appartiene all'insieme");
		else
			System.out.println("1 non appartiene all'insieme");		
		if (n1.appartiene(3))
			System.out.println("3 appartiene all'insieme");
		else
			System.out.println("3 non appartiene all'insieme");
	}
}
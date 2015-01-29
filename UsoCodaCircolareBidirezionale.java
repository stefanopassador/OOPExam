public class UsoCodaCircolareBidirezionale {
	public static void main(String[] args) {
		String[] s = {"Prova 1", "Prova 2", "Prova 3"};
		CodaCircolareBidirezionale<String> coda = new CodaCircolareBidirezionale(s);

		System.out.println(coda.toString("|", true));
		System.out.println(coda.toString("|", false));

		coda.ruotaOrario(4);
		if (coda.trova("Prova 2")) {
			System.out.println("Prova 2");
		}
		if (!coda.trova("Prova 5")) {
			System.out.println(coda.leggi());
		}

		coda.sovrascrivi("Prova 7");
		System.out.println(coda.leggi());
	}
}
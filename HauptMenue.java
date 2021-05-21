package lagerverwaltung;

public class HauptMenue implements Menue {

	private Lagerverwaltung lager;

	public HauptMenue(Lagerverwaltung lager) {
		this.lager = lager;
	}

	public HauptMenue(int[][] lager) {
	}

	@Override
	public Menue call() throws java.io.IOException {
		System.out.println("Hauptmenue");
		System.out.println("==========\n");
		System.out.println("Was möchten Sie tun");
		System.out.println("1. Kiste von Liste waehlen");
		System.out.println("2. Kiste erstellen");
		System.out.println("3. Ende\n");

		System.out.print("?>");
		char n = (char) System.in.read();
		switch (n) {
		case '1':
			// TODO
			return new AuswahlMenue(lager);
		case '2':
			// TODO
			return new AendernMenue(lager);
		case '3':
			return null;
		default:
			return this;
		}
	}
}
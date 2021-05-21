package lagerverwaltung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AuswahlMenue implements Menue {

	private Lagerverwaltung verwaltung;

	public AuswahlMenue(Lagerverwaltung lager) {
		this.verwaltung = lager;
	}

	@Override
    public Menue call() throws IOException {
        System.out.println("Lagerauswahl");
        System.out.println("============\n");
        // Ausgabe aller 75 vorandenen Kisten
        int[][] lager = verwaltung.getLager();
        System.out.println("| Kiste | Laenge | Breite | Hoehe |");
        System.out.println("|-------|--------|--------|-------|");
        for (int i = 0; i < lager.length; i++) {
            int[] kiste = lager[i];
            if(kiste[0] != 0) {
                System.out.println(String.format("| %d | %d | %d | %d |", kiste[0], kiste[1], kiste[2], kiste[3]));

            }
        }
        System.out.println("Bitte eine Kiste waehlen: >");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = reader.readLine();
        if(eingabe.isEmpty()) {
            return new HauptMenue(verwaltung);
        }
        //TODO eingabe als Integer parsen. fehler abfangen. eingabe validieren,
        // wenn alles gut ist mit der gewählten kiste ins nächste menü springen.
        try {
            int id = Integer.parseInt(eingabe);
            int[] kiste = verwaltung.anzeigen(id);
            return new AendernMenue(verwaltung, kiste);
        }catch (KisteUnbekanntException | NumberFormatException e) {
            //user hat eine falsche eingabe gemacht
            System.out.println("Die Eingabe war falsch, bitte gebe Sie erneut eine Nummer ein");
            return this;
        }
    }

}

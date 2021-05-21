package lagerverwaltung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AendernMenue implements Menue {

	private final Lagerverwaltung lager;
	private final int[] kiste;

	public AendernMenue(Lagerverwaltung lager, int[] kiste) {
		this.lager = lager;
		this.kiste = kiste;
	}

	public AendernMenue(Lagerverwaltung lager) {
		this(lager, new int[4]);
	}

	@Override
	public Menue call() throws IOException, LagerVollException {

		System.out.println("Bitte geben Sie die neuen Ma�e ein");

		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bitte die neuen Ma�e eingeben breite, laenge und hoehe eingeben:");
		System.out.print("Breite? ");
		String in = reader.readLine();
		int breite = Integer.parseInt(in);
		System.out.print("Laenge? ");
		in = reader.readLine();
		int laenge = Integer.parseInt(in);
		System.out.print("Hoehe? ");
		in = reader.readLine();
		int hoehe = Integer.parseInt(in);
		// hier wuerde ich ne sicherheitsabfrage machen. alte werte anzeigen, neue Werte
		// anzeigen, Aktualisieren? (J/N/raus)
		System.out.println(String.format("Ihre Eingabe war: (b/l/h) %d/%d/%d", breite, laenge, hoehe)  );
		System.out.println("Moechten Sie die Masse aktualisieren ([J]a [N]ein [Z]urueck)");
		char frage = (char) reader.read();
		
		switch (frage) {
		case 'j':
			// hier brauchen wir nacher noch ein if, wenn wir "neu" implementieren , machen
			// wir neu hier rein- ja, ader einzige unterschied ist in (alte werte anzeigen)
			// und (neue ID vergeben)
			if(kiste[0]==0){
				// neue kiste, muss ins lager gespeichert werden
				kiste[0] = lager.neu(breite, laenge, hoehe);
			} else {
			kiste[1] = breite;
			kiste[2] = laenge;
			kiste[3] = hoehe;
			}
			System.out.print("Kiste Nr " + kiste[0] + " wurde aktualisiert");  
			return new AuswahlMenue(lager);
		case 'n':
			return this;
		case 'z':
			return new AuswahlMenue(lager);
		default:
			return this;
		}
	}

}

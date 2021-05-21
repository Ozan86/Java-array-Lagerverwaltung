package lagerverwaltung;

import java.io.IOException;

public interface Menue {

	Menue call() throws IOException, LagerVollException;

}

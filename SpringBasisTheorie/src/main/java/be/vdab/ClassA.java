package be.vdab;

import java.io.File;
import java.net.URL;
import java.util.Locale;

public class ClassA implements InterfaceA{
	
	private String telefoonNrHelpDesk;
	private URL koersenURL;
	private Locale defaultTaalEnLand;
	private File importData;
	private BladRichtingInPrinter defaultBladRichting; 
	
	public String getTelefoonNrHelpDesk() {
		return telefoonNrHelpDesk;
	}
			
	public URL getKoersenURL() {
		return koersenURL;
	}

	public Locale getDefaultTaalEnLand() {
		return defaultTaalEnLand;
	}

	public File getImportData() {
		return importData;
	}

	public BladRichtingInPrinter getDefaultBladRichting() {
		return defaultBladRichting;
	}
	
	public void setTelefoonNrHelpDesk(String telefoonNrHelpDesk) {
		this.telefoonNrHelpDesk = telefoonNrHelpDesk;
	}
	
	public void setKoersenURL(URL koersenURL) {
		this.koersenURL = koersenURL;
	}

	public void setDefaultTaalEnLand(Locale defaultTaalEnLand) {
		this.defaultTaalEnLand = defaultTaalEnLand;
	}

	public void setImportData(File importData) {
		this.importData = importData;
	}

	public void setDefaultBladRichting(BladRichtingInPrinter defaultBladRichting) {
		this.defaultBladRichting = defaultBladRichting;
	}

	@Override
	  public String getBoodschap() {
	    return "een ClassA object";
	  }
}

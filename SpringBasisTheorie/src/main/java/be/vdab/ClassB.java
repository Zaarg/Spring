package be.vdab;

public class ClassB implements InterfaceB{
	
	private final String telefoonNrHelpDesk;  // je maakt zelf een getter
	private final int aantalPogingenUpdateKlant;  // je maakt zelf een getter 
		
	public ClassB(String telefoonNrHelpDesk, int aantalPogingenUpdateKlant) {
		  this.telefoonNrHelpDesk = telefoonNrHelpDesk;
		  this.aantalPogingenUpdateKlant = aantalPogingenUpdateKlant;
	} 
	
	public String getTelefoonNrHelpDesk() {
		return telefoonNrHelpDesk;
	}

	public int getAantalPogingenUpdateKlant() {
		return aantalPogingenUpdateKlant;
	}

	@Override
	  public String getBoodschap() {
	    return "een ClassB object";
	  }
}

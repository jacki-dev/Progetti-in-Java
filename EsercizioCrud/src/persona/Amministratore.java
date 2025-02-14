package persona;

public class Amministratore extends Persona {

	private int stipendio;

	public Amministratore(int id, String nome, String cognome, int eta) {
		super(id, nome, cognome, eta);
	}
	
	//stipendio classe Amministratore
	public void setstipendio (int stipendio) {
		this.stipendio = stipendio;
	}
	
	public int getstipendio() {
		return stipendio;
	}
	
	@Override
	public String toString() { //Serve per sovrascrivere i dati inseriti
		return super.toString() + ", stipendio " + stipendio;
	}

}

package persona;

public class Dipendente extends Persona {

	private int stipendio;
	
	public Dipendente(int id, String nome, String cognome, int eta) {
		super(id, nome, cognome, eta);
	}
	
	//Settaggio stipendio Dipendente
	public void setStipendio(int Stipendio) {
		this.stipendio = Stipendio;
	}
	
	public int getStipendio() {
		return stipendio;
	}

	@Override 
	public String toString(){ //Override serve per sovrascrivere i dati inseriti 
		return super.toString() + ", Stipendio" + stipendio;
	}	
}

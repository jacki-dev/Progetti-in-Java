package persona;

//Nella creazione della classe persona faranno poi parte i costruttori della classe ed i suoi parametri 

public class Persona {                					//In questo modoa abbiamo creato i parametri dell'oggetto Persona che verranno poi richiamati
	//quando l'andremo ad utilizzare 

	//Parametri della classe persona 				
	protected int id;
	protected String nome;
	protected String cognome;
	protected int eta; 



	//Costruttore 	
	public  Persona(int id, String nome, String cognome, int eta) {

		this.id = id;
		this.eta = eta;
		this.nome = nome;
		this.cognome = cognome;
	}
	//METODI GET E SET PER I VARI PARAMETRI 

	//ID
	public int getId() {								//GET consente di leggere i parametri 
		return id;
	}
	public void setId(int id) {							//SET consente di modificare i parametri
		this.id = id;
	}

	//NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//COGNOME
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;

	}

	//ETA
	public int getEta() {
		return eta;
	}
	public void setEta (int eta) {
		this.eta = eta;
	}

	@Override 
	public String toString(){ 																		//Override serve per sovrascrivere i dati inseriti 
		return "Utente id = " + id + ", nome = " + nome + ", cognome = " + cognome + ", eta = " + eta;
	}																								//Restituisce una rappresentazione in formato stringa dell'oggetto e la rende leggibile


}


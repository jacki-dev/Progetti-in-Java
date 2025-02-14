package persona;

import java.util.Scanner; 				//questa serve per dare la possibilità all'utente di scrivere (attiva quindi l'utilizzo dello scanner
import java.util.List;					//questa libreria serve per importare la capacità di leggere gli Array
import java.util.ArrayList; 			//questa serve per la gestione delle liste di Array 


public class GestioneCRUD {

	//	private int id;
	//	private String nome;
	//	private String cognome;
	//	private int eta;

	private List <Persona> persone;
	Scanner scanner = new Scanner(System.in);

	public GestioneCRUD() {
		persone = new ArrayList<>();
		//Scanner scanner = new Scanner(System.in);
	}

	//Dopo aver creato i parametri di gestione del CRUD andiamo a dargli le indicazioni 

	public void aggiungiPersona() {														//Qui aggiungeremo i metodi per aggiungere una persona 

		//ID della persona
		System.out.println("Inserisci id persona");
		int id =scanner.nextInt();
		scanner.nextLine();	

		//Nome della persona
		System.out.println("Inserisci nome persona:");
		String nome = scanner.nextLine();

		//Cognome della persona
		System.out.println("Inserisci cognome persona:");
		String cognome = scanner.nextLine();

		//Eta della persona
		System.out.println("Inserisci eta della persona; ");
		int eta = scanner.nextInt();

		//Creazione del nuovo oggetto persona 
		Persona persona = new Persona (id ,nome, cognome, eta);


		//Fondamentale per dare l'istruzione su dove contenere i dati precedentemente inseriti.

		persone.add(persona);  //<--- da sinistra verso destra: persona oggetto creato, add è il comando di aggiunta (tramite il punto), persone è l'array dove verra aggiunto

		System.out.println("Utente registrato : " + persona);

		//Dopo aver registrato l'utente nella clsse "standard" persona, andiamo a chiedere all'utente se lo vuole registrare come Dipendete o come Amministratore





	}

	public void modificaPersona() {														//Qui aggiungeremo i metodi per modificare una persona
		System.out.println("Inserisci l'ID della persona da aggiornare:");				//Aggiornamento: apportare modifiche anche per i diversi ruoli
		int id = scanner.nextInt();

		Persona persona = null;
		for (Persona p : persone) {
			if (p.getId() == id) {
				persona = p;
				break;
			}
		}

		if (persona != null) {
			System.out.println("Persona trovata: " + persona);
			scanner.nextLine();  // Consuma la newline lasciata da nextInt()

			//Modifica del nome
			System.out.println("Inserisci il nuovo nome:");
			String nuovoNome = scanner.nextLine();

			//Modifica del cognome
			System.out.println("Inserisci il nuovo cognome:");
			String nuovoCognome = scanner.nextLine();

			//Modifica dell eta
			System.out.println("Inserisci la nuova età:");
			int nuovaEta = scanner.nextInt();

			//Salvataggio delle modifiche apportate 
			persona.setNome(nuovoNome);
			persona.setCognome(nuovoCognome);
			persona.setEta(nuovaEta);
			System.out.println("Persona aggiornata: " + persona);
		} else {
			System.out.println("Persona con ID " + id + " non trovata.");
		}
	}

	public void eliminaPersona() {
		System.out.println("Inserisci l'ID della persona da eliminare:");
		int id = scanner.nextInt();

		Persona persona = null;
		for (Persona p : persone) {
			if (p.getId() == id) {
				persona = p;
				break;
			}
		}

		if (persona != null) {
			persone.remove(persona);
			System.out.println("Persona eliminata: " + persona);
		} else {
			System.out.println("Persona con ID " + id + " non trovata.");
		}
	}

	public void ricercaPersona() {
		System.out.println("Inserisci l'ID della persona da cercare:");
		int id = scanner.nextInt();

		Persona persona = null;
		for (Persona p : persone) {
			if (p.getId() == id) {
				persona = p;
				break;
			}
		}

		if (persona != null) {
			System.out.println("Persona trovata: " + persona);
		} else {
			System.out.println("Persona con ID " + id + " non trovata.");
		}
	}

	public void stampaUtenti() {

		if (persone.isEmpty()) {
			System.out.println("Nessuna persona registrata.");


		} else {

			//assegnazione del booleano "continua" assegnato a true 
			boolean continua = true; 

			while (continua) {

				//Stampa del menù per far scegliere all'utente quale utente visualizzare
				System.out.println("Seleziona l'utente da visualizzare: ");
				System.out.println("1) Visualizza dipendente");
				System.out.println("2) Visualizza amministratore");
				System.out.println("3) Visualizza gli utenti");
				System.out.println("4) Esci");

				//Inizializzazione e assegnazione per anticipare la funzione switch
				String grado = scanner.nextLine();

				switch(grado) {

					//Visualizzare i dipendenti
				case "1":
					System.out.println("Dipendenti:");
					for (Persona p : persone) {
						if (p instanceof Dipendente) {
							System.out.println(p);
						}
					}
					break;

					//Visualizzare gli amministratori
				case "2":
					System.out.println("Amministratore");
					for (Persona p : persone) {
						if (p instanceof Amministratore) {
							System.out.println(p);
						}
					}
					break;

					//Visualizzare gli utenti normali 
				case "3":
					System.out.println("Utenti");
					for (Persona p : persone) {
					}
					System.out.println(persone);
					break;

					//Implemento funzione per uscire dal menù definendo il booleano inizializzato prima come false
				case "4":
					continua = false;
					break;

				default:
					System.out.println("Opzione non valida, scegli tra quelle disponibili: ");
				}
			}
		}
	}

	public void promuoviPersona() {

		boolean continua = true; //assegniamo una variabile booleana "continua" per far continuare il loop finchè è vera

		while (continua) {

			//Richiesta dell ID della persona da promuovere
			System.out.println("Seleziona l'ID della persona da promuovere: ");
			int id = scanner.nextInt();
			scanner.nextLine();


			Persona persona = null;
			//Metodo per cercare persona nell elenco
			for (Persona p : persone) {
				if (p.getId() == id) {
					persona = p;
					break;
				}
			}

			//Se la persona è trovata
			if (persona != null) {
				System.out.println("Vuoi promuovere l'utente: " + persona + "? (SI/NO)");
				String scelta = scanner.nextLine();

				if (scelta.equalsIgnoreCase("si")) {
					//Richiesta del grado di promozione
					System.out.println("Seleziona il grado di promozione: ");
					System.out.println("1) Promozione a dipendente");
					System.out.println("2) Promozione a manager");

					String grado = scanner.nextLine();


					switch (grado) {

					case "1":

						Dipendente dipendente = new Dipendente (persona.getId(), persona.getNome(), persona.getCognome(), persona.getEta());
						System.out.println("Attribuisci un nuovo stipendio: ");

						int stipendio = scanner.nextInt();

						if (stipendio >= 1300){
							dipendente.setStipendio(stipendio);
							System.out.println("Hai promosso " + dipendente + "e gli hai attribuito uno stipendio di: " + stipendio + " euro");

							//Andiamo a creare l'aggiornamento della classe con il count 
							for (int i = 0; i < persone.size(); i++) {
								if (persone.get(i).getId() == persona.getId()) {
									//sostituzione del vecchio oggetto con il nuovo
									persone.set(i, dipendente); 
								}
							}


						} else{
							System.out.println("Lo stipendio per un dipendente non può essere inferiore a €1300");
							System.out.println("L'utente " + persona + " non è stato promosso a dipendente!");
						}
						break;


					case "2":

						Amministratore amministratore = new Amministratore (persona.getId(), persona.getNome(), persona.getCognome(), persona.getEta());

						System.out.println("Attribuisci un nuovo stipendio: ");

						int newstipendio = scanner.nextInt();

						if (newstipendio >= ((Dipendente) persona).getStipendio()){ //??
							amministratore.setstipendio(newstipendio);
							System.out.println("Hai promosso " + amministratore + "e gli hai attribuito uno stipendio di: " + newstipendio + " euro");

							//Andiamo a creare l'aggiornamento della classe con il count 
							for (int i = 0; i < persone.size(); i++) {
								if(persone.get(i).getId()== persona.getId()) {
									//sostituzione del vecchio oggetto con il nuovo
									persone.set(i, amministratore);
								}
							}

						} else{
							System.out.println("Lo stipendio per un amministratore non può essere inferiore a €1500");
						}
						break;

					default:
						System.out.println("scelta non valida.");
						break;
					}
				} else {
					System.out.println("Promozione annullata.");				}

			} else {
				System.out.println("Persona con ID " + id + " non trovata.");
			} 

			//andiamo a chiedere all'utente se vuole effettuare altre promozioni:
			System.out.println("Vuoi effettuare un' altra promozione? SI/NO");
			String continuaScelta  = scanner.nextLine();
			if(continuaScelta.equalsIgnoreCase("no")) {
				continua = false; //esce dal loop
			}
		}
	}
}



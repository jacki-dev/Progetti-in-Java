package persona;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.ClassCastException;

public class Main {									//Andremo a richiamare i metodi della classe GestioneCrud, che a sua volta richiama i metodi della classe Persona

	public static void main (String[]args) {

		GestioneCRUD gestore = new GestioneCRUD();	//Questo lo utilizzeremo nello switch di sotto per andare a richiamare il metodo "aggiungi persona"
		//che si trova nella classe GestioneCrud
		Scanner scanner = new Scanner(System.in);
		boolean esci = false;

		while (!esci) {
			System.out.println("Seleziona un'opzione nel menù: ");
			System.out.println("1) Aggiungi utente: ");
			System.out.println("2) Modifica utente: ");
			System.out.println("3) Elimina utente: ");
			System.out.println("4) Ricerca utente tramite id: ");
			System.out.println("5) Stampa tutti gli utenti: ");
			System.out.println("6) Promuovi utenti: ");
			
			System.out.println("0) Esci dal menù e salva i dati.");

			try {



				int scelta = scanner.nextInt();

				switch(scelta) {

				case 1: 
					gestore.aggiungiPersona();			//Scrivendo in questo modo permettiamo di richiamare l'oggetto gestore precedentemente creato dalla classe
					break;								//Gestione Crud, mettendo il punto andiamo a richiamare anche il metodo creato prima sempre nella classe Gestione Crud

				case 2:
					gestore.modificaPersona();
					break;

				case 3:
					gestore.eliminaPersona();
					break;

				case 4:
					gestore.ricercaPersona();
					break;

				case 5:
					gestore.stampaUtenti();
					break;
				
				case 6:
					gestore.promuoviPersona();
					break;
				
				
				case 0:
					System.out.println("Modifiche apportate!");
					esci = true;  // Imposta la variabile esci su true per uscire dal ciclo
					break;

				default:
					System.out.println("Opzione non valida. Riprova.");
					break;

				}
			}catch (InputMismatchException e) {
				System.out.println("Errore: carattere non valido, inserisci un numero.");
				scanner.next();//Consuma il valore non valido
			}

		}

	}

}	

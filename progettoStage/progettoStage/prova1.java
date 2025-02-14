package progettoStage;

import java.util.*;
import java.sql.*;

public class prova1 {

    public static void main(String[] args) {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/jacopo_db";
        String USER = "root"; // root --> username default di XAMPP
        String PASS = ""; // blank --> password default di XAMPP

        try {
            // Caricamento del driver MySQL
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            // Creazione della tabella users se non esiste
            String query = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "name VARCHAR(255), "
                    + "surname VARCHAR(255), "
                    + "email VARCHAR(255), "
                    + "date DATE, "
                    + "PRIMARY KEY (id))";

            stmt.executeUpdate(query);

            // Scanner per input dell'utente
            Scanner scan = new Scanner(System.in);

            System.out.println("1. Aggiungi utente: ");
            System.out.println("2. Leggi utente: ");
            System.out.println("3. Aggiorna utente: ");
            System.out.println("4. Elimina utente: ");
            System.out.println("Seleziona un'opzione: ");
            String choice = scan.nextLine();

            switch (choice) {
                case "1":
                    // Aggiungi utente
                    System.out.print("Inserisci il nome utente: ");
                    String name = scan.nextLine();

                    System.out.print("Inserisci il cognome dell'utente: ");
                    String surname = scan.nextLine();

                    System.out.print("Inserisci l'email dell'utente: ");
                    String email = scan.nextLine();

                    System.out.print("Inserisci la data di nascita dell'utente (yyyy-mm-dd): ");
                    String date = scan.nextLine(); // inserisci la data nel formato yyyy-mm-dd

                    // Utilizza un PreparedStatement per prevenire SQL injection
                    String insertQuery = "INSERT INTO users (name, surname, email, date) "
                            + "VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                    pstmt.setString(1, name);
                    pstmt.setString(2, surname);
                    pstmt.setString(3, email);
                    pstmt.setString(4, date);  // Assumiamo che la data sia già nel formato corretto

                    pstmt.executeUpdate();

                    System.out.println("Dati inseriti con successo!");
                    break;

                case "2":
                    // Leggi utente
                    System.out.print("Inserisci user id: ");
                    int id = scan.nextInt();
                    scan.nextLine(); // Consuma la nuova linea rimasta dopo nextInt()

                    query = "SELECT * FROM users WHERE id = " + id;

                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Nome: " + rs.getString("name"));
                        System.out.println("Cognome: " + rs.getString("surname"));
                        System.out.println("Email: " + rs.getString("email"));
                        System.out.println("Data di nascita: " + rs.getDate("date"));
                    } else {
                        System.out.println("Utente non trovato!");
                    }
                    break;

                case "3":
                    // Aggiorna utente
                    System.out.print("Inserisci user id: ");
                    id = scan.nextInt();
                    scan.nextLine(); 
                    System.out.print("Inserisci nuovo nome utente: ");
                    name = scan.nextLine();

                    System.out.print("Inserisci nuovo cognome: ");
                    surname = scan.nextLine();

                    System.out.print("Inserisci nuova email dell'utente: ");
                    email = scan.nextLine();

                    System.out.print("Inserisci nuova data di nascita dell'utente (yyyy-mm-dd): ");
                    date = scan.nextLine();

                    String updateQuery = "UPDATE users SET name = ?, surname = ?, email = ?, date = ? WHERE id = ?";
                    PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery);
                    pstmtUpdate.setString(1, name);
                    pstmtUpdate.setString(2, surname);
                    pstmtUpdate.setString(3, email);
                    pstmtUpdate.setString(4, date);  // Assumiamo che la data sia già nel formato corretto
                    pstmtUpdate.setInt(5, id);

                    int result = pstmtUpdate.executeUpdate();

                    if (result > 0) {
                        System.out.println("Utente aggiornato con successo!");
                    } else {
                        System.out.println("Utente non trovato!");
                    }
                    break;

                case "4":
                    // Elimina utente
                    System.out.print("Inserisci user id: ");
                    id = scan.nextInt();
                    scan.nextLine(); // Consuma la nuova linea rimasta dopo nextInt()

                    String deleteQuery = "DELETE FROM users WHERE id = ?";
                    PreparedStatement pstmtDelete = conn.prepareStatement(deleteQuery);
                    pstmtDelete.setInt(1, id);

                    int deleteResult = pstmtDelete.executeUpdate();

                    if (deleteResult > 0) {
                        System.out.println("Utente eliminato con successo!");
                    } else {
                        System.out.println("Utente non trovato!");
                    }
                    break;

                default:
                    System.out.println("Opzione non valida!");
            }

            // Chiusura delle risorse
            stmt.close();
            conn.close();
            scan.close();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
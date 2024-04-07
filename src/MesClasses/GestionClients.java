package MesClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionClients {
    private Connection connexion;

    public GestionClients() {
        // Initialisation de la connexion à la base de données
        this.connexion = ConnexionDB.connectDB();
    }

    // Méthode pour ajouter un client à la base de données
    public void ajouterClient(Client client) {
        String requete = "INSERT INTO client (prenom, nom, adresse, numeroTelephone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connexion.prepareStatement(requete);
            statement.setString(1, client.getPrenom());
            statement.setString(2, client.getNom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getNumeroTelephone());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les clients à partir de la base de données
    public List<Client> recupererTousLesClients() {
        List<Client> clients = new ArrayList<>();
        String requete = "SELECT * FROM client";
        try {
            PreparedStatement statement = connexion.prepareStatement(requete);
            ResultSet resultat = statement.executeQuery();
            while (resultat.next()) {
                int clientID = resultat.getInt("clientID");
                String prenom = resultat.getString("prenom");
                String nom = resultat.getString("nom");
                String adresse = resultat.getString("adresse");
                String numeroTelephone = resultat.getString("numeroTelephone");
                Client client = new Client(clientID, prenom, nom, adresse, numeroTelephone);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}

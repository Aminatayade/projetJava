package MesClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionVentes {
    private Connection connexion;

    public GestionVentes() {
        // Initialisation de la connexion à la base de données
        this.connexion = ConnexionDB.connectDB();
    }

    // Méthode pour ajouter une vente à la base de données
    public void ajouterVente(Vente vente) {
        String requete = "INSERT INTO vente (clientID, dateVente, total,nomMedicamentVendu,quantiteVendue) VALUES (?, ?, ?,?,?)";
        try {
            PreparedStatement statement = connexion.prepareStatement(requete);
            statement.setInt(1, vente.getClientID());
            statement.setDate(2, vente.getDateVente());
            statement.setDouble(3, vente.getTotal());
            statement.setString(4, vente.getNomMedicamentVendu());
            statement.setInt(5, vente.getQuantiteVendue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les ventes à partir de la base de données
    public List<Vente> recupererToutesLesVentes() {
        List<Vente> ventes = new ArrayList<>();
        String requete = "SELECT * FROM vente";
        try {
            PreparedStatement statement = connexion.prepareStatement(requete);
            ResultSet resultat = statement.executeQuery();
            while (resultat.next()) {
                int venteID = resultat.getInt("venteID");
                int clientID = resultat.getInt("clientID");
                java.sql.Date dateVente = resultat.getDate("dateVente");
                double total = resultat.getDouble("total");
                String nomMedicamentVendu = resultat.getString("nomMedicamentVendu");
                int quantiteVendue = resultat.getInt("quantiteVendue");
                Vente vente = new Vente(venteID, clientID, dateVente, total,nomMedicamentVendu,quantiteVendue);
                ventes.add(vente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventes;
    }
}

package MesClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionDetailsVente {
    private Connection connexion;

    public GestionDetailsVente() {
        // Initialisation de la connexion à la base de données
        this.connexion = ConnexionDB.connectDB();
    }

    // Méthode pour ajouter un détail de vente à la base de données
    public void ajouterDetailVente(DetailVente detailVente) {
        String requete = "INSERT INTO detailsvente ( medicamentID, quantite, prixVente) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connexion.prepareStatement(requete);
            statement.setInt(1, detailVente.getVenteID());
            statement.setInt(2, detailVente.getMedicamentID()); // Utilisation de medicamentID à la place de produitID
            statement.setInt(3, detailVente.getQuantite());
            statement.setDouble(4, detailVente.getPrixVente()); // Utilisation de prixVente à la place de prixUnitaire
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

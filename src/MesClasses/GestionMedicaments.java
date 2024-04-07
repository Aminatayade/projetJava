package MesClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionMedicaments {

    public void ajouterMedicament(Medicament medicament) {
        String query = "INSERT INTO Medicaments (nom, description, prix, quantiteEnStock) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnexionDB.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, medicament.getNom());
            pstmt.setString(2, medicament.getDescription());
            pstmt.setDouble(3, medicament.getPrix());
            pstmt.setInt(4, medicament.getQuantiteEnStock());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerMedicament(int medicamentId) {
        String query = "DELETE FROM Medicaments WHERE medicamentID = ?";

        try (Connection conn = ConnexionDB.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, medicamentId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("Aucun médicament trouvé avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du médicament : " + e.getMessage());
        }
    }

    public void vendreMedicament(Vente vente) {
        String requete = "UPDATE Medicaments SET quantiteEnStock = quantiteEnStock - ? WHERE nom = ?";
        try (Connection conn = ConnexionDB.connectDB();
             PreparedStatement statement = conn.prepareStatement(requete)) {
            statement.setInt(1, vente.getQuantiteVendue());
            statement.setString(2, vente.getNomMedicamentVendu());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

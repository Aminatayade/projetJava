package MesClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GestionFournisseurs {

    public void ajouterFournisseur(Fournisseur fournisseur) {
        String query = "INSERT INTO Fournisseurs (nom,adresse,telephone) VALUES (?, ?,?)";

        try (Connection conn = ConnexionDB.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, fournisseur.getNom());
            pstmt.setString(2, fournisseur.getAdresse());
            pstmt.setString(3, fournisseur.getTelephone());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerFournisseur(int fournisseursID) {
        String query = "DELETE FROM fournisseurs WHERE fournisseursID = ?";
    
        try (Connection conn = ConnexionDB.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, fournisseursID);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("Aucun fournisseur trouvé avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du fournisseur : " + e.getMessage());
        }
    }
}

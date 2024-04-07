

    
package MesClasses;

public class Medicament {
    private String nom;
    private String description;
    private double prix;
    private int quantiteEnStock;

    public Medicament(String nom, String description, double prix, int quantiteEnStock) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
    }

    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }
}


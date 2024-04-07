package MesClasses;

public class DetailVente {
    private int detailsVenteID;
    private int venteID;
    private int medicamentID;
    private int quantite;
    private double prixVente;

    public DetailVente(int detailsVenteID, int venteID, int medicamentID, int quantite, double prixVente) {
        this.detailsVenteID = detailsVenteID;
        this.venteID = venteID;
        this.medicamentID = medicamentID;
        this.quantite = quantite;
        this.prixVente = prixVente;
    }
    public DetailVente( int venteID, int medicamentID, int quantite, double prixVente) {
        //this.detailsVenteID = detailsVenteID;
        this.venteID = venteID;
        this.medicamentID = medicamentID;
        this.quantite = quantite;
        this.prixVente = prixVente;
    }

    public int getMedicamentID() {return medicamentID;}
    public void setMedicamentID(int medicamentID) {this.medicamentID = medicamentID;}
    public int getQuantite() {return quantite;}
    public void setQuantite(int quantite) {this.quantite = quantite;}
    public double getPrixVente() {return prixVente;}
    public void setPrixVente(double prixVente) {this.prixVente = prixVente;}
    public int getVenteID() {return venteID;}
    public void setVenteID(int venteID) {this.venteID = venteID;}
    public int getDetailsVenteID() {return detailsVenteID;}
    public void setDetailsVenteID(int detailsVenteID) {this.detailsVenteID = detailsVenteID;}

}

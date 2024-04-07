package MesClasses;

import java.sql.Date;

public class Vente {
    private int venteID;
    private int clientID;
    private Date dateVente;
    private String nomMedicamentVendu; 
    private int quantiteVendue;
    private double total;

    public Vente(int venteID, int clientID, Date dateVente, double total,String nomMedicamentVendu,int quantiteVendue) {
        this.venteID = venteID;
        this.clientID = clientID;
        this.dateVente = dateVente;
        this.nomMedicamentVendu=nomMedicamentVendu;
        this.quantiteVendue=quantiteVendue;
        this.total = total;
    }
    public Vente( int clientID, Date dateVente, double total,String nomMedicamentVendu,int quantiteVendue) {
        
        this.clientID = clientID;
        this.dateVente = dateVente;
        this.nomMedicamentVendu=nomMedicamentVendu;
        this.quantiteVendue=quantiteVendue;
        this.total = total;
    }

    // Getters et setters
    public int getVenteID() {
        return venteID;
    }

    public void setVenteID(int venteID) {
        this.venteID = venteID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public String getNomMedicamentVendu() {
        return nomMedicamentVendu;
    }
    public void setNomMedicamentVendu(String nomMedicamentVendu) {
        this.nomMedicamentVendu = nomMedicamentVendu;
    }
    public int getQuantiteVendue() {
        return quantiteVendue;
    }
    public void setQuantiteVendue(int quantiteVendue) {
        this.quantiteVendue = quantiteVendue;
    }
}

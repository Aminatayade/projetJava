package MesClasses;

public class Client {
    private int clientID;
    private String prenom;
    private String nom;
    private String adresse;
    private String numeroTelephone;
   // private String email;

    // Constructeur, getters et setters
    public Client(int clientID, String prenom, String nom, String adresse,String numeroTelephone){
        this.clientID = clientID;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getNumeroTelephone() {
        return numeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

}

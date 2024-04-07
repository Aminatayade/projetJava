package MesClasses;

public class Fournisseur {
    private int fournisseurId;
    private String nom;
    private String adresse;
   private String telephone;

    public Fournisseur(int fournisseurId, String nom, String adresse,String telephone) {
        this.fournisseurId = fournisseurId;
        this.nom = nom;
        this.adresse = adresse;
      this.telephone = telephone;
    }
    public Fournisseur(String nom,String adresse,String telephone) {
        // ID n'est pas inclus ici, car il est généré automatiquement
        this.nom = nom;
       
        this.adresse = adresse;
        this.telephone=telephone;

    }

    
    public int getFournisseurId(){
        return fournisseurId;
    }
    public void setFournisseurId(int  fournisseurId) {
        this.fournisseurId = fournisseurId;

    }
    public String getNom(){
        return nom;
    }
    public void setNom(String  nom) {
        this.nom = nom;

    }
    public String getAdresse(){
            return adresse;
        }
    public void setAdresse(String adresse) {
        this.adresse=adresse;
     }
    public String getTelephone()
    {return telephone;} 
    public void setTelephone(String telephone)
    {this.telephone=telephone;}
    

}

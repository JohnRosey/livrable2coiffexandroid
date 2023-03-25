package ca.dmi.uqtr.coiffex3.modele;


public class Modele {

    private String nom;
    private double prix;
    private String img;

    public Modele(String nom, double prix, String img) {
        this.nom = nom;
        this.prix = prix;
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
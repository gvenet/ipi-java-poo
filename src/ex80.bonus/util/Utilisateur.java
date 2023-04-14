package util;


public class Utilisateur {

  private int id;
  private String nom;
  private String prenom;

  public Utilisateur(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public int getId() {
    return this.id;
  }

  public String getNom() {
    return this.nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public void display() {
    System.out.println(this.id + "   " + this.prenom + " " + this.nom);
  }

}

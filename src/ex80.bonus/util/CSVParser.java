package util;

import java.io.*;
import java.util.*;

public class CSVParser {

  private List<String[]> datas = new ArrayList<String[]>();
  List<Utilisateur> users = new ArrayList<Utilisateur>();
  List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();

  
  
  public void parse() {
    try {
      Scanner sc = new Scanner(new File("./datas/comptes.csv"));
      sc.next();
      while (sc.hasNext()) {
        // On fabrique un pojo data, j'aurais pu faire en json mais je ne vois pas l'utilitée de sérialiser/désérialiser
        this.datas.add(sc.next().split(","));
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    this.datas.forEach(data -> {
        try {
          if (data.length != 6) {
            throw new Exception("Le nombre de colonne n'est pas respécté");
          }
          int idCB = Integer.parseInt(data[0]);
          int soldeCB = Integer.parseInt(data[1]);
          int decouvertAutoriseCB = Integer.parseInt(data[2]);
          int idUSR = Integer.parseInt(data[3]);
          String nomUSR = data[4];
          String prenomUSR = data[5];

          // sert à éviter les doublons d'utilisateur
          if (!usersContains(idUSR)) {
            users.add(new Utilisateur(idUSR, nomUSR, prenomUSR));
          }

          //ici on utilise getUserById pour récupérer la réference de l'instanciation déjà créée auparavant. 
          //(on passe pas par new Utilisateur car on veut 1 seule instanciation par utilisateur)
          comptes.add(
            new CompteBancaire(
              idCB,
              getUserById(idUSR),
              soldeCB,
              decouvertAutoriseCB
            )
          );
        } catch (Exception e) {
          System.out.println("Erreur de parsing : " + e);
        }
      });
  }

  /*
   * l'idée ici aurait été de créer un nouveau fichier pour une MAJ du fichier, et ainsi créer un base de donnée rudimentaire
   */
  public void export() {
    //met à jour le fichier csv
  }

  public List<Utilisateur> getUsers() {
    return this.users;
  }

  public List<CompteBancaire> getComptes() {
    return this.comptes;
  }

  private Utilisateur getUserById(int idUSR) {
    return users.stream().filter(user -> user.getId() == idUSR).findAny().get();
  }

  private boolean usersContains(int userId) {
    boolean containsUser = false;
    for (Utilisateur user : this.users) {
      if (user.getId() == userId) {
        containsUser = true;
      }
    }
    return containsUser;
  }

}

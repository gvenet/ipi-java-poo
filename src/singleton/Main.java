import util.*;

public class Main {

  /*
   * ici, on declare 2 singleton, mais puisqu'un premier avec "lol" est déclaré avant on récupère celui ci lors de la deuxieme instanciation.
   * getInstance doit retourner 2 fois "lol"
   */
  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance("lol");
    Singleton anotherSingleton = Singleton.getInstance("coucou");
    System.out.println(singleton.value);
    System.out.println(anotherSingleton.value);
  }
}

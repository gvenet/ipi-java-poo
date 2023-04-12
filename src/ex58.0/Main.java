import java.io.*;
import java.util.*;

class Main {

  public static String parse() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter a phrase (q to exit)");
    return sc.nextLine();
  }

  public static void main(String[] args) {
    while (true) {
      String str = parse();
      int wordsCount = 0;
      if (str.equals("q")) {
        System.exit(0);
      } else if (!str.equals("")) {
        wordsCount = str.split(" ").length;
      }
      System.out.println("The phrase contains " + wordsCount + " words") ;
    }
  }
}

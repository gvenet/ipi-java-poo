import java.io.*;
import java.util.*;
import util.*;

public class Main {

  public static int parse() {
    int number;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("Please enter a positive number!");
      while (!sc.hasNextInt()) {
        System.out.println("That's not a number!");
        sc.next();
      }
      number = sc.nextInt();
    } while (number <= 0);
    return number;
  }

  public static void main(String[] args) {
    int toFind = new GenerateRandom(100).get();
    int count = 0;

    System.out.println("Find the number under 10 tries");
    while (count < 10) {
      int userNumber = parse();
      if (userNumber > toFind) {
        System.out.println("smaller");
        count++;
      } else if (userNumber < toFind) {
        System.out.println("bigger");
        count++;
      } else {
        break;
      }
      System.out.println("count = " + count);
    }

    if (count < 10) {
      System.out.println("Winner");
    } else {
      System.out.println("You loose");
    }
  }
}

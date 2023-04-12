import java.io.*;
import java.util.*;

class Main {

  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number;
    while (true) {
      do {
        System.out.println("Please enter a positive number!");
        while (!sc.hasNextInt()) {
          System.out.println("That's not a number!");
          sc.next();
        }
        number = sc.nextInt();
      } while (number <= 0);

      if (number % 2 == 0) {
        System.out.println(number + " is an even number");
      } 
      else if (number % 2 != 0) {
        System.out.println(number + " is an odd number");
      }

      if (isPrime(number)) {
        System.out.println(number + " is prime");
      }


    }
  }
}

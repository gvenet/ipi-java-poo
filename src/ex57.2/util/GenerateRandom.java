package util;
import java.util.Random;

public class GenerateRandom {

  private int randomNumber;

  public GenerateRandom(int upperbound) {
    Random rand = new Random();
    this.randomNumber = rand.nextInt(upperbound);
  }

  public int get() {
    return this.randomNumber;
  }
}

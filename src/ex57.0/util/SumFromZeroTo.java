package util;

public class SumFromZeroTo {

  private int sum;

  public SumFromZeroTo(int x) {
    for (int i = 0; i < x; i++) {
      this.sum += i;
    }
  }

  public void display() {
      System.out.println(this.sum);
  }

}

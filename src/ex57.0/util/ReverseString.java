package util;

public class ReverseString {

  private String out = new String();

  public ReverseString(String str) {
    this.out += new StringBuilder(str).reverse().toString();
  }

  public void display() {
      System.out.println(this.out);
  }

}

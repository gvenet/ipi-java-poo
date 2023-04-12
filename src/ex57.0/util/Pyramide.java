package util;

public class Pyramide {

  private String out = new String();

  public static String createStr(String c, int x) {
    return new String(new char[x]).replace("\0", c);
  }

  public Pyramide(String c, int h) {
    for (int i = 0; i < h; i++) {
      this.out += createStr(" ", (h-i)-1) + createStr(c, ((i+1)*2)-1) + "\n";
    }
  }

  public void display() {
      System.out.println(this.out);
  }

}

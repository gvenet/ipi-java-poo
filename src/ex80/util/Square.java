package util;

public class Square extends Rectangle{
  public Square(Integer y, Integer x) {
   super(y,x);
  }

  public void sqrt() {
   System.out.println(this.getY() * this.getX());
  }
}
package util;

public class Rectangle {
   private Integer x;
   private Integer y;
  
   public Rectangle(Integer y, Integer x) {
      this.y = y;
      this.x = x;
   }

   public void display() {
      for (Integer j = 0; j < this.y; j++) {
         System.out.println(new String(new char[this.x]).replace("\0", "#"));
      }
   }

   public Integer getX() {
      return this.x;
   }

   public Integer getY() {
      return this.y;
   }

   public void SetX(Integer x) {
      this.x = x;
   }

   public void SetY(Integer x) {
      this.y = y;
   }
}
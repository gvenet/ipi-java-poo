package util;

public class User {
   private String _username;
   private Integer _age;
  
   public User(String username, Integer age) {
      this._username = username;
      this._age = age;
   }

   public void showUser() {
      System.out.println("username : " + _username + " age : " + _age);
   }
}
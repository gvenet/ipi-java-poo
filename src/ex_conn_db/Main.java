import java.util.*;
import util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    CRUD service = new CRUD();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println(
        "Menu : 0-exit | 1-display | 2-create | 3-update | 4-delete"
      );
      String menu = sc.next();

      switch (menu) {
        case "0":
          service.close();
          System.exit(0);
          break;
        case "1":
          service.read();
          break;
        case "2":
          System.out.print("Enter a name : ");
          service.create(sc.next());
          break;
        case "3":
          System.out.print("Select id : ");
          int id = sc.nextInt();
          System.out.print("Enter name : ");
          String name = sc.next();
          service.update(id, name);
          break;
        case "4":
          System.out.print("Select id : ");
          service.delete(sc.nextInt());
          break;
        default:
          System.out.println("Wrong input");
      }
    }
  }
}

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

  public static String parse() {
    Scanner sc = new Scanner(System.in);
    System.out.println(
      "Please enter the file path, for example : ./example.txt"
    );
    return sc.nextLine();
  }

  public static void main(String[] args) throws IOException {
    
    File file = new File("../ex58.2");

    while(!file.exists() || file.isDirectory()) { 
      file = new File(parse());
    }

    BufferedReader br = new BufferedReader(new FileReader(file));

    String st;
    String text = new String();
    while ((st = br.readLine()) != null) {
      System.out.println(st);
      text += st + " ";
    }
    System.out.println(text.split(" ").length);
  }
}

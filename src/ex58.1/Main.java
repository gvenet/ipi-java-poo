import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Main {

  public static String parse() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter a phrase");
    return sc.nextLine();
  }

  public static void main(String[] args) throws IOException {
    String str = parse();
    File path = new File("./file.txt");

    FileWriter wr = new FileWriter(path);
    wr.write(str);
    wr.flush();
    wr.close();
  }
}

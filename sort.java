import java.io.*;
import java.net.*;
import java.util.*;

class Sort {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String sort_type = get_sort(scan);
    System.out.println("You chose " + sort_type + " Sort");
    System.out.println("Generating data files");
    try {
      File data_file = generate_data();
    }
    catch (IOException j) {
      j.printStackTrace();
    }
    

  }

  public static String get_sort(Scanner scan) {
    System.out.println("Choose a sorting method");
    String method = scan.nextLine();
    return method;
  }

  public static String get_data(Scanner scan) {
    System.out.println("What type of data would you like to sort?");
    String data = scan.nextLine();
    scan.close();
    return data;
  }

  public static File generate_data() throws IOException{
    File file = new File(String.format("best_case.txt"));
    file.createNewFile();
    FileWriter filenes = new FileWriter(file);
    for (int i=1; i <= 2000; i++) {
      filenes.write(i + "\n");
    }
    filenes.flush();
    filenes.close();
    File average = new File(String.format("average_case.txt"));
    average.createNewFile();
    FileWriter filene = new FileWriter(average);
    Random rn = new Random();
    for (int i=1; i <= 2000; i++) {
      int num = rn.nextInt((2000 - 1) + 1) + 1;
      filene.write(num + "\n");
    }
    filene.flush();
    filene.close();
    File worst = new File(String.format("worst_case.txt"));
    worst.createNewFile();
    FileWriter writer = new FileWriter(worst);
    for (int i=2000; i > 0; i--) {
      writer.write(i + "\n");
    }
    writer.flush();
    writer.close();
    return file;
  }


}

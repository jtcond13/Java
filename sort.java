import java.io.*;
import java.net.*;
import java.util.Scanner;

class Sort {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String sort_type = get_sort(scan);
    System.out.println("You chose " + sort_type + " Sort");
    String data_type = get_data(scan);
    System.out.println("Generating a " + data_type + " data file");
    try {
      File data_file = generate_data(data_type);
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

  public static File generate_data(String datatype) throws IOException{
    File file = new File(String.format("%sdata_file.txt", datatype));
    file.createNewFile();
    FileWriter filenes = new FileWriter(file);
    filenes.write("1\n2\n3\n");
    filenes.flush();
    filenes.close();
    return file;
  }


}

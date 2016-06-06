import java.io.*;
import java.net.*;
import java.util.*;


class sort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    String sort_type = get_sort(scan);
    System.out.println("Generating data files");
    String input_path;

    try {
      File best = generate_best();
      File worst = generate_worst();
      File average = generate_average();  
    }
    catch (IOException j) {
      j.printStackTrace();
    } 
		System.out.print ("Enter the pathname of the input file: ");
		System.out.flush();
    input_path = scan.nextLine();
    Scanner inputFile = null;
    try {
     inputFile = new Scanner(new File(input_path));
  	}
  	catch (FileNotFoundException f) {
  		f.printStackTrace();
  	}
		int[] numbers = new int[2000];
		
		for (int i=0;i<2000;i++) {
			numbers[i] = inputFile.nextInt();
		}
		if (sort_type.equals("A")) {
			insertionSort(numbers);
		}
		else if (sort_type.equals("B")) {
			bubbleSort(numbers);
		}
		else {
			selectionSort(numbers);
		}
		
		
	}
		
	public static void bubbleSort(int[] list) {
    int comps = 0;
    int exchanges = 0;
    for(int i = 0; i < list.length - 1; i++) {
      for(int j = i + 1; j < list.length; j++) {
        
        comps++;
        if(list[i] > list[j]) {
          
          int temp = list[j];
          list[j] = list[i];
          list[i] = temp;
          exchanges++;
        }
      }
    }
   System.out.println("Comparisons: " + comps 
                         + " Exchanges: " + exchanges + " Sorted array: " + Arrays.toString(list)); 
  }    

	public static void insertionSort(int[] a) {
		int exchanges = 0;
		int comparisons = 0;
		for(int i=1;i<a.length;i++) {
			int current = a[i];
			int j = i ;
			while (j > 0 && a[j-1] >= current) {
         a[j] = a[j-1];
         comparisons++;
         exchanges++;
         j = j - 1;
       }
      comparisons++;
    	a[j] = current;
		}
		System.out.println("Sorting completed.  There were " + exchanges + " exchanges and " + comparisons + " comparisons.  Sorted Array: " + Arrays.toString(a));
	}
		
	public static void selectionSort(int[] a) {
		int exchanges = 0;
		int comparisons = 0;
		for(int i=0;i<a.length-1;i++) {
			int min = i;
			for (int j=i+1;j<a.length;j++) {
				comparisons++;
				if (a[j] < a[min]) {
					min = j;	
				}		
			}
			exchanges++;
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
 			}
			
		System.out.println("There were " + exchanges + " exchanges made and " + comparisons + "comparisons.  Sorted Array: " + Arrays.toString(a));
	}
		
	
	public static File generate_best() throws IOException{
    File file = new File(String.format("best_case.txt"));
    file.createNewFile();
    FileWriter filenes = new FileWriter(file);
    for (int i=1; i <= 2000; i++) {
      filenes.write(i + "\n");
    }
    filenes.flush();
    filenes.close();
    return file;
   }
   
   public static File generate_average() throws IOException {
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
   
    return average;
  }
  
  
  	public static File generate_worst() throws IOException {
    File worst = new File(String.format("worst_case.txt"));
    worst.createNewFile();
    FileWriter writer = new FileWriter(worst);
    for (int i=2000; i >= 1; i--) {
      writer.write(i + "\n");
    }
    writer.flush();
    writer.close();
    return worst;

 }

	
  public static String get_sort(Scanner scan) {
    System.out.println("Please prses A for insertion sort, B for bubble sort or C for selection sort");
    String method = scan.nextLine();
    String n = method.toUpperCase();
    return n;
  }
	
}
			

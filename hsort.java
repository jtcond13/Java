import java.io.*;
import java.net.*;
import java.util.*;




class hsort {
	private static int mergeComps;
	private static int mergeSwaps;
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
		else if (sort_type.equals("C")){
			selectionSort(numbers);
		}
		else if (sort_type.equals("D")){
			shellSort(numbers);
		}
		else if (sort_type.equals("E")){
			mergeComps = 0;
			mergeSwaps = 0;
			mergeSort(numbers);
			System.out.println("Sorted Array" + Arrays.toString(numbers));
			System.out.println("Swaps: " + mergeSwaps + "Comps: " + mergeComps);
		}
		else {
			heapSort(numbers);
		}
	}

		public static void heapSort(int nums[]) {
			Heap myHeap = new Heap(nums.length-1);
			for(int i=0;i<nums.length-1;i++) {
				myHeap.insert(nums[i]);
			}
			myHeap.displayHeap();
			for(int j=myHeap.currentSize-1; j>=0; j--)
       {
         Node biggestNode = myHeap.remove();
         myHeap.insertAt(j, biggestNode);
      }
			myHeap.displayHeap();
			System.out.println("Swaps: " + myHeap.heapSwaps);
			System.out.println("Comps: " + myHeap.heapComps);
		}

		public static void mergeSort(int arr[]) {
			int[] tmp = new int[arr.length];
			mergeSort(arr, tmp, 0, arr.length-1);
		}

		public static void mergeSort(int a[], int[] tmp, int lo, int hi) {
			if(lo == hi) {
				return;
			}
			else
				{
					int mid = (lo+hi) / 2;
					mergeSort(a, tmp, lo, mid);
					mergeSort(a, tmp, mid+1, hi);
					merge(a, tmp, lo, mid+1, hi);
				}
		}

		public static void merge(int[] arr, int[] temp, int lowPtr, int highPtr, int upperBound) {
			int j = 0;
			int lowerBound = lowPtr;
			int mid = highPtr - 1;
			int n = upperBound - lowerBound + 1;

			while(lowPtr <= mid && highPtr <= upperBound) {
				mergeComps++;
				if (arr[lowPtr] < arr[highPtr]) {
					mergeSwaps++;
					temp[j++] = arr[lowPtr++];
				}
				else {
					mergeSwaps++;
					temp[j++] = arr[highPtr++];
				}
			}

			while(lowPtr <=mid) {
				mergeSwaps++;
				temp[j++] = arr[lowPtr++];
			}

			while(highPtr <= upperBound) {
				mergeSwaps++;
				temp[j++] = arr[highPtr++];
			}

			for(j=0; j<n; j++) {
				arr[lowerBound+j] = temp[j];
				mergeSwaps++;
			}

		}

		public static void shellSort(int[] a) {
			int inner, outer, temp;
			int comparisons = 0;
			int exchanges = 0;
			int h = a.length;
			while(h <= a.length/3)
				h = h*3 + 1;

			while(h>0)
				{
					for(outer=h; outer<a.length; outer++)
						{
							temp = a[outer];
							inner = outer;
							while(inner > h - 1 && a[inner-h] >= temp)
								{
									a[inner] = a[inner-h];
									inner -= h;
									comparisons++;
									exchanges++;
								}
							comparisons++;
							a[inner] = temp;
						}
						h = (h - 1) / 3;
				}
			System.out.println("There were " + comparisons + " comparisons and " + exchanges + " exchanges. Sorted array: " + Arrays.toString(a));
		}

	public static void bubbleSort(int[] list) {
    int comps = 0;
    int exchanges = 0;

    for(int i = 1; i != list.length; i++) {
    	boolean cont = true;
    	if (cont) {
    		cont = false;
      for(int j = 0; j != list.length - i; j++) {
        if(list[j] > list[j+1]) {
          int temp = list[j];
          list[j] = list[j+1];
          list[j+1] = temp;
          exchanges++;
          comps++;
          cont = true;
        }
      }
     }
     else {
     	break;
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
    System.out.println("Please press A for insertion sort, B for bubble sort, C for selection sort, D for shell sort, E for merge sort or F for heap sort." );
    String method = scan.nextLine();
    String n = method.toUpperCase();
    return n;
  }

}


class Node
   {
   private int iData;
   public Node(int key)
      { iData = key; }
   public int getKey()
      { return iData; }
   public void setKey(int id)
      { iData = id; }
   }
class Heap
   {
	 public Node[] heapArray;
   private int maxSize;
	 public int currentSize;
	 public int heapSwaps;
	 public int heapComps;

public Heap(int mx)
	 {
	 maxSize = mx;
	 currentSize = 0;
	 heapSwaps = 0;
	 heapComps = 0;
	 heapArray = new Node[maxSize];
	 }

public boolean isEmpty()
	 { return currentSize==0; }
public boolean insert(int key)
	 {
	 if(currentSize==maxSize)
			return false;
	 Node newNode = new Node(key);
	 heapArray[currentSize] = newNode;
	 upHeap(currentSize++);
	 return true;
	 }
public void upHeap(int index)
	 {
	 int parent = (index-1) / 2;
	 Node bottom = heapArray[index];

	 while( index > 0 &&
					heapArray[parent].getKey() < bottom.getKey() )
			{
			heapArray[index] = heapArray[parent];  // move it down
			index = parent;
			parent = (parent-1) / 2;
			}
	 heapArray[index] = bottom;
	 }

// public void heapify(int index, int length){
// 	if(index > length/2-1){
// 		return;
// 	}
// 	heapify(index*2+2);
// 	heapify(index*2+1);
// 	downHeap(index);
// }
public Node remove()
	 {
	 Node root = heapArray[0];
	 heapArray[0] = heapArray[--currentSize];
	 downHeap(0);
	 return root;
	 }
public void downHeap(int index)
	 {
	 int largerChild;
	 Node top = heapArray[index];
	 while(index < currentSize/2)
			{
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			heapComps++;																// find larger child
			if(rightChild < currentSize &&  // (rightChild exists?)
													heapArray[leftChild].getKey() <
													heapArray[rightChild].getKey())
				 largerChild = rightChild;
			else
				 largerChild = leftChild;

																			// top >= largerChild?
			if( top.getKey() >= heapArray[largerChild].getKey() )
				 break;
																			// shift child up
			heapArray[index] = heapArray[largerChild];
			heapSwaps++;
			index = largerChild;            // go down
			}
	 heapArray[index] = top;            // root to index
	 heapSwaps++;
	 }
public boolean change(int index, int newValue)
	 {
	 if(index<0 || index>=currentSize)
			return false;
	 int oldValue = heapArray[index].getKey();
	 heapArray[index].setKey(newValue);

	 if(oldValue < newValue)
			upHeap(index);
	 else
			downHeap(index);
	 return true;
	 }
	 public void displayHeap()
				{
       for(int j=0; j<maxSize; j++)
          System.out.print(heapArray[j].getKey() + " ");
       System.out.println("");

       }
		public void insertAt(int index, Node newNode)
			   { heapArray[index] = newNode; }
}

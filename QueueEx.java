// The Queue ADT -- an array implementation with 
// exceptions

import java.io.*;

public interface QueueEx {

   public void enqueue (int item) throws QueueFullException;
   public int dequeue() throws QueueEmptyException;
   public int size();
   public boolean empty();
   public boolean full();
   public int front() throws QueueEmptyException;

}

class QueueEmptyException extends Exception {

   public QueueEmptyException (String message) {
     System.out.println (message);
   }
}

class QueueFullException extends Exception {

   public QueueFullException (String message) {
     System.out.println (message);
   }
}

class QueueADTEx implements QueueEx {

   final int MAXSIZE = 100;
   private int size;
   private int[] queueADT;
   private int front = 0;
   private int rear = -1;

   public QueueADTEx () {
     size = MAXSIZE;
     queueADT = new int[size];
   }

  public QueueADTEx (int inputsize) {
     size = inputsize;
     queueADT = new int[size];
   }

   public boolean empty () {
     return (rear < front);
   }

   public boolean full () {  
     return (rear == size - 1);
   }

   public void enqueue (int number) throws QueueFullException {
     if (full())
        throw new QueueFullException ("The queue is full.");
     rear++;
     queueADT[rear] = number;
   }

   public int dequeue () throws QueueEmptyException {
     if (empty())
        throw new QueueEmptyException ("The queue is empty.");
     int i = queueADT[front];
     front++;
     return i;
   }

   public int front () throws QueueEmptyException {
     if (empty())
        throw new QueueEmptyException ("The queue is empty.");
     return queueADT[front];
   }

   public int size () {
     if (rear == front)
       return 1;
     else
       return (rear + 1 - front);
   }
}

class QueueApplEx {

   public static void main (String[] args) throws IOException {

     BufferedReader stdin = new BufferedReader 
            (new InputStreamReader(System.in));

     System.out.print ("Enter queue size: ");
     System.out.flush();
     int size = Integer.parseInt(stdin.readLine());

     QueueADTEx queue = new QueueADTEx (size);

     int i = 2;

     // tries for two exceptions, QueueFullException and 
     // QueueEmptyException 

     try {
       for (int j = 1; j <= 7; j++) {
          queue.enqueue(i);
          System.out.println (queue.front() + " is the front item.");
          i = i + 2;
       }
     }
     catch (QueueFullException e) {
         System.out.println ("The queue is full.");
     }
     catch (QueueEmptyException e) {
         System.out.println ("The queue is empty.");
     }

     System.out.println ("The current queue contains " + queue.size() +
             " elements.");

     try {
       for (int j = 1; j <= 7; j++) {
          System.out.println (queue.dequeue() + " dequeued");
       }
     }
     catch (QueueEmptyException e) {
         System.out.println ("The queue is empty.");
     }

   }
}


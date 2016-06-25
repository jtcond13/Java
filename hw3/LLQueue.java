// The Queue ADT -- linked list implementation

import java.io.*;

public interface LLQueue {

   public void enqueue (String item);
   public String dequeue();
   public int size();
   public boolean empty();
   public String front();

}

class Node {

   private String data;
   private Node next;

   public Node () {
     this("0", null);
   }

   public Node (String d) {
     data = d;
   }

   public Node (String d, Node n) {
     data = d;
     next = n;
   }

   public void setData (String newData) {
     data = newData;
   }

   public void setNext (Node newNext) {
     next = newNext;
   }

   public String getData () {
     return data;
   }

   public Node getNext () {
      return next;
   }

   public void displayNode () {
      System.out.print (data);
   }
}

class LLQueueADT implements LLQueue {

   private int size;
   private Node front;
   private Node rear;

   public LLQueueADT () {
     size = 0;
     front = null;
     rear = null;
   }

   public boolean empty () {
     return (size == 0);
   }

   public void enqueue (String number) {
     Node newNode = new Node ();
     newNode.setData(number);
     newNode.setNext(null);
     if (this.empty())
       front = newNode;
     else
       rear.setNext(newNode);
     rear = newNode;
     size++;
   }

   public String dequeue () {
     String i;
     i = front.getData();
     front = front.getNext();
     size--;
     if (this.empty())
        rear = null;
     return i;
   }

   public String front () {
     return front.getData();
   }

   public int size () {
      return size;
   }
}

// class LLQueueAppl {
//
//    public static void main (String[] args) throws IOException {
//
//      BufferedReader stdin = new BufferedReader
//             (new InputStreamReader(System.in));
//
//      LLQueueADT queue = new LLQueueADT();
//
//      int i = 2;
//
//      for (int j = 1; j <= 10; j++) {
//        queue.enqueue(i);
//        System.out.println (queue.front() + " is the front element.");
//        i = i + 2;
//      }
//
//      System.out.println ("The current queue contains " + queue.size() +
//              " elements.");
//
//      while (!queue.empty())
//         System.out.println (queue.dequeue() + " is dequeued from the queue.");
//
//      if (queue.empty())
//        System.out.println ("The queue is empty.");
//      else
//        System.out.println ("There are more elements on the queue.");
//
//    }
// }

// The Stack ADT -- linked list implementation

import java.io.*;

public interface LLStack {

   public void push (int item);
   public int pop();
   public int size();
   public boolean empty();
   public int ontop();

}

class Node {

   private int data;
   private Node next;

   public Node () {
     this(0, null);
   }

   public Node (int d) {
     data = d;
   }
  
   public Node (int d, Node n) {
     data = d;
     next = n;
   }

   public void setData (int newData) {
     data = newData;
   }

   public void setNext (Node newNext) {
     next = newNext;
   } 

   public int getData () {
     return data;
   }

   public Node getNext () {
      return next;
   }

   public void displayNode () {
      System.out.print (data);
   }
}

class LLStackADT implements LLStack {

   private Node top;
   private int size;

   public LLStackADT () {
     top = null;
     size = 0;
   }          

   public boolean empty () {
     return (top == null);
   }

   public void push (int number) {
     Node newNode = new Node ();
     newNode.setData(number);
     newNode.setNext(top);
     top = newNode;
     size++;     
   }

   public int pop () {
     int i;
     i = top.getData();
     top = top.getNext();
     size--;
     return i;
   }

   public int ontop () {
     int i = pop();
     push(i);
     return i;
   }

   public int size () {
     return size;
   }

}

class LLStackAppl {

   public static void main (String[] args) throws IOException {

     BufferedReader stdin = new BufferedReader 
            (new InputStreamReader(System.in));

     LLStackADT stack = new LLStackADT();

     int i = 2;

     for (int j = 1; j <= 10; j++) {
       stack.push(i);
       System.out.println (stack.ontop() + " is the top element.");
       i = i + 2;
     }

     System.out.println ("The current stack contains " + stack.size() +
             " elements.");

     while (!stack.empty())     
        System.out.println (stack.pop() + " is removed from the stack.");
    
     if (stack.empty()) 
       System.out.println ("The stack is empty.");
     else 
       System.out.println ("There are more elements on the stack.");
   }
}
// The Stack ADT -- linked list implementation

import java.io.*;

public interface LStack {

   public void push (int item);
   public int pop();
   public int size();
   public boolean empty();
   public int ontop();

}

class lNode {

   private int data;
   private lNode next;

    public lNode () {
      this(0, null);
    }

   public lNode (int d) {
     data = d;
   }

   public lNode (int d, lNode n) {
     data = d;
     next = n;
   }

   public void setData (int newData) {
     data = newData;
   }

   public void setNext (lNode newNext) {
     next = newNext;
   }

   public int getData () {
     return data;
   }

   public lNode getNext () {
      return next;
   }

   public void displaylNode () {
      System.out.print (data);
   }
}

class LStackADT implements LStack {

   private lNode top;
   private int size;

   public LStackADT () {
     top = null;
     size = 0;
   }

   public boolean empty () {
     return (top == null);
   }

   public void push (int number) {
     lNode newlNode = new lNode (number);
     newlNode.setData(number);
     newlNode.setNext(top);
     top = newlNode;
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



// class LLStackAppl {
//
//    public static void main (String[] args) throws IOException {
//
//      BufferedReader stdin = new BufferedReader
//             (new InputStreamReader(System.in));
//
//      LLStackADT stack = new LLStackADT();
//
//      int i = 2;
//
//      for (int j = 1; j <= 10; j++) {
//        stack.push(i);
//        System.out.println (stack.ontop() + " is the top element.");
//        i = i + 2;
//      }
//
//      System.out.println ("The current stack contains " + stack.size() +
//              " elements.");
//
//      while (!stack.empty())
//         System.out.println (stack.pop() + " is removed from the stack.");
//
//      if (stack.empty())
//        System.out.println ("The stack is empty.");
//      else
//        System.out.println ("There are more elements on the stack.");
//    }
// }

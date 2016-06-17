import java.io.*;
import java.net.*;
import java.util.*;


class hw3 {
  public static LLQueueADT infix =  new LLQueueADT();
  public static LLStack operators =  new LLStackADT();
  public static LLQueueADT postfix =  new LLQueueADT();


  public static void main(String[] args) {
    String expression = "";
    operators.push("#");
    queueExpression(expression);



  }

  public static void queueExpression(String expression) {
    for(i = 0; i < expression.length()-1; i++) {
      char = expression.charAt(i);
      infix.enqueue(char);
    }
  }

  public static int InfixPriority(String token) {
  }

  public static int StackPriority(String token){

  }

}

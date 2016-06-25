import java.io.*;
import java.net.*;
import java.util.*;

// this class implements the infix to postfix algorithm with the toPostfix() method and evaluates
// with the evaluate() method.  There are two stack data structures: LLStack for strings, used for holding the
// operators while converting to postfix) and LStack for integers, used for holding the values while evaluating the
// postfix expression.


class hw3 {
  public static LLQueueADT infix =  new LLQueueADT();
  public static LLStackADT operators =  new LLStackADT();
  public static LLQueueADT postfix =  new LLQueueADT();
  public static LStackADT values = new LStackADT();


  public static void main(String[] args) {
    String expression = "A(((5+2)*(2–1))/((2+9)+((7–2)–1))*8)";
    operators.push("#");
    queueExpression(expression);
    toPostfix();
    int postSize = postfix.size();
    System.out.println("The postfix version of this is: ");
    do{
      String tmp = postfix.dequeue();
      System.out.println(tmp);
      postfix.enqueue(tmp);
      postSize--;
    } while(postSize>0);
    // System.out.println("with A = " + 5 + " B = " + 3 + " C = " + 6 + " D = " + 8 + " E = " + 2);
    // System.out.println("this evaluates to " + evaluate(postfix, 5, 3, 6, 8, 2));

   }

  public static void toPostfix() {
    String next;
    String nextOper;
    String leftParenth;
    while (!infix.empty()) {
      next = infix.dequeue();
      if(isOperator(next) == false) {
        postfix.enqueue(next);
      }
      else if(next.equals(")")){
        do{
          nextOper = operators.pop();
          postfix.enqueue(nextOper);
          nextOper = operators.ontop();
        } while(nextOper.equals("(") == false);
        leftParenth = operators.pop();
      }
      else{
        nextOper = operators.ontop();
        if (StackPriority(nextOper) >= InfixPriority(next) && !nextOper.equals("(")) {
          nextOper = operators.pop();
          postfix.enqueue(nextOper);
        }
       operators.push(next);
     }
    }
      do {
        nextOper = operators.pop();
        postfix.enqueue(nextOper);
      } while(operators.empty() == false);
  }

  public static int evaluate(LLQueueADT post, int A, int B, int C, int D, int E){
    String next;
    int j, k;
    Map<String, Integer> vars = new HashMap<String, Integer>();
    vars.put("A",A);
    vars.put("B",B);
    vars.put("C",C);
    vars.put("D",D);
    vars.put("E",E);
    do {
      next = post.dequeue();
      if(!isOperator(next)) {
        values.push(vars.get(next));
      }
      else {
        if(next.equals("*")) {
          j = values.pop();
          k = values.pop();
          values.push(k*j);
        }
        else if(next.equals("+")) {
          j = values.pop();
          k = values.pop();
          values.push(k+j);
        }
        else if(next.equals("/")) {
          j = values.pop();
          k = values.pop();
          values.push(k/j);
        }
        else if(next.equals("-")) {
          j = values.pop();
          k = values.pop();
          values.push(k-j);
        }
      }
    } while (post.size() >= 1);
    j = values.pop();
    return j;
  }


  public static void queueExpression(String expression) {
    for(int i = 0; i < expression.length(); i++) {
      char str = expression.charAt(i);
      infix.enqueue(String.valueOf(str));
    }
  }

  public static int InfixPriority(String token) {
    if(token.equals("*") || token.equals("/")){
      return 2;
    }
    else if(token.equals("+") || token.equals("-")){
      return 1;
    }
    else if(token.equals("(")){
      return 3;
    }
    else{
      return 0;
    }
  }

  public static int StackPriority(String token){
    if(token.equals("*") || token.equals("/")){
      return 2;
    }
    else if(token.equals("+") || token.equals("-")){
      return 1;
    }
    else if(token.equals("(")){
      return 3;
    }
    else{
      return 0;
    }
  }

  public static boolean isOperator(String token) {
    if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") || token.equals("(") || token.equals("#") || token.equals(")")) {
      return true;
    }
    else {
      return false;
    }
  }

}

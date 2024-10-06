class Node{

  int data;
  StackNode next;

  public void StackNode(int data){
      this.data = data;
      this.next = null;
  }
}

class StackReversed{
  private StackNode top;
  public StackReversed(){
      this.top = null;
  }
  public void push( int data){
      StackNode newNode = new StackNode(data);// instance of a class or object
      newNode.next = top;
      top = newNode;
      System.out.println(data + " pushed to stack.");
  }

  public int pop(){
      if(isEmpty()){
          System.out.println("Stack is empty");
          return -1;

      }
      int poppedData = top.data;
      top = top.next;
      return poppedData;
  }

  public int reversedStack(){
    if(isEmpty()){
        System.out.println("Stack is empty");
        return -1;
    }
 int reversed = null;
 top = top.data;
 return reversed;
  }
  public boolean isEmpty(){
      return(top == null);
  }
  
}
public class Main{
  public static void main(String [] args){
      Stack stack = new Stack();
      stack.push(10);
      stack.push(20);
      stack.push(30);

  }
}


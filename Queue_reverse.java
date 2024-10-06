import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class Queue_reverse {

  static Queue<Integer> queue;

  static void Print()
  {
    while (!queue.isEmpty()) {
      System.out.print(queue.peek() + ", ");
      queue.remove();
    }
  }

  static void reversequeue()
  {
    Stack<Integer> stack = new Stack<>();
    while (!queue.isEmpty()) {
      stack.add(queue.peek());
      queue.remove();
    }
    while (!stack.isEmpty()) {
      queue.add(stack.peek());
      stack.pop();
    }
  }

  public static void main(String args[])
  {
    queue = new LinkedList<Integer>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);

    reversequeue();
    Print();
  }
}
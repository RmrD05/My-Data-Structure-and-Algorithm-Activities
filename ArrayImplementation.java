import java.util.Scanner;

public class ArrayImplementation{
    public static void main(String [] args){
      Scanner sc = new Scanner(System.in);
      int sum = 0;

    System.out.print("Enter the number of Months: ");
    int index = sc.nextInt();

    int array [] = new int[index];

    System.out.println("Enter the number of the Days" );
  for(int i = 0; i< index;i++){
      System.out.print("");
      array [i] = sc.nextInt();
      sum += array[i];
      }

      System.out.println("The number of days is " + sum);
  
    }
  }

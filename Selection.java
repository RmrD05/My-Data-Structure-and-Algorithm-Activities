
import java.util.Scanner;
import java.util.Arrays;


public class Selection {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter the number of elements: "); // prompt the user to input the number of index
        int numIn = sc.nextInt();   

        int[] array = new int[numIn]; //array declaration
        System.out.println("Enter the elements of the array: "); //prompt the user to input the elements
        for (int i = 0; i < numIn; i++) {
            array[i] = sc.nextInt();
        }

        int[] sortedArray = Arrays.copyOf(array, array.length); //  declaring that the function be copied
       
        selectionSort(sortedArray); //calling the insertion function
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));// printing the output

    }
    public static void selectionSort(int[] array) { // the function for the selection sort
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
      }
    }
    


import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: "); // prompt the user to input the number of index
        int numIn = sc.nextInt();

        int[] array = new int[numIn]; //array declaration
        System.out.println("Enter the elements of the array: "); //prompt the user to input the elements
        for (int n = 0; n < numIn; n++) {
            array[n] = sc.nextInt();
        }

        int[] sortedArray = Arrays.copyOf(array, array.length); //  declaring that the function be copied

        insertionSort(sortedArray); //calling the insertion function
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));// printing the output

    }
    public static void insertionSort(int[] array) { // the function for the insertion sort
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) { //sorting the chosen element
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
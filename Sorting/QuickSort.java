
import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {

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
       
        quickSort(sortedArray, 0, sortedArray.length - 1); //calling the insertion function

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));// printing the output

    }
    public static void quickSort(int[] array, int low, int high) { // the function of the quicksort
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) { // the second function for choosing the pivot
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // swapping the elements
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}

    



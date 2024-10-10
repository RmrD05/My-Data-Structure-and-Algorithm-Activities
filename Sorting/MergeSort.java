
import java.util.Scanner;
import java.util.Arrays;


public class MergeSort {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: "); // prompt the user to input the number of index
        int n = sc.nextInt();

        int[] array = new int[n]; //array declaration
        System.out.println("Enter the elements of the array: "); //prompt the user to input the elements
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int[] sortedArray = Arrays.copyOf(array, array.length); //  declaring that the function be copied

        mergeSort(sortedArray, 0, sortedArray.length - 1); //calling the insertion function

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));// printing the output

    }
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];


        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}





import java.util.Scanner;

public class DiamanteHeap {

    
    static void buildMaxHeap(int arr[], int n) {// Function to build the max heap where value of each child is always smaller than value of their parent
    for (int i = 1; i < n; i++) {
        if (arr[i] > arr[(i - 1) / 2]) {
                int j = i;
                while (arr[j] > arr[(j - 1) / 2]) {  // Swap child and parent until parent is smaller
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
        }
      }
    }
    }
    static void heapSort(int arr[], int n) { // function that sorts the heap
        buildMaxHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // Swap value of first indexed with last indexed
            int j = 0, index;  // used to maintain the heap property after each swapping
            do {
                index = (2 * j + 1);

                
                if (index < (i - 1) && arr[index] < arr[index + 1]) index++;// If left child is smaller than right child, point index variable to right child
                if (index < i && arr[j] < arr[index]) swap(arr, j, index); // If parent is smaller than child, then swapping parent with child that have higher value

                j = index;

            } while (index < i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

   
    static void printArray(int arr[]) { // function to print array of size n
        int n = arr.length;
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    
    public static void main(String args[]) {// main method of the program
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");//takes the number of elements or size of the array
        int size = sc.nextInt();

        int[] arr = new int[size];  // takes the elements or the data
        System.out.println("Enter the elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Given array: "); // prints the inputted data in an unsorted manner
        printArray(arr);

        heapSort(arr, size);

        System.out.print("Sorted array: "); //prints the sorted data
        printArray(arr);
    }
}

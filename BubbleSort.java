import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort{
    public static void main(String [] args){
        Scanner sc =  new Scanner(System.in);
        
        //Getting the number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int [] array = new int[n];
        //Getting the elements
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n ; i++){
            array[i] = sc.nextInt();
        }
        //this enables the variables to be embeded to the function
        int[] sortedArray = Arrays.copyOf(array, array.length);

        //calls the bubblesort function and the copy of the variables
       bubbleSort(sortedArray); 
       //prints the output
       System.out.println("Sorted array in ascending order : " + Arrays.toString(sortedArray));
    }
    //this function sorts the elements by swapping adjacent variables
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
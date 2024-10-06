import java.util.Arrays;
import java.util.Scanner;


public class BiSearch{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);


		System.out.println("Input the number of months ");
		int nm = sc.nextInt();

		int [] array = new int[nm];
		System.out.println("As much possible do input numbers that does not exceed the days of the month.");
		System.out.println("Enter the days of the month: ");

		for(int m = 0; m < nm; m++){
			array[m] = sc.nextInt();
		 }


		 System.out.println("Enter the day you wish to locate: ");
		 int target  = sc.nextInt();
		// for sorting
         Arrays.sort(array);
         System.out.println("The sorted array is "  + Arrays.toString(array));
         int result = binarySearch( array, target, 0, array.length -1);
         System.out.println( target +" is found at month " + result);

	}
	 public static int binarySearch(int[] array, int target, int low, int high) {
	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            if (array[mid] == target) {
	                return mid;
	            }
	            if (array[mid] < target) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        System.out.println("Target not found in the array");
	        return -1;
		}


}


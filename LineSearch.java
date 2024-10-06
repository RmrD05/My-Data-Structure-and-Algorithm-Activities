import java.util.Arrays;
import java.util.Scanner;

public class LineSearch{
	public static void main(String [] args){
	Scanner sc = new Scanner(System.in);

	//getting the number of index
	System.out.println("Input the number of days: ");
	int nd = sc.nextInt();

	//getting the elements
	int [] array = new int[nd];
	System.out.println("Enter the number of hours: ");
	for(int n = 0; n < nd; n++){
		array[n] = sc.nextInt();
	 }
	 //getting the target
	 System.out.println("Enter the numbef of hour you wish to locate: ");
	 int hours = sc.nextInt();
		//looping for locating the target
		for(int d = 0; d < array.length; d++){
		 	if(array[d] == hours){
		 	System.out.println( hours + " Is found at day " + d);
	 }
	}
  }
}

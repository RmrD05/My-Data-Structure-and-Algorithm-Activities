import java.util.Scanner;

public class ArrayInialization {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int gifts = 0;
        System.out.print("Enter number of good children: ");
        int goodkids = sc.nextInt();

        int array[] = new int[goodkids];

        System.out.println("Enter number of gifts per good mannered kid:");
        for(int i = 0; i < goodkids; i++){
            array[i] = sc.nextInt();
            gifts += array[i];
        }
        System.out.println("The number of gifts the good children will receive is " + gifts);
    }

    
}

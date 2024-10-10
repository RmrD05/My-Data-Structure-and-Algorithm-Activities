import java.util.Scanner;
public class trial{
    public static void main(String []args){

        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter words ");
        String names = sc.nextLine();
        String rev = "";
        for(int i = names.length()-1; i >= 0; i--){
        rev+= names.charAt(i);
			}


        if(names.equals(rev)){

            System.out.println("palindrome");

        }else {
			System.out.println("not a palindrome");

		}

    }

}
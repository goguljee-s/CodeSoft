import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= (int) (Math.random()*(100-1+1))+1;

        int attempt=5;
        while (attempt>0){
            System.out.println("You have only "+attempt+" attempts more!");
            System.out.print("Enter the Number: ");
            int guessNum=sc.nextInt();
            if(attempt==1&&num!=guessNum){
                System.out.println("Opps! your failed");
            }
            else if(guessNum==num){
                System.out.println("You guessed correct number "+num+" in "+(5-attempt)+"th attempt");
                break;
            } else if (num>guessNum) {
                System.out.println("Sorry! Enter a greater thant this number");
            }else{
                System.out.println("Sorry! Enter the less than this number");
            }
            attempt--;
        }
        if (attempt==0){
            System.out.print("There is no more attempt!");
        }
    }
}

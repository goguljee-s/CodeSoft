import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of Subjects: ");
        int sub= sc.nextInt();
        int subori=sub;
        int total=0;
        while(sub>0){
            System.out.print("Enter the subject "+(subori-sub+1)+" mark out of 100 = ");
            total+=sc.nextInt();
            sub--;
        }
        int avg=total/subori;
        if(avg>=90){
            System.out.println("Grade A");
        } else if (avg>70) {
            System.out.println("Grade B");
        } else if (avg>50) {
            System.out.println("Grade C");
        }else if(avg>45){
            System.out.println("Grade D");
        }else {
            System.out.println("Grade E");
        }
    }
}

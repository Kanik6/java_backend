import java.util.Scanner;

public class java_loops {
    public static void main(String[]  args){

        System.out.print("input number:  ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result;
        if (2 <= n && n <= 20) {
            for (int i = 1; i <= 10; i++) {
                result = n * i;
                System.out.printf("\n %d * %d = %d", n, i, result);
            }
        }
    }
}

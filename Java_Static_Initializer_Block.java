import java.util.Scanner;

public class Java_Static_Initializer_Block {

        static Scanner scan = new Scanner(System.in);
        static int H = scan.nextInt();
        static int B = scan.nextInt();
        static boolean flag = true;
        static{
            if(H <= 0 || B <= 0){
                flag = false;
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            }
        }

        public static void main(String[] args){
            if (flag) {
                int area = B * H;
                System.out.print(area);
            }
        }

    }


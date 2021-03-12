import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;
import java.util.Scanner;

public class SpaceArrays {
//    public static void main(String[] args) {
//        long T;
//        long C;
//        try {
//
//            Scanner sc = new Scanner(System.in);
//            T = sc.nextLong();
//            for (long i = 1; i <= T; i++) {
//                long N = sc.nextLong();
//                long inputArray[] = new long[(int) N];
//                for (int j = 0; j < N; j++)
//                    inputArray[j] = sc.nextLong();
//                Arrays.sort(inputArray);
//                String player = "Second";
//                for (int x = 0; x < N; x++) {
//
//                    if (inputArray[x] < x + 1) {
//                        long adder = x + 1 - inputArray[x];
//                        inputArray[x] += adder;
//                        if (adder % 2 != 0 && player != "First")
//                            player = "First";
//                        else
//                            player = "Second";
//                    } else {
//                        player = "Second";
//                        break;
//                    }
//                    System.out.println(player);
////                System.out.println(solution(inputArray,N));
//                }
//            }
//            } catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
        public static void main(String[] args) {
        long T;
        long C;
        try {

            Scanner sc = new Scanner(System.in);
            T = sc.nextLong();
            for (long i = 1; i <= T; i++) {
                long N = sc.nextLong();
                long inputArray[] = new long[(int) N];
                for (int j = 0; j < N; j++)
                    inputArray[j] = sc.nextLong();

         System.out.println(solution(inputArray,N));
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        static String solution ( long[] a, long n){
            Arrays.sort(a);
            int val = 0, flag = 0;

            for (int i = 0; i < n; i++) {
                if (i + 1 - a[i] < 0) {
                    flag = 1;
                    break;
                }
                val += i + 1 - a[i];
            }
            if (flag == 1)
                return "Second";
            else {
                if (val % 2 != 0)
                    return "First";
                return "Second";

            }
        }
    }


package KICKSTART_2021;


// Problem-1  MARCH 21,2021 K-Goodness String

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

//        sc.next();
        for (int i = 1; i <= T; i++) {
            int goodness_score = 0;
            int output = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine().trim();
//            System.out.println(s+ " " + T + " " + N + " "+ " "+ K);
            int L = s.length();
//            System.out.println(L);
            if (L == N) {
//
//                for (int j = 0; j < N / 2; j++) {
//
//                    if (s.charAt(j) != s.charAt(N - j - 1)) {
//                        goodness_score += 1;
//
//                    }
//                }
//                System.out.println(goodness_score);

                for (int idx = 0; idx <  N / 2; idx++) {
                    if (s.charAt(idx) != s.charAt(s.length() - 1 - idx)) {
                        goodness_score++;
                    }
                }
                int value = (int) goodness_score;

                System.out.println("Case #" + i + ": " + Math.abs(value - K));



//
//                if (K <= goodness_score) {
//                    System.out.println("Case #" + i + ": " + 0);
//                } else if (K > goodness_score) {
//                    output = ((N / 2) - goodness_score);
//                    int required_goodness = K - goodness_score;
//                    if (required_goodness <= output) {
//                        System.out.println("Case #" + i + ": " + required_goodness);
//                    } else {
//                        System.out.println("Case #" + i + ": " + 0);
//
//                    }
//                }
            } else {
                System.out.println("Case #" + i + ": " + 0);
            }
        }
//            System.out.println(goodness_score);
    }
    private void solveCase(Scanner in) {
        int t = in.nextInt();

        for (int caso = 1; caso <= t; caso++) {
            int n = in.nextInt();
            int k = in.nextInt();

            String s = in.next();

            long count = 0L;
            int bound = s.length() / 2;
            for (int idx = 0; idx < bound; idx++) {
                if (s.charAt(idx) != s.charAt(s.length() - 1 - idx)) {
                    count++;
                }
            }
            int value = (int) count;

            System.out.println("Case #" + caso + ": " + Math.abs(value - k));
        }
    }
}

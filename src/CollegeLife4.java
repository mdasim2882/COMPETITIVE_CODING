import java.util.Scanner;

public class CollegeLife4 {
    private final static int omleteLimit[] = {2, 0};
    private final static int choclateCakeLimit[] = {1, 1};
    private final static int chocolateMilkshake[] = {0, 3};

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            long T, N, E, H, A, B, C;
            T = scanner.nextLong();
            for (int i = 0; i < T; i++) {

                N = scanner.nextLong();
                E = scanner.nextLong();
                H = scanner.nextLong();
                A = scanner.nextLong();
                B = scanner.nextLong();
                C = scanner.nextLong();

                long totOmlete = E / omleteLimit[0];
                long totChocoCake = Math.min(E, H);
                long totChocoMilkshake = H / chocolateMilkshake[1];

                double P[] = new double[3];
                P[0] = A / (double) totOmlete;
                P[1] = B / (double) totChocoMilkshake;
                P[2] = C / (double) totChocoCake;
                long cost = 0, itemCount = 0;
    //            System.out.println(totOmlete + " : " + totChocoMilkshake + " : " + totChocoCake);
    //            System.out.println(P[0] + " : " + P[1] + " : " + P[2]);
    //        if (totOmlete >= N) {
    //            cost = N * A;
    //        } else if (totChocoMilkshake >= N) {
    //            cost = N * B;
    //        } else if (totChocoCake >= N) {
    //            cost = N *C;
    //        } else {
                while (E > 0 || H > 0) {

                    if (P[0] < P[1] && P[0] < P[2]) {
                        long x = E / omleteLimit[0];
                        itemCount += x;
                        if (itemCount <= N)
                            cost += A * x;
                        else {
                            long var = (N - itemCount - x);
                            if (var > 0)
                                cost += var * A;
                            else
                                cost += N * A;
                        }

                        P[0] = Integer.MAX_VALUE;
                        E -= x * omleteLimit[0];


                    } else if (P[1] < P[2] && P[1] < P[0]) {
                        long x = H / chocolateMilkshake[1];
                        itemCount += x;
                        if (itemCount <= N)
                            cost += B * x;
                        else {
                            long var = (N - itemCount - x);
                            if (var > 0)
                                cost += var * B;
                            else
                                cost += N * B;
                        }

                        H -= x * chocolateMilkshake[1];
                        P[1] = Integer.MAX_VALUE;


                    } else if (P[2] < P[0] && P[2] < P[1]) {

                        long x = Math.min(E, H);
                        itemCount += x;
                        if (itemCount <= N)
                            cost += C * x;
                        else {
                            long var=(N - itemCount - x);
                            if(var>0)
                                cost += var * C;
                            else
                                cost+=N*C;
                        }
    //                    System.out.println("Peeks in C with cost= "+cost);
                        E -= x;
                        H -= x;
                        P[2] = Integer.MAX_VALUE;

                    } else if ((E >= 1 && H >= 1) && (E >= 0 && H >= 3) && (E >= 2 && H >= 0)) {
                        long x = Math.min(E, H);
                        long y = H / chocolateMilkshake[1];
                        long z = E / omleteLimit[0];
                        if (x > y && x > z) {
                            itemCount += x;
                            if (itemCount <= N) {
                                cost += x * C;
                            }else {
                                long var = (N - itemCount - x);
                                if (var > 0)
                                    cost += var * C;
                                else
                                    cost += N * C;
                            }

                            P[2] = Integer.MAX_VALUE;
                        } else if (y > z && y > x) {
                            itemCount += y;
                            if (itemCount <= N)
                                cost += B * y;
                            else {
                                long var = (N - itemCount - y);
                                if (var > 0)
                                    cost += var * B;
                                else
                                    cost += N * B;
                            }

                            P[1] = Integer.MAX_VALUE;

                        } else if (z > x && z > y) {
                            itemCount += z;
                            if (itemCount <= N)
                                cost += A * z;
                            else {
                                long var = (N - itemCount - z);
                                if (var > 0)
                                    cost += var * A;
                                else
                                    cost += N * A;
                            }

                            P[0] = Integer.MAX_VALUE;

                        }
                    } else {
                        break;
                    }
    //                System.out.println("E=" + E + " : H= " + H + ": Cost= " + cost);
                }
                if (itemCount < N)
                    System.out.println(-1);
                else
                    System.out.println(cost);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

import java.util.Scanner;

public class NoTimeToWait {
    public static void main(String[] args) {
        int N, H, x;

        try {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            H = sc.nextInt();
            x = sc.nextInt();
            boolean status = false;
            int A[] = new int[N];
            for(int i=0;i<N;i++){
                A[i]=sc.nextInt();
            }
            for (int i : A) {
                if (i + x >= H) {
                    status = true;
                    break;
                }
            }
            if (status)
                System.out.println("Yes");
            else
                System.out.println("No");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

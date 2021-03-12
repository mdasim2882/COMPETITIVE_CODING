import java.util.Scanner;

public class ChefAndGroups {
    public static void main(String[] args) {
        int T, S, x;
        try {

            Scanner sc = new Scanner(System.in);
//            String inputString = sc.nextLine();
//            System.out.println(solution(inputString));
            T = sc.nextInt();
            sc.next();
            boolean status = false;
            for(int i=1;i<=T;i++){
                String inputString = sc.nextLine();
                System.out.println(solution(inputString));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int solution(String s) {
        boolean status =false;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' ){
                if (!status) {
                    count++;
//                    System.out.print(i+ " ");
                    status=true;
                }
            }
            else {
                status=false;
            }
        }
        return count;
    }

}

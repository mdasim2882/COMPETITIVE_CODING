import java.util.*;

public class InterestingXOR {
    static int perfectPowerOf2(int n) {
        // To store perfect power of 2
        int per_pow = 1;
        while (n > 0) {
            // bitwise left shift by 1
            per_pow = per_pow << 1;
            n = n >> 1;
        }
        // Required perfect power of 2
        return per_pow;
    }

    public static void main(String[] args) {
        int T;long C;
        try {

            Scanner sc = new Scanner(System.in);
            T = sc.nextInt();
            for (int i = 1; i <= T; i++) {
                C = sc.nextLong();
//                TLESolution(C);
                System.out.println(optimizedSolution(C));
                System.out.println("Fastest Solution : "+fastestSolution(C));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long optimizedSolution(long c) {
        long i=1;
        long x=0;
        while (x<=c){
            x= (long) Math.pow(2,i);
            i++;
        }
        i-=2;
        long cat;
        long numberOfbits= (long) (Math.floor((Math.log(c) / Math.log(2)))+1);
        long a=((1<<numberOfbits)-1)^c;
        cat=a;
        a+=Math.pow(2,i);

        long b= (long) (Math.pow(2,i)-1);
        System.out.println("i= "+i+"\nshiftBitsResult= "+(1<<numberOfbits)+"\nnumberOfBits= "+numberOfbits+"\nbeforeAddingPowertoA= "+cat+"\nafterAddingPowertoA = "+a+"\nvalueOfB= "+b);

        return a*b;
    }
    private static long fastestSolution(long c) {
        long i=1;
        long x=0;
        long cat;
        long numberOfbits= (long) (Math.floor((Math.log(c) / Math.log(2))));
        long a=(1<<numberOfbits)-1;
       long b=a^c;

        System.out.println("i= "+i+"\nA = "+a+"\nB = "+b+"\nResult "+a*b);

        return a*b;
    }

    private static void TLESolution(int C) {
        long res, result = -1;
        HashMap<Long, Long> valueBox = new HashMap<>();
        long powOf2 = perfectPowerOf2(C);
        ArrayList<Long> sum = new ArrayList<>();
        for (long x = 0; x < C; x++) {
            long aXorC = x ^ C;
            if (!valueBox.containsKey(aXorC)) {
                valueBox.put(x, aXorC);
                sum.add(x);
//
//                        if(aXorC<powOf2){
//                            res=x*aXorC;
//                            result=Math.max(result,res);
//                        }
            }
        }
        Collections.sort(sum);
        long val=sum.get(sum.size()-1);
        result=valueBox.get(val)*val;
        System.out.println(result );
    }
}

package InterviewBit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        // Implement Max Sum Contiguous Subarray using KADANE's ALGORITHM
        // Pick all elements until the sum becomes negative and update the current sum if it is maximum

        List<Integer>  inputList=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for (int i = 0; i < N; i++) {
            inputList.add(sc.nextInt());
        }
        System.out.println(maxSubArray(inputList));
    }
    public static  int maxSubArray(final List<Integer> A) {
        int sumSofar=0;
        int maxSum=Integer.MIN_VALUE;
        //Implement KADANE Algorithm
        for(Integer i:A){
            sumSofar+=i;
            maxSum=Math.max(maxSum,sumSofar);

            //NOTE: SET sumSoFar = 0 because considering sum starts with negative doesn't mean
            if(sumSofar<0)
                sumSofar=0;

        }
        return maxSum;

    }
}

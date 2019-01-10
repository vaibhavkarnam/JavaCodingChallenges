/*
Algorithm Description: We need to devise an algorithm which for a given number n finds an approximation for sqrt(n). I have used binary search to find the squareroot.
The algorithm is as described below:
STEP 1.If input number n > 1 then, Initialize start = 0, end = numb, mid = (start+end)/2
                             else  Initialize start = numb, end = 1, mid = (start+end)/2


STEP 2. Find diff = absolute difference between square of the mid and numb.

STEP 3. While mid is not the square root of number (i.e. mid*mid !== number) or difference diff is greater than 0.01,

        loop through the following steps:

            STEP 1. If mid*mid > numb,
            then the square root will be less than mid.
            Thus we set end = mid.

            Else, the square root will be greater than mid.
            Thus we set start = mid.


            STEP 2 .Calculate mid  = (start+end)/2.

            STEP 3. Find diff = absolute difference between square of the mid and numb.

STEP 4: Return mid

RUNTIME ANALYSIS: STEP 1 involves initaliazion and basic computations therefore takes constant time. STEP 2 involves calculating the difference and finding absolute value which will also take constant time. In STEP 3 WE run a while loop and apply binary search so we reduce the problem by half during each iteration. Therefore this will take O(logn) the. Thus the running time complexity of the algorithm is O(logn)

SPACE COMPLEXITY : The space complexity of the algorithm is O(1). The space complexity is constant as we do not require any extra space to store and the space used to store the variables is the same for any input number.

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
	    Double numb = in.nextDouble();
        Double start = 0.0;
        Double end = 0.0;
              if(numb<1)
        {
         start = numb;
         end = 1.0;
        }
        else
        {
         start = 0.0;
         end =numb;
        }
        Double mid = (start + end)/2;
        Double diff = Solution.abs_diff(mid*mid - numb);
         Double sqrtNum = sqrtAlgo(numb,start,end,mid,diff);
         System.out.println(sqrtNum);

    }

    public static Double sqrtAlgo(Double numb, Double start, Double end, Double mid, Double diff){

        while(mid*mid != numb && diff> 0.01){
            if(mid*mid > numb)
                end = mid;
            else
               start = mid;
            mid = (start + end)/2;
            diff = abs_diff(mid*mid - numb);
        }

        return mid;

    }

    public static Double abs_diff(Double number){
        return (number < 0) ? -number : number;
    }
}

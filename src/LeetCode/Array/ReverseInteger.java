package LeetCode.Array;

public class ReverseInteger {

    /**
     *  "123" -> "321"
     *  注意overflow 条件 原本不overflow的数经过reverse可能导致overflow
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result =0;
        while(x!= 0)
        {
            int curr = x %10;
            //处理overflow
            if(result > Integer.MAX_VALUE /10 || (result == Integer.MAX_VALUE /10 &&curr > 7))
                return 0;
            if(result < Integer.MIN_VALUE /10 || (result == Integer.MIN_VALUE /10 &&curr <-8))
                return 0;
            result = result*10 + curr;
            x/=10;
        }
        return result;
    }
}

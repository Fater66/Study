package LeetCode.BinarySearch;

public class isPerfectSquare {
    public  static void main(String[] args)
    {
        isPerfectSquare test = new isPerfectSquare();
        System.out.println(test.isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num < 1) return false;
        long left = 0;
        long right = num/2;
        while(left <= right)
        {
            long mid = left + (right-left)/2;
            long mult = mid *mid;
            if (mult == num) return true;
            if(mult > num)
            {
                right = mid-1;
            }
            else left = mid+1;
        }
        return false;
    }
}

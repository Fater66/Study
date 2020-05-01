package DSA;

public class DivideConqeur {

    public static void main(String[] args)
    {
        DivideConqeur dc = new DivideConqeur();
        int result = dc.maxSubArray(new int[]{3,4,5,3,2,1,2,4,1});
        System.out.println(result);
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        return findMax(nums,0,nums.length-1);
    }

    private int findMax(int[] nums,int left,int right)
    {
        if (left > right) return 0;
        if (left == right) return nums[left];
        int mid = (left + right)/2;
        int result = Integer.MIN_VALUE;
        int temp = 0;
        for (int i =left;i<=right;i++)
        {
            temp += nums[i];
            result = Math.max(result,temp);
        }
        int l = findMax(nums,left,mid);
        int r = findMax(nums,mid+1,right);
        int mid2 = Center(nums,left,right);
        return Math.max(result,Max3(l,r,mid2));
    }
    private int Center(int[] nums,int left,int right)
    {
        int leftSum = Integer.MIN_VALUE;
        int mid = (left +right) /2;
        int temp = 0;
        for (int i = mid ;i >= left;i--)
        {
            temp += nums[i];
            leftSum = Math.max(leftSum,temp);
        }
        temp = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int j= mid+1;j<= right; j++)
        {
            temp += nums[j];
            rightSum = Math.max(rightSum,temp);
        }
        return Max3(leftSum,rightSum,leftSum+rightSum);
    }

    private int Max3(int n1,int n2, int n3)
    {
        return Math.max(n1,Math.max(n2,n3));
    }
}

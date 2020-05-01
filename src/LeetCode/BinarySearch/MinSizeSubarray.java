package LeetCode.BinarySearch;

public class MinSizeSubarray {
    public  static void main(String[] args)
    {
        MinSizeSubarray test = new MinSizeSubarray();
        int[] m = new int[]{2,3,1,2,4,3};

        System.out.println(test.minSubArrayLen(10,m));
    }

    /**
     * 二分查找方法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int[] sum = new int[nums.length+1];
        for(int i = 1;i<=nums.length;i++)
        {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i =1;i<=nums.length;i++)
        {
            int target = s+sum[i-1];
            int bound = lowerBound(sum,0,sum.length,target);
            if (bound!= -1)
            {
                result = Math.min(result,bound -i +1);
            }
        }
        return (result == Integer.MAX_VALUE)? 0:result;
    }

    private int lowerBound(int[] nums,int left,int right,int target){
        if(nums[nums.length-1] <target) return -1;
        while(left<right){
            int mid = left + (right-left)/2;
            if (target > nums[mid])
                left = mid+1;
            else right = mid;
        }
        return left;
    }

    /**
     * 双指针方法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLenTwoPointer(int s, int[] nums) {
        int n = nums.length;
        int left =0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(sum >= s)
            {
                result = Math.min(result,i-left+1);
                sum-=nums[left++];
            }
        }
        return (result==Integer.MAX_VALUE)? 0:result;
    }
}

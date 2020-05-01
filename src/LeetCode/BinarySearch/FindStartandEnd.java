package LeetCode.BinarySearch;

public class FindStartandEnd {
    public  static void main(String[] args)
    {
        FindStartandEnd test = new FindStartandEnd();
        int[] m = new int[]{5,7,7,8,8,10};

        for (int num : test.searchRange(m,6))
        System.out.println(num);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length == 0) return result;
        result[0] = leftBound(nums,target);
        result[1] = rightBound(nums,target);
        return result;
    }

    private int leftBound(int[] nums,int target)
    {
        int left = 0;
        int right = nums.length;
        while (left< right)
        {
            int mid = (left + right) /2;
            if (nums[mid] == target)
            {
                right = mid;
            }
            else if (nums[mid] > target)
            {
                right = mid;
            }
            else left = mid +1;
        }
        return nums[left] == target ? left : -1;
    }
    private int rightBound(int[] nums,int target)
    {
        int left = 0;
        int right = nums.length;
        while (left< right)
        {
            int mid = (left + right) /2;
            if (nums[mid] == target)
            {
                left = mid +1;
            }
            else if (nums[mid] > target)
            {
                right = mid-1;
            }
            else left = mid +1;
        }
        return nums[right] == target ? right : -1;
    }
}

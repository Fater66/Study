package LeetCode.BinarySearch;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray solution = new FindMinimuminRotatedSortedArray();

        int[] test = new int[]{2,3,4,1};
        System.out.println(solution.findMin(test));
    }

    /**
     * 利用左边的排序数组中的所有数都大于等于右边排序数组的所有数的性质
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length-1;
        if(nums[right] > nums[0]){
            return nums[0];
        }
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right])
            {
                left = mid+1;
            }
            else if (nums[mid] < nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}

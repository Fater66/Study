package LeetCode.Array;

import java.util.Arrays;

public class NextPermutation {
    /**
     * leetcode 31 下一个排列
     * @param nums
     */

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0) return;
        int loc = len-2;
        //先找第一个降序字母对[i,j], i < j && nums[i] <= nums[j]
        while(loc >= 0 && nums[loc +1 ] <= nums[loc])
            loc--;
        if(loc == -1)
        {
            Arrays.sort(nums);
            return;
        }
        int i = loc +1;
        int sLoc = i;
        //再找i后比nums[i]大的最小数的位置，从而保证是下一个排列
        while(i < len)
        {
            if(nums[sLoc] > nums[i] && nums[i] > nums[loc])
                sLoc = i;
            i++;
        }
        swap(nums,loc,sLoc);
        //将i后的所有数升序排列
        Arrays.sort(nums,loc+1,len);
        return;
    }

    private void swap(int[] nums,int l1,int l2)
    {
        nums[l1] = nums[l1] ^ nums[l2];
        nums[l2] = nums[l1] ^ nums[l2];
        nums[l1] = nums[l1] ^ nums[l2];
    }
}

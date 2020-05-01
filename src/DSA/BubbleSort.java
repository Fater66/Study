package DSA;

public class BubbleSort {
    private void bubblesort(int[] nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j = 0;j<nums.length-i-1;j++)
            {
                if(nums[j] > nums[j+1])
                {
                    swap(nums,j,j+1);
                }
            }
        }
    }

    private void swap(int[] nums,int l,int r)
    {
        nums[l] = nums[l]^nums[r];
        nums[r] = nums[l]^nums[r];
        nums[l] = nums[l]^nums[r];
    }
}

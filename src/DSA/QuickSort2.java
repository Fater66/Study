package DSA;

public class QuickSort2 {
    // test the compute class
    public static void main(String[] args){


        QuickSort solution = new QuickSort();
        for (int num:solution.sortArray(new int[]{5,1,1,2,4,3,3,2,2,2,2,0,0}))
            System.out.println(num);

    }


    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    int pivot =0;
    private void quicksort(int[] nums,int p,int r)
    {
        if (p < r){
            pivot = partition(nums,p,r);
            quicksort(nums,p,pivot-1);
            quicksort(nums,pivot+1,r);
        }else
            return;
    }

    private int partition(int[] nums,int p,int r)
    {
        int x = nums[r];
        int i = p- 1;
        for (int j = p ;j <= r -1;j++)
        {
            if (nums[j] <= x)
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }
    private void swap(int[] nums,int loc1,int loc2)
    {
        int temp = nums[loc1];
        nums[loc1] = nums[loc2];
        nums[loc2] = temp;
    }
}

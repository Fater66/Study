package DSA;

public class QuickSort {
    // test the compute class
    public static void main(String[] args){


        QuickSort solution = new QuickSort();
        for (int num:solution.sortArray(new int[]{5,1,1,2,2,2,2,2,2,0,0}))
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
            quicksort(nums,p,pivot);
            quicksort(nums,pivot+1,r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int x = nums[p];
        int i = p-1;
        int j = r+1;
        while (true)
        {
            do{
                j--;
            }
            while(nums[j] > x);

            do{
                i++;
            }while (nums[i] < x);

            if (i<j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else
            {
                return j;
            }
        }
    }
}

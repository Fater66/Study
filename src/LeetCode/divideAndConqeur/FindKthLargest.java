package LeetCode.divideAndConqeur;

public class FindKthLargest {
    public  static void main(String[] args)
    {
        FindKthLargest test = new FindKthLargest();
        int[] m = new int[]{3,2,1,5,6,4};
        System.out.println(test.findKthLargest(m,2));
    }
    public int findKthLargest(int[] nums, int k) {
        if( k > nums.length) return -1;
        int a = nums.length - k;

        return quicksort(nums,0,nums.length-1,a+1);
    }

    private int RandomPartition(int[] A,int p,int r )
    {
//        int i = (int)(Math.random() *(r-p)) + p;
//        int temp = A[i];
//        A[i] = A[p];
//        A[p] = temp;
        return partition(A,p,r);
    }
    private int quicksort(int[] nums,int left,int right,int loc)
    {
        if (left == right) return nums[left];
        int pivot = RandomPartition(nums,left,right);
        int k = pivot -left +1;
        if (k == loc) return nums[pivot];
        if (loc < k ) return quicksort(nums,left,pivot-1,loc);
        else return quicksort(nums,pivot+1,right,loc-k);

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

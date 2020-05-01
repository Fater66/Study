package LeetCode.Sort;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    //逆序对
    //You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
    public static void main(String args[]) {
        CountofSmallerNumbersAfterSelf test = new CountofSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};

        System.out.println(test.countSmaller(nums));
    }
    int[] temp;
    int[] count;
    int[] indexes;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if(n==0) return result;
        temp = new int[n];
        count = new int[n];
        indexes = new int[n];
        for(int i = 0;i<n;i++)
        {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums,0,n-1);
        for(int i =0;i<n;i++)
        {
            result.add(count[i]);
        }
        return result;
    }

    private void mergeAndCountSmaller(int[] nums,int left,int right)
    {
        if(left >= right)
            return;
        int mid = left + (right-left)/2;
        mergeAndCountSmaller(nums,left,mid);
        mergeAndCountSmaller(nums,mid+1,right);
        if(nums[indexes[mid]] > nums[indexes[mid+1]])
        {
            mergeNum(nums,left,mid,right);
        }
    }

    private void mergeNum(int[] nums,int left,int mid,int right)
    {
        for(int i =left;i<=right;i++)
        {
            temp[i] = indexes[i];
        }
        //左右两个数组的指针
        int p1 = left;
        int p2 = mid+1;
        for(int k = left;k<=right;k++)
        {
            if(p1 > mid)
            {
                indexes[k] = temp[p2];
                p2++;
            }else if(p2 > right)
            {
                indexes[k] = temp[p1];
                p1++;
                count[indexes[k]] += right-mid;
            }
            //注意不是temp[p1] 而是nums[temp[p1]]
            else if(nums[temp[p1]] <= nums[temp[p2]])
            {
                indexes[k] = temp[p1];
                p1 ++;
                //注意是+=
                count[indexes[k]] += p2 - mid-1;
            }
            else {
                indexes[k] = temp[p2];
                p2++;
            }
        }
    }
}

package LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KClosetElements {

    public  static void main(String[] args)
    {
        KClosetElements test = new KClosetElements();
        int[] nums = {1,2,3,4,5};
        System.out.println(test.findBigger(nums,0,4,3));
        System.out.println(test.findSmaller(nums,0,4,3));
        for(int num:test.findClosestElements(nums,4,-1))
        {
            System.out.println(num);
        }
    }
    LinkedList<Integer> result = new LinkedList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        boolean flag = true;
        int[] range = new int[2];
        int xLoc = findSmaller(arr,0,arr.length-1,x);
        if (xLoc != -1)
        {
            range[0] = xLoc;
            result.add(arr[xLoc]);
        }else{
            range[0] = 0;
            flag = false;
            result.add(arr[0]);
        }
        range[1] = range[0];
        while(result.size()<k)
        {
            if(flag)
            {
                if(range[0]!= 0)
                {
                    int left = findSmaller(arr,0,range[0],x);
                    if(left != -1)
                    {
                        range[0] = left;
                        result.addFirst(arr[left]);
                    }
                }
                flag = false;
            }else
            {
                if(range[1]!= arr.length-1)
                {
                    int right = findBigger(arr,range[1]+1,arr.length-1,x);
                    if(right != -1)
                    {
                        range[1] = right;
                        result.addLast(arr[right]);
                    }
                }
                flag = true;
            }
        }
        return new ArrayList<>(result);
    }

    private int findSmaller(int[] nums,int left,int right,int target)
    {
        if(target< nums[left]) return -1;
        while(left<right-1)
        {
            int mid = left + (right -left )/2;
            if (target >= nums[mid])
                left = mid ;
            else right = mid;
        }
        return left;
    }

    private int findBigger(int[] nums,int left,int right,int target){
        if(nums[nums.length-1] <target) return -1;
        while(left<right){
            int mid = left + (right-left)/2;
            if (target > nums[mid])
                left = mid+1;
            else right = mid;
        }
        return left;
    }
}

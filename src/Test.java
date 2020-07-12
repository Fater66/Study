import Tool.TreeNode;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        res.add(69);
        ans.addAll(res);
        System.out.println(ans.size());

        int[][] tt = new int[2][2];
        tt[0][0] = 1;
        tt[0][1] = 2;
        tt[1][0] = 3;
        tt[1][1] = 4;
        for(int[] n:tt)
        {
            System.out.println("0:"+n[0] + ",1:" + n[1]);
        }
        int[] temp = tt[0];
        tt[0] = tt[1];
        tt[1] = temp;
        for(int[] n:tt)
        {
            System.out.println("0:"+n[0] + ",1:" + n[1]);
        }

        int[] input = new int[]{5,2,6,1};
        System.out.println(test.countSmaller(input));
        System.out.println();
    }


    int[] res;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        res = new int[len];
        int[][] nums1 = new int[len][2];
        for(int i = 0;i<len;i++)
        {
            nums1[i][0] = nums[i];
            nums1[i][1] = i;
        }
        quicksort(nums1,0,len-1);
        List<Integer> ans = new ArrayList<>();
        for(int n:res)
            ans.add(n);
        return ans;
    }

    private void quicksort(int[][] nums1,int left,int right)
    {
        if(left >= right) return;
        int[] pivot = partition(nums1,left,right);
        res[pivot[1]] = pivot[0] - left +1;
        quicksort(nums1,left,pivot[0]);
        quicksort(nums1,pivot[0]+1,right);
    }

    private int[] partition(int[][] nums,int left,int right)
    {
        int[] x = nums[left];
        int p = left- 1;
        int r = right +1;
        while(true)
        {
            do{
                p ++;
            }while(nums[p][0] < x[0]);
            do{
                r--;
            }while(nums[r][0] > x[0]);
            if(p < r)
            {
                int[] temp = nums[p];
                nums[p] = nums[r];
                nums[r] = temp;
            }
            else
                return new int[]{r,nums[r][1]};
        }
    }



}
package LeetCode.BinarySearch;

import java.util.Arrays;

public class LowerUpperBound {
    public  static void main(String[] args)
    {
        LowerUpperBound test = new LowerUpperBound();
        int[] m = new int[]{5,7,7,8,8,10,31,41};
//        System.out.println(1<<0);
        System.out.println(test.lowerBound(m,0,m.length,4));
//        System.out.println(test.findSmaller(m,0,m.length,5));
        System.out.println(binarysearchKey(m,21));
    }

    /**
     * 找到排序数组中不小于target的第一个数的坐标，如果没有返回-1
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int lowerBound(int[] nums,int left,int right,int target){
        if(nums[nums.length-1] <target) return -1;
        while(left<right){
            int mid = left + (right-left)/2;
            if (target > nums[mid])
                left = mid+1;
            else right = mid;
        }
        return left;
    }

    /**
     * 找到排序数组中不大于target的第一个数的坐标，如果没有返回-1
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
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

    /**
     * 查找数组中最接近target的数的位置
     * @param array
     * @param targetNum
     * @return
     */
    public static Integer binarysearchKey(int[] array, int targetNum) {
        Arrays.sort(array);
        int left = 0, right = 0;
        for (right = array.length - 1; left != right;) {
            int midIndex = (right + left) / 2;
            int mid = (right - left);
            int midValue = array[midIndex];
            if (targetNum == midValue) {
                return midIndex;
            }

            if (targetNum > midValue) {
                left = midIndex;
            } else {
                right = midIndex;
            }

            if (mid <= 1) {
                break;
            }
        }
//        System.out.println("和要查找的数：" + targetNum + "最接近的数：" + array[targetindex]);
        if(Math.abs(array[right] - targetNum) >= Math.abs(array[left]-targetNum)) return left;
        else return right;
//        return ((array[right] -  array[left]) / 2 > targetNum )? array[right]
//                : array[left];
    }
}

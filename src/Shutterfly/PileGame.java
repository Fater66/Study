package Shutterfly;

public class PileGame {
    public static void main(String args[]) {

        PileGame test = new PileGame();
        int[] nums = {3,5,7};
        int[] testNum = {1,2,3};
        System.out.println(test.isWin2(nums,2));
        System.out.println(test.XOR(testNum));
    }
    private String isWin(int[] nums,int k)
    {
        if(nums.length == 0)
            return "Sam wins the game";
        int n = nums.length;
        if (!helper(nums,k,0)) return "Sam wins the game";
        else return "Alex  wins the game";
    }

    private boolean helper(int[] nums,int k,int turn)
    {
        boolean result = false;
        boolean canPick =false;
        turn %=2;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i] != 0)  canPick = true;
            else continue;
            if(nums[i] <= k)
            {
                for(int j = 1;j<=Math.min(nums[i],k);j++)
                {
                    nums[i] -= j;
                    if(!helper(nums,k,turn +1))result = true;
                    nums[i] +=j;
                }
            }
            else if(nums[i] > k)
            {
                for(int j = 1;j* k <= nums[i] ;j++)
                {
                    nums[i] -= j * k;
                    if(!helper(nums,k,turn +1))result = true;
                    nums[i] +=j * k;
                }
            }
        }
        if(turn == 0 && canPick == false) return true;
        if (turn == 1 && canPick == false) return false;
        return result;

    }

    private int XOR(int[] nums)
    {
        int curr = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            curr ^= nums[i];
        }
        return curr;
    }

    private String isWin2(int[] nums,int k)
    {
        if(nums.length == 0)
            return "Sam wins the game";
        int n = nums.length;
        int[] nums2 = new int[n];
        for(int i =0;i<n;i++)
        {
            nums2[i] = nums[i] /k;
            nums[i] %= k;
        }
        boolean firstWin = (XOR(nums2) != 0);
        boolean secondWin = (XOR(nums) != 0);
        if (firstWin ^ secondWin) return "Sam wins the game";
        else return "Alex  wins the game";
    }
}

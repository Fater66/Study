package LeetCode.backtrack;

public class AdditiveNum {

    public  static void main(String[] args)
    {
        AdditiveNum test = new AdditiveNum();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(test.isAdditiveNumber("211738"));
//        System.out.println(test.isLeadingZero("00",0,2));
    }

    boolean result = false;
    public boolean isAdditiveNumber(String num) {
        if(num.length()<=2) return false;
        backtrack(0,0,0,num);
        return result;
    }

    private void backtrack(int start1,int end1,int end2,String num)
    {
        //end condition
        if (result == true) return;
        //first round
        if(start1 == 0 && end1 ==0)
        {
            for(int i =1;i<num.length()-1;i++)
            {
                backtrack(0,i,0,num);
            }
            return;
        }
        else if (start1 == 0 && end2 == 0)
        {
            for (int i =1;i<num.length()-1;i++)
            {
                if(end1 + i > num.length() -1) break;
                else{
                    backtrack(0,end1,end1+i,num);
                }
            }
            return;
        }
        for(int i = 1;i<=num.length()-end2;i++)
        {
            if (isLeadingZero(num,start1,end1) || isLeadingZero(num,end1,end2)||isLeadingZero(num,end2,end2+i))
                break;
            String temp = num.substring(end2,end2+i);
            long num1 = Long.valueOf(num.substring(start1,end1));
            long num2 = Long.valueOf(num.substring(end1,end2));
            long num3 = Long.valueOf(temp);
            if(num1+num2 == num3)
            {
                if (end2+i == num.length()) result = true;
                backtrack(end1,end2,end2+i,num);
            }
        }
    }

    private boolean isLeadingZero(String num,int start,int end)
    {
        if (start == end) return false;
        long temp = Long.valueOf(num.substring(start,end));
        if (temp!= 0 && num.charAt(start) =='0') return true;
        else if (temp == 0 && (end-start) >1) return true;
        return false;
    }
}

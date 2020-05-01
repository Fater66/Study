package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

class RestoreIP {
    public  static void main(String[] args)
    {
        RestoreIP test = new RestoreIP();

        for (String s:test.restoreIpAddresses("25525511135"))
        {
            System.out.println(s);
        }
    }
    ArrayList<String> result = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backtrack(0,0,new StringBuilder());
        return result;
    }

    private void backtrack(int loc,int num,StringBuilder sb)
    {
        if(num == 3)
        {
            String curr = s.substring(loc,s.length());
            if (Integer.valueOf(curr)<=255)
            {
                sb.append(curr);
                result.add(sb.toString());
                sb.delete(sb.length()-curr.length(),sb.length());
            }
            return;
        }
        String temp;
        for(int i =1;i<=3;i++)
        {
            if(loc+i <s.length())
            {
                temp = s.substring(loc,loc+i);
                if(Integer.valueOf(temp)<=255)
                {
                    sb.append(temp+".");
                    backtrack(loc+i,num+1,sb);
                    sb.delete(sb.length()-temp.length()-1,sb.length());
                }
            }

        }
    }
}
package LeetCode.Array;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        //because
        int j = -1;
        for(int i =0;i<s.length();i++)
        {
            //notice j+1 not j
            j = t.indexOf(s.charAt(i),j+1);
            if(j == -1)
                return false;
        }
        return true;
    }
}

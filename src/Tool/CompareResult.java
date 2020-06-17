package Tool;

import java.util.ArrayList;
import java.util.HashSet;

public class CompareResult {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String s = "dasd";
        set.add(s);
        System.out.println(set.contains("dasd"));
    }
    private ArrayList<String> compare(String[] s1, String[] s2)
    {
        ArrayList<String> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(String temp:s1)
        {
            set.add(temp.hashCode());
        }

        for(String temp:s2)
        {
            if(!set.contains(temp.hashCode()))
                result.add(temp);
        }
        return result;
    }

    /**
     * 暴力查找
     * @param s1
     * @param s2
     * @return
     */
    private ArrayList<String> compare2(String[] s1,String[] s2)
    {
        ArrayList<String> result = new ArrayList<>();

        for(String temp:s1)
        {
            boolean find =false;
            for(String t2:s2)
            {
                if(temp.equals(t2)) {
                    find = true;
                    break;
                }
            }
            if(!find) result.add(temp);
        }
        return result;
    }
}

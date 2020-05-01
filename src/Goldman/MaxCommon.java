package Goldman;

public class MaxCommon {

    public static void main(String[] args)
    {
        MaxCommon mx = new MaxCommon();
        String s = "zzzxxxzzz";
        System.out.println(mx.findMaxCommon(s));
        int[] array ={2,3,4};
    }

    private int findMaxCommon(String s)
    {
        if (s.length() < 2) return 0;
        int[] dict = new int[26];
        int[] dictL = new int[26];
        int result = 0;
        int temp = 0;
        char[] schar = s.toCharArray();
        dictL[schar[0] -'a'] ++;
        for (int i = s.length() -1;i>=1;i--)
        {
            dict[schar[i]-'a'] ++;
            if (dictL[schar[i]-'a'] == 1)
            {
                temp =1;
                result = 1;
            }
        }
        for (int i =1;i<s.length()-1;i++)
        {

            if (dictL[schar[i] - 'a'] >= dict[schar[i] - 'a'])
            {
                temp--;

            }
            else{
                if (!(dictL[schar[i]-'a'] == dict[schar[i]-'a'] - 1))
                {
                    temp++;
                    result = Math.max(result,temp);
                }
            }

            dict[schar[i] - 'a'] --;
            dictL[schar[i] - 'a'] ++;
        }
        return result;
    }

}

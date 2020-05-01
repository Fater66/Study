package Amazon;

import java.util.Arrays;

public class isPrime {
    /**
     * 遇到一个素数 p平方 +p， p平方+2p的数直到n都是合数
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i =2;i*i<n;i++)
        {
            if(!isPrime[i]) continue;
            for(int j = i*i;j<n;j+=i)
            {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i =2;i<n;i++)
        {
            if(isPrime[i]) count++;
        }
        return count;
    }
    /**
     * 遍历每个数 check 是否是prime
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for(int i=2;i<n;i++)
        {
            if(isPrime(i))
                count++;
        }
        return count;
    }

    private boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i ==0)
                return false;
        }
        return true;
    }
}

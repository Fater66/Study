import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    int n;
    int m;
    int C;
    public static void main(String[] args) {
        Main test = new Main();
        Scanner sc = new Scanner(System.in);
        test.n = sc.nextInt();
        test.m = sc.nextInt();
        test.C = sc.nextInt();
        float[][] access = new float[test.n][3];
        float[][] liquid = new float[test.m][3];
        for(int i =0;i<test.n;i++)
        {
            access[i][0] = sc.nextFloat();
            access[i][1] = sc.nextFloat();
            access[i][2] = sc.nextFloat();
        }
        for(int i = 0;i<test.m;i++)
        {
            liquid[i][0] = sc.nextFloat();
            liquid[i][1] = sc.nextFloat();
            liquid[i][2] = sc.nextFloat();
        }
        //贪心算法
        Arrays.sort(access, new Comparator<float[]>() {
            @Override
            public int compare(float[] a1, float[] a2) {
                float f1 = a1[1]/a1[0];
                float f2 = a2[1]/a2[0];
                return (f1 > f2)? -1:1;
            }
        });
        int result = 0;
        outer:
        for(int i =0;i<access.length;i++)
        {
            while(test.C >= access[i][0] && access[i][2] !=0)
            {
                Arrays.sort(liquid, new Comparator<float[]>() {
                    @Override
                    public int compare(float[] l1, float[] l2) {
                        float v1 = l1[0] * test.C * test.C + l1[1] * test.C + l1[2];
                        float v2 = l2[0] * test.C * test.C + l2[1] * test.C + l2[2];
                        return v1>v2?-1:1;
                    }
                });
                float v = liquid[0][0] * test.C * test.C + liquid[0][1] * test.C + liquid[0][2];
                float lv = v/test.C;
                float av = access[i][1]/access[i][0];
                if(lv > av) {
                    result += v;
                    test.C = 0;
                    break outer;
                }
                result +=access[i][0];
                access[i][2] --;
                test.C-=access[i][0];
            }
        }

        Arrays.sort(liquid, new Comparator<float[]>() {
            @Override
            public int compare(float[] l1, float[] l2) {
                float v1 = l1[0] * test.C * test.C + l1[1] * test.C + l1[2];
                float v2 = l2[0] * test.C * test.C + l2[1] * test.C + l2[2];
                return v1>v2?-1:1;
            }
        });
        float v = liquid[0][0] * test.C * test.C + liquid[0][1] * test.C + liquid[0][2];
        if(v > 0)result += v;

        System.out.println(result);
    }
}
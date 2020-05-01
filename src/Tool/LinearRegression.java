package Tool;

import java.util.Arrays;

public class LinearRegression {

    public static void main(String args[]) {
        double P = Double.MIN_VALUE;
        int num = 3;//number of constraint
        int[] range = new int[num];
        double[] x;
        System.out.println(1.1 * 5 /3 + 1.2 * 5/2 + 1 * 5 /3);
        double[] max_x = new double[3];
        Arrays.fill(range,100);
        for(double x1 =0;x1<=5;x1+= 0.01)
        {
            for(double x2 = 0;x2 <= 5;x2+=0.01)
            {
                for(double x3 = 0;x3 <=5;x3 +=0.01)
                {
                    x = new double[]{x1,x2,x3};
                    if(lessthan(x,2,2,2,10) && lessthan(x,1,3,1,10) &&lessthan(x,4,1,1,10) &&
                            lessthan(x,3,1,3,10) && lessthan(x,1,2,3,10) && lessthan(x,3,2,1,10))
                    {
                        double curr = sum(x,1.1,1.2, 1);
                        if( curr > P)
                        {
                            P = curr;
                            max_x[0] = x1;
                            max_x[1] = x2;
                            max_x[2] = x3;
                        }
                    }
                }
            }
        }
        System.out.println("P max = " + P );
        for(double maxX:max_x)
        {
            System.out.print(maxX + " ");
        }
    }

    private static boolean lessthan(double[] x,double p1,double p2,double p3,double res)
    {
        if(p1 * x[0] + p2 * x[1] + p3 * x[2] <= res)
            return true;
        else return false;
    }

    private static boolean largerthan(double[] x,double p1,double p2,double p3,double res)
    {
        if(p1 * x[0] + p2 * x[1] + p3 * x[2] >= res)
            return true;
        else return false;
    }

    private static double sum(double[] x,double p1,double p2,double p3)
    {
        return p1 * x[0] + p2 * x[1] + p3 * x[2];
    }
}

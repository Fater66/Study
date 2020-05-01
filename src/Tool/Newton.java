package Tool;

import java.math.BigDecimal;

public class Newton {
    public static void main(String[] args)
    {
//        double x = 0;
//        double firstDerivative = 2;
//        double secondDerivative = 1;
//        while(firstDerivative/secondDerivative> 0.00000001)
//        {
//            firstDerivative = 2 * x - 4.0;
//            secondDerivative = 2;
//            x = x - firstDerivative/secondDerivative;
//        }
//        System.out.println(x);

        double maxVal = Integer.MIN_VALUE;
        double maxX = 0;
        for(double x =0;x<100;x+=0.001)
        {
            double cur = x*x*x -2 * x * x + 3* x/4;
            if(cur > maxVal)
            {
                maxVal = cur;
                maxX = x;
            }
        }
        System.out.println(maxX + "  "+ maxVal);
    }


}

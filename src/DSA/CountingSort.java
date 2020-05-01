package DSA;

public class CountingSort {
    public  static void main(String[] args)
    {
        CountingSort test = new CountingSort();
        int[] number = new int[]{2,4,7,3,6,1,3,4,5,7};
        for (int n:test.countingsort(number,7))
        {
            System.out.println(n);
        }
    }
    public int[] countingsort(int[] A,int r) {
        int[] B = new int[A.length];
        int[] C = new int[r+1];
        for (int i = 0;i<= r;i++)
        {
            C[i] = 0;
        }
        for (int j = 0;j < A.length ;j++)
        {
            C[A[j]] ++;
        }
        for (int i = 1;i<= r;i++)
        {
            C[i] += C[i-1];
        }
        //从后往前 -> stable sort
        for (int j = A.length-1;j>=0;j--)
        {
            B[C[A[j]]-1] = A[j];
            C[A[j]] --;
        }
        return B;
    }
}

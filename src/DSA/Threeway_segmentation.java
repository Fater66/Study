package DSA;

public class Threeway_segmentation {
    public  static void main(String[] args)
    {
        Threeway_segmentation test = new Threeway_segmentation();
        int[] number = new int[]{1,5,5,7,1,5,7,1,5,5,7,1,5,7,1,5,7,5};
        test.quicksort(number,0,number.length);
        for (int i :number)
            System.out.print(i+ " ");
    }

    int[] pivot = new int[2];

    void quicksort(int A[], int p, int r) {
        if (p < r - 1) {
            pivot = partition(A, p, r);
            quicksort(A, p, pivot[0]);
            quicksort(A, pivot[1], r);
        }
    }

//    int[] randomized_partition(int A[], int p, int r) {
//        int i = (int)(Math.random() * (r-p)) + p;
//
//
//        EXCHANGE (A,i, r-1);
//
//        return partition(A, p, r);
//    }

    int[] partition(int[]  A, int p, int r) {
        int x = A[r - 1],
                q = p,
                t;


        for (int i = p; i < r - 1; i++) {
            if (A[i] < x) {
                EXCHANGE(A,q, i);
                q++;
            }
        }

        for (t = q; t < r && A[t] == x; t++);
//        for (int i :A)
//            System.out.print(i+ " ");
        System.out.println();
        for (int i = r - 1; i >= t; i--) {
            if (A[i] == x) {
                EXCHANGE(A,t, i);
                t++;
            }
        }

        int[] result = {q, t};
        return result;
    }

    private void EXCHANGE(int[] A, int i, int i1) {
        int temp = A[i];
        A[i] =A[i1];
        A[i1] = temp;
    }
}

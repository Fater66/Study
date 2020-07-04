package Tool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NewCoder {

    //读取二维数组的输入
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //给了两个变量
//        int height = sc.nextInt();
//        int width = sc.nextInt();
//        int[][] myArray = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                myArray[i][j] = sc.nextInt();
//            }
//        }
//        //到这里已经读完了
//        System.out.println();
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print(myArray[i][j]);
//            }
//            System.out.println();
//        }
//
//    }

    //单纯的读取一行整数，中间用空格分割
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(" ");
        int[] spiltInt = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            spiltInt[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(spiltInt));
    }
}

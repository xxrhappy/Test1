package myArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GunGun
 * @Description:
 * @Date: Greate in 2021/7/15 16:19
 */
public class Test2 {
    //判断一个数组中是否有连续三个奇数
    public static boolean threeNumber(int[] arr){
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i]%2 != 0 && arr[i+1]% 2 != 0 && arr[i+2]% 2 != 0){
               return true;
            }
        }
        return false;
    }
    //判断顺序表是否有三个连续的奇数,体会一下数组和顺序表的区别
    public static boolean threeNum(List<Integer> arr){
        for (int i = 0; i < arr.size()-2; i++) {
            if(arr.get(i) % 2 != 0 && arr.get(i+1) % 2 != 0 && arr.get(i+2) % 2 != 0){
               return true;
            }
        }
        return false;
    }
    //实现杨辉三角
    //注意行号列号是从1开始算的,但是下标是从0开始算的,一定要己得转换,不然容易数组下标越界
    public static List<List<Integer>> generate(int numRows){
       if(numRows <= 0){
           //如果行数为0,直接返回一个空的链表
           return new ArrayList<>();
       }
       List<List<Integer>> result = new ArrayList<>();
       //处理第一行
       List<Integer> firstList = new ArrayList<>();
       firstList.add(1);
       result.add(firstList);
       if(numRows == 1){
           return result;//返回的结果是双重的list[[1]]
       }
       //处理第二行
        List<Integer> secondList = new ArrayList<>();
       secondList.add(1);
       secondList.add(1);
       result.add(secondList);
       if (numRows == 2){
           return result;
       }
       //处理之后的第i行
        for (int row = 3; row <= numRows; row++) {
            List<Integer> currentList = new ArrayList<>();
            //当前行是row,那么上一行是row-1,转成下标就是row-1-1
            List<Integer> prevList = result.get(row-1-1);
            //第一列一直是1
            currentList.add(1);
            //处理中间列
            for(int col = 2 ;col <= row -1; col++){
                int num1 = prevList.get(col-1);//row-1,col,然后需要转换成下标
                int num2 = prevList.get(col-1-1);//row-1,col-1,然后转换成下标
                currentList.add(num1+num2);
            }
            //最后一列是1
            currentList.add(1);
            result.add(currentList);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,5,7,8,9};
        System.out.println(threeNumber(arr));
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        System.out.println(threeNum(arr2));;
        System.out.println(generate(5));
    }
}

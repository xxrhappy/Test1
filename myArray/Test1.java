package myArray;

import java.util.Arrays;

/**
 * @Author: GunGun
 * @Description:数组习题练习
 * @Date: Greate in 2021/7/9 15:47
 */
public class Test1 {
    //数组数字排列
    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
    public static void transform(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            if(arr[left] %2 == 0 ){
                left++;
            }
            if (arr[right] %2 != 0){
                right--;
            }else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }

        }
    }
    public static void reserve(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
          int tmp = arr[left];
          arr[left] = arr[right];
          arr[right] = tmp;
          right--;
          left++;
        }
    }
    public  static void bubbleSort(int[] arr){
        for (int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length-1;cur> bound;cur--){
                if(arr[cur] < arr[cur-1]){
                int tmp = arr[cur];
                arr[cur] = arr[cur-1];
                arr[cur-1] = tmp;
                }
            }
        }
    }
    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return false;
    }
    public static int binarySerch(int[] arr,int toSearch){
       int left = 0;
       int right = arr.length-1;
       while (left < right) {
           int mid = (left + right) / 2;
           for (int i = 0; i < arr.length; i++) {
               if (toSearch < arr[mid]) {
                   right = mid-1;
               } else if (toSearch > arr[mid]) {
                   left = mid+1;
               } else {
                   return mid;
               }
           }
       }
        return -1;
    }
    public static int  max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]){
                int tmp = max;
                max = arr[i];
                arr[i] = tmp;
            }
        }
        return max;
    }
    public static int[] mycopyOf(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void mytoString(int[] arr){
        String ret = "[";
        for(int i = 0;i < arr.length;i++){
          ret += arr[i];
          if(i != arr.length-1){
              ret += ",";
          }
        }
        System.out.println(ret+"]");
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,9,6,7};
       // bubbleSort(arr);
       // Arrays.sort(arr);//java内置数组排序
        //reserve(arr);
        transform(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(binarySerch(arr,4));
//        System.out.println(max(arr));
        //数组拷贝(深拷贝),创建一个长度为arr.length新数组,将原数组的数组元素copy到新的数组
//        System.out.println(Arrays.toString(  mycopyOf(arr)));
//        int[] arr2 = Arrays.copyOf(arr,arr.length);
//        System.out.println(Arrays.toString(arr2));
        //数组转字符串
        //mytoString(arr);
        //System.out.println(Arrays.toString(arr));
    }
}

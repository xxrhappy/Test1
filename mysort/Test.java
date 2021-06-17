package mysort;
import java.util.Arrays;

/**
 * @Author: GunGun
 * @Description:
 * @Date: Greate in 2021/6/13 17:51
 */
public class Test {
    //1 插入排序  [稳定 时间复杂度哦(n^2) 空间复杂度o(1)]
    public static void insertSort(int[] arr){
        int bound = 1;
        //已排序区间:[0,bound),待排序区间[bound,length)
        for(;bound < arr.length; bound++){
           int v = arr[bound];//取出待排序区间的第一个元素
           int cur = bound -1;//已排序区间的最后一个元素
           for(;cur >= 0; cur--){
               if(arr[cur] > v){
                   arr[cur+1] = arr[cur];
               }else{
                   break;
               }
           }
           arr[cur+1] = v;
        }
    }

//2 希尔排序 [不稳定 时间复杂度o(n^2)最优时间复杂度o(n^4/3) 空间复杂度哦(1)]
   public static void shellSort(int[] arr){
        int gap = arr.length/2;
        while(gap >= 1){
            _shellSort( arr, gap);
            gap = gap/2;
        }
   }
    public static void _shellSort(int[] arr,int gap){
        int bound  = gap;
        for(;bound < arr.length; bound++){
            int v = arr[bound];
            int cur = bound - gap;
            for (;cur >=0 ;cur -= gap){
                if(arr[cur] > v){
                 arr[cur+gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+gap] = v;
        }
    }
    //选择排序和冒泡排序的区别就是选择是拿元素和擂台元素比,冒泡是和相邻的元素比较
    //3. 选择排序[不稳定 时间复杂度O(n^2) 空间复杂度o(1)]
    public static void selectSort(int[] arr){
       for( int bound = 0;bound < arr.length;bound++) {
           for(int cur = bound+1;cur < arr.length;cur++){
               if(arr[bound] > arr[cur]){
                   swap(arr,bound,cur);
               }
           }
       }
    }

    //4 冒泡排序[稳定性 时间复杂度o(n^2) 时间复杂度o(1)]
    public static void bubbleSort(int[] arr){
        for(int bound  = 0;bound < arr.length;bound++){
            for(int cur = arr.length-1;cur > bound;cur--){
                if(arr[cur] < arr[cur-1]){
                    swap(arr,cur,cur-1);
                }
            }
        }
    }
    //5.堆排序[不稳定 时间复杂度O(NlogN) 空间复杂度O(1)]
    public static void heapSort(int[] arr){
        //建堆
        creatHeap(arr);
        int heapSize = arr.length;
        for(int i = 0;i < arr.length;i++){
            swap(arr,0,heapSize-1);
            heapSize --;
            shiftDown(arr,0,heapSize);
        }
    }
    public  static void creatHeap(int[] arr){
        for (int i = (arr.length-1-1)/2; i >= 0;i--) {
            shiftDown(arr,i,arr.length);
        }
    }
    public static void shiftDown(int[] arr,int index,int size){
        int parent  = index;
        int child = 2*parent + 1;
        while(child < size){
            if(child+1 < size && arr[child+1] > arr[child]){
              child = child+1;
            }
            if(arr[parent] < arr[child]){
               swap(arr,parent,child);
            }else{
                break;
            }
            parent = child;
            child = 2*child +1;
        }
    }
    //6. 快速排序[不稳定 最坏时间复杂度o(n^2) 平均时间复杂度o(nlogn) 最坏空间复杂度0(n) 平均空间复杂度o(log n)]
    public static void quickSort(int[] arr){
        _quickSort(arr,0,arr.length-1);
    }
    public static void _quickSort(int[] arr, int left,int right){
        if(left >= right){
            return;
        }
        //选取新的基准值
        int index = partition(arr,left,right);
        _quickSort(arr,left,index-1);
        _quickSort(arr,index+1,right);
    }
    public static int partition(int[] arr,int left,int right){
        //选取最初的基准值为数组的最右边
        int v = arr[right];
        int i = left;
        int j = right;
        while(i < j){
            while(i < j && arr[i] <= v){
                i++;
            }
            while (i < j && arr[j] >= v) {
                j--;
            }
            swap(arr,i,j);
        }
        //当i,j重叠时,当前重叠位置的元素一定大于基准值
        swap(arr,i,right);
        return i;
    }

    //7. 归并排序[稳定 时间复杂度O(nlogn) 空间复杂度O(n)]
    public  static void mergeSort(int[] arr){
        _mergeSort(arr,0,arr.length);
    }
    public static void _mergeSort(int[] arr,int left, int right){
        if(right - left<= 1){
            return;
        }
        int mid = (left+right)/2;
        _mergeSort(arr,left,mid);
        _mergeSort(arr,mid,right);
        merge(arr,left,mid,right);//合并有序的左右区间
    }
    public static void merge(int[] arr,int left,int mid, int right){
        int[] tmp = new int[right-left];
        int tmpsize = 0;//把元素放到零时数组的tmpsize位置上
        int l = left;
        int r = mid;
        while(l < mid && r < right){
            if(arr[l] <= arr[r]){
                tmp[tmpsize] = arr[l];
                tmpsize++;
                l++;
            }else{
                tmp[tmpsize] = arr[r];
                tmpsize++;
                r++;
            }
        }
        //如果一边还有元素则全部copy进去
        while(l < mid){
            tmp[tmpsize++] = arr[l++];
        }
        while(r < right){
            tmp[tmpsize++] = arr[r++];
        }
        for (int i = 0; i < right-left; i++) {
            arr[left+i] = tmp[i];
        }
    }
    public static void swap(int[] arr,int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void main(String[] args) {
        int[] arr1 = {9,5,2,7,3,6,8};
        //insertSort(arr1);
        //shellSort(arr1);
        //selectSort(arr1);
        //heapSort(arr1);
        //bubbleSort(arr1);
        //quickSort(arr1);
        mergeSort(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}

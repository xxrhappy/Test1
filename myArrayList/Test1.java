package myArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: GunGun
 * @Description:顺序表相关练习
 * @Date: Greate in 2021/7/15 11:33
 */
//顺序表是数据结构中更为广义的概念,数组是Java语法中更具体的概念,数组是实现顺序表的典型法师
//逻辑:从代码的角度看就是前一个元素能不能直接到达下一个元素
//物理:是内存的布局
//capacity: 容量   size:元素个数
//数组和顺序表使用差不多,为什么要使用顺序表? 数组只能[]取下标,.length取数组长度;但是顺序表多了增删改查的方法,使用更加方便,不想数组要自己实现
//ArrayList.isEmpty如果true就是有一个空盒子;array List = null就是连一个空盒子都没有
public class Test1 {
//public  boolean add(String e);
// void add(int index, String e);
// String remove(int index);
// boolean remove(String e);
// String get(int index);
//String get(int index);
//String set(int index, String e);
//boolean contains(String e);
//int indexOf(String e);
//int lastIndexOf(String e);
//void clear();
// int size();
//  boolean isEmpty();

    public static void main(String[] args) {
        //创建array list实例,
        // 如果想改成list,直接改成List<String> arrayList = new ArrayList<>();//向上转型
        //下边所有的代码和逻辑可以直接用,多态的好处
        ArrayList<String> arrayList = new ArrayList<>();
        //remove删除的时候先匹配按位置删除
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        System.out.println(arrayList1);
        arrayList1.remove(1);
        System.out.println(arrayList1);
        //1. 输出顺序表已有元素的个数
        System.out.println(arrayList.size());
        //2. 判空
        System.out.println(arrayList.isEmpty());
        //3. 把元素添加到顺序表末尾
        arrayList.add("c");
        arrayList.add("java");
        arrayList.add("path");
        arrayList.add("test");
        //把元素插入到指定位置
        arrayList.add(0,"web");
        arrayList.add(2,"sort");
        //直接打印顺序表会触发他自己的toString方法
        System.out.println(arrayList);
        //4. 按照位置删除
        arrayList.remove(2);
        System.out.println(arrayList);
        //按照值删除
        arrayList.remove("web");
        System.out.println(arrayList);
        //5. 查找
        boolean ret = arrayList.contains("java");
        System.out.println(ret);
        int index = arrayList.indexOf("java");
        System.out.println(index);
        //6. 获取元素/修改元素
        String elem = arrayList.get(0);
        System.out.println(elem);
        arrayList.set(1,"go");
        System.out.println(arrayList);
        //7. 遍历顺序表,迭代器也可以遍历,但是顺序表可以取下标没必要用迭代器iterator遍历,但是map,set用iterator遍历
        //1. 取下标遍历
        for (int i = 0; i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        //2.1.通过Iterator 方法获取迭代器对象(把迭代器对象脑补成一个光标)
        Iterator<String> iterator = arrayList.iterator();
        //2.2. 再通过while循环来遍历
        while(iterator.hasNext()){
            String e = iterator.next();//把"光标"指向的元素指到的元素获取到并返回,同时"光标"移动到下一个位置
            System.out.println(e);
        }
        //3. 是一种语法糖,本质上是迭代器的方法来实现的
        for (String e: arrayList) {
            System.out.println(e);
        }
    }
}

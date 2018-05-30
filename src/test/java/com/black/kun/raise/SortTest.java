package com.black.kun.raise;

import java.util.Arrays;
import java.util.List;

public class SortTest {

    public static List<Integer> testList = Arrays.asList(6, 7, 5, 8, 1, 9);
    public static int[] test = {6, 7, 5, 8, 1, 9};

    public static void main(String... args) {
//        System.out.println("排序前:"+"{6, 7, 5, 8, 1, 9}");
//        bubble();
//        quick();
//        insertSort();
//        Arrays.sort(test);
//        Arrays.stream(test).forEach(System.out::println);
//        System.out.println(recursionBinarySearch(test,1,0,5));
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }

    //bubble
    public static void bubble() {
        int temp;
        for (int i = 0; i < test.length-1; i++) {
            for (int j = i+1; j < test.length; j++) {
                if (test[i] > test[j]) {
                    temp = test[j];
                    test[j] = test[i];
                    test[i] = temp;
                }
            }
        }
        System.out.print("排序后");
        Arrays.stream(test).forEach(System.out::println);
    }

    //insert
    public static void insertSort() {
        int size = test.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = test[i];
            for(j = i; j > 0 && temp < test[j-1]; j--)
                test[j] = test[j-1];
            test[j] = temp;
        }
        System.out.print("排序后");
        Arrays.stream(test).forEach(System.out::print);
    }

    //quick
    public static void quick(){
        int temp,size= test.length;
        for(int i = 0;i<size;i++){
            int k = i;
            for (int j = size - 1; j >i; j--)  {
                if (test[j] < test[k])
                    k = j;
            }
            temp = test[i];
            test[i] = test[k];
            test[k] = temp;
        }
        System.out.print("排序后");
        Arrays.stream(test).forEach(System.out::println);
    }

    //二分
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;          //初始中间位置
//        if(arr[middle] == key){
//            return middle;
//        }
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }

    }



}

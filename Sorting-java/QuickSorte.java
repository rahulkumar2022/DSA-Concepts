package Sorting-java;

import java.util.*;

public class QuickSorte {
    public List<Integer> QuickSort(List<Integer> arr){
        qs(arr,0,arr.size()-1);
        return arr;
    }
    private void qs(List<Integer> arr,int low,int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            qs(arr,low,pIndex-1);
            qs(arr,pIndex+1,high);
        }
    }
    private int partition(List<Integer> arr,int low,int high){
        int pivot = arr.get(low);
        int i = low;
        int j = high;
        while(i<j){
            while(arr.get(i)<=pivot && i<=high-1){
                i++;
            }
            while(arr.get(j)>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low,arr.get(j));
        arr.set(j,temp);
        return j;
    }
}

package Sorting;

import java.util.ArrayList;
import java.util.List;

// Pick a pivot(ant element) and place it at its correct position
// All smaller elemts should move to left of pivot and greater in right of it
public class QuickSort {
    private static void quickSort(List<Integer> array,int low,int high){
        if(low < high){
            int pi = partition(array, low, high);
            quickSort(array, low, pi-1);
            quickSort(array, pi+1, high);
        }
    }
    private static int partition(List<Integer> array, int low, int high){
        int pivot = array.get(low);
        int i = low;
        int j = high;
        while(i<j){
            while(array.get(i)<=pivot && i<=high-1){
                i++;
            }
            while(array.get(j)>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = array.get(i);
                array.set(i,array.get(j));
                array.set(j,temp);
            }
        }
        int temp = array.get(low);
        array.set(low,array.get(j));
        return j;
    }
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);
        quickSort(array,0,array.size()-1);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}

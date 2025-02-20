package Sorting

import java.util.*;


public class MergeSorte {
    public void mergeSort(int arr[]){
        divide(arr,0,arr.length-1);
    }
    private void divide(int[] arr,int start,int end){
        if(start>=end) return;
        int mid = (start+end)/2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        merge(arr,start,mid,end);
    }
    private void merge(int[] arr,int start,int mid,int end){
        List<Integer> list = new ArrayList<>();
        int left = start;
        int right = mid+1;
        while(left<=mid && right<=end){
            if(arr[left]<=arr[right]){
                list.add(arr[left++]);
            }
            else{
                list.add(arr[right++]);
            }
        }
        while(left<=mid){
            list.add(arr[left++]);
        }
        while(right<=end){
            list.add(arr[right++]);
        }
        int j = 0;
        for(int i=start;i<=end;i++) {
            arr[i] = list.get(j++);
        }
    }
}

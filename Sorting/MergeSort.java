package Sorting;

import java.util.ArrayList;

// Divide and Merge algorithm
public class MergeSort {
    public static void mergeSort(int[] arr,int low,int high){

        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    private static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        // if element left in left array
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        // if element left in right array
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        // Putting it back to orginal array
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}

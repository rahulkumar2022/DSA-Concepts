package Sorting;


// Select the minimum element and place it in the beginning
public class SelectionSort {
    public void selectionSort(int[] nums,int n){

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[minIdx]){
                    minIdx = j;
                }
            }
            int temp = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = temp;
        }

    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1,6,9,2};
        SelectionSort obj = new SelectionSort();
        obj.selectionSort(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

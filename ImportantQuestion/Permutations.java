package ImportantQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<List<Integer>> ans = new ArrayList<>();
        findAllPermutations(list,ans,0);
        System.out.println(ans);
    }
    private static void findAllPermutations(List<Integer> list,List<List<Integer>> ans,int idx){
        if(idx==list.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<list.size();i++){
            swap(list,idx,i);
            findAllPermutations(list, ans, idx+1);
            swap(list,idx,i);
        }
    }
    private static void swap(List<Integer> list,int i,int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

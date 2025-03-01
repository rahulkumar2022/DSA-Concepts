package ImportantQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<List<Integer>> ans = new ArrayList<>();
        findAllPermute(ans,list,0);
        System.out.println(ans);
    }
    private static void findAllPermute(List<List<Integer>> list,List<Integer> curr,int idx){
        if(idx==curr.size()){
            
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<curr.size();i++){
            swap(curr,idx,i);
            findAllPermute(list, curr, idx+1);
            swap(curr,idx,i);
        }
    }
    private static void swap(List<Integer> curr,int i,int j){
        int temp = curr.get(i);
        curr.set(i, curr.get(j));
        curr.set(j, temp);
    }
}

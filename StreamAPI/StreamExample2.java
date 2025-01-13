package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("DDDD","A","AA","AAA","DD","B","BB","BBBB","C","CC","CCC");
        // Sort as per lisy
        List<String> sortedList = list.stream().sorted((a,b)->a.length()-b.length()).toList();
        List<String> sortedList1 = list.stream().sorted((a,b)->b.length()-a.length()).toList();
        // Making custom comparator
        Comparator<String> comp = (a,b)->a.length()-b.length();
        List<String> sortedList2 = sortedList.stream().sorted(comp).toList();
        // min / Max -> retuens first min or max
        String ans = list.stream().max(comp).toString();
        System.out.println(sortedList);
        System.out.println(sortedList1);
        System.out.println(sortedList2);
        System.out.println(ans);

    }
}

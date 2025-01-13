package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("DDDD","A","AA","AAA","B","BB","BBB","C","CC","CCC");
        // Sort as per lisy
        List<String> sortedList = list.stream().sorted((a,b)->a.length()-b.length()).toList();
        List<String> sortedList1 = list.stream().sorted((a,b)->b.length()-a.length()).toList();
        System.out.println(sortedList);
        System.out.println(sortedList1);

    }
}

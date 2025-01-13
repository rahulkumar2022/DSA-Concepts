package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,1,200,500,22,1,3,-1,7,19);
        Integer max = numbers.stream().max((a,b)->Integer.compare(a, b)).get();
        Integer min = numbers.stream().min((a,b)->Integer.compare(a, b)).get();
        Integer min1 = numbers.stream().min((a,b)->a-b).get();
        Integer min2 = numbers.stream().min(Integer::compare).get();
        System.out.println("Minimum number is: " + min);
        System.out.println("Maximum number is: " + max);
        System.out.println("Maximum number is: " + min1);
        System.out.println("Maximum number is: " + min2);

    }
}

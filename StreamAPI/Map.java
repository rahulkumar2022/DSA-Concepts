package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        // Map the list of strings to uppercase
        // and collect them in a list
        // and print the list
        // Transform data
        List<String> list = Arrays.asList("Tom", "Tim", "Tina", "Tony", "Tom", "Tina");
        List<String> result = list.stream()
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());
            System.out.println(result);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> square = numbers.stream()
                .map(n -> n * n)
                .toList();
            System.out.println(square);

        List<Integer> marks = Arrays.asList(20,30,25, 35, 50, 60, 70, 80, 90);
        List<Integer> passed = marks.stream()
                                .filter(i -> i>35).toList();
        System.out.println(passed);
        List<Integer> grace = marks.stream().filter(i -> i<=35)
                                .map(i -> i+5).toList();
        System.out.println(grace);
        Long failedStudent = marks.stream().filter(i -> i<=35).count();
        System.out.println(failedStudent);

        

    }
    
}

package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        // Filter the list of strings that start with "T"
        // and convert them to uppercase
        // and remove duplicates
        // and sort them
        // and collect them in a list
        // and print the list
        // filterring data
        List<String> list = Arrays.asList("Tom", "Tim", "Tina", "Tony", "Tom", "Tina");
        List<String> result = list.stream()
                .filter(s -> s.startsWith("T"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
            System.out.println(result);
    }
    
}

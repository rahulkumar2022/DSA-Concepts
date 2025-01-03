package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample1 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
            Arrays.asList("Test","Test1","Test2","Test3","Rahul"),
            Arrays.asList("Test4","Test5","Test6"),
            Arrays.asList("Test7","Test","Test8","Test9")
        );

        // lists.stream()
        //     .flatMap(List::stream)
        //     .forEach(System.out::println);

        List<String> result = lists.stream()
                    .flatMap(List::stream)
                    .filter(s->s.startsWith("T"))
                    .map(String::toUpperCase)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}

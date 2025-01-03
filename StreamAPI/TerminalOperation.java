package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul","Test","Sorting","Filterring","Collect","Structure","Reflection");
        //names.stream().forEach(System.out::println);
        List<String> sName = names.stream().filter(name -> name.startsWith("S"))
                                .collect(Collectors.toList());
        //sName.forEach(System.out::println);

        //long count = names.stream().count();
        //System.out.println(count);
        Optional<String> firstName = names.stream().findFirst();
        firstName.ifPresent(System.out::println);
    }
}

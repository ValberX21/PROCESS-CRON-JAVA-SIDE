package firstpalace.processslice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestBasic {

    public static void main(String[] args) {

        String name=  "Alam harper";

        Runnable x1 = () -> System.out.println(name);

        x1.run();

        List<String> countries = new ArrayList<>(List.of("Brazil","United states","Mexico","Japan","Bolivia"));

        countries.forEach(System.out::println);

        List<String> findOne = countries.stream()
                .filter(c -> c.startsWith("B"))
                .toList();

        System.out.println("Found with B :" +findOne);
    }

}

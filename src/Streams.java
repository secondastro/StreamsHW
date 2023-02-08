import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> list = List.of("aaaa", "aa", "a po tyomnym ulitsam gulyaet dozhd'");
        findMinMax(list.stream(), String::compareTo, (min,max) ->
                System.out.printf("min: %s, max: %s", min, max));
        System.out.println();
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(findEven(integers));
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> objects = stream.sorted(order).collect(Collectors.toList());
        if (objects.isEmpty()) {
            minMaxConsumer.accept(null,null);
        } else {
            minMaxConsumer.accept(objects.get(0), objects.get(objects.size()-1));
        }

    }

    public static List<Integer> findEven(List<Integer> integerList) {
        return integerList.stream().filter(e -> e % 2 == 0).toList();
    }
}

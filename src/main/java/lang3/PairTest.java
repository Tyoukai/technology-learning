package lang3;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-30
 */
public class PairTest {
    public static void main(String[] args) {
        Pair<Long, Integer> pair1 = Pair.of(1L, 1);
        Pair<Long, Integer> pair2 = Pair.of(2L, 2);
        Pair<Long, Integer> pair3 = Pair.of(3L, 3);

        Set<Pair<Long, Integer>> set = new HashSet<>();
        set.add(pair1);
        set.add(pair2);
        set.add(pair3);

        System.out.println(pair1.toString());

        String s = Stream.of(set).map(Objects::toString).collect(Collectors.joining("_"));

        System.out.println(s);

    }
}

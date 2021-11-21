package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinerSplitterTest {
    public static void main(String[] args) {
        join();
        split();
    }

    private static Joiner joiner = Joiner.on("_");
    public static void join() {
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Bob");
        names.add("Tim");

        String str = joiner.join(names);
        System.out.println(str);

        str = names.stream()
                .map(s -> s.concat("@qq.com"))
                .collect(Collectors.joining(";"));
        System.out.println(str);

        Map<String, String> map = names.stream()
                .collect(Collectors.toMap(key -> key, value -> value + "@qq.com", (a, b) -> a));

        str = joiner.withKeyValueSeparator("=").join(map);
        System.out.println(str);
    }

    private static Splitter splitter = Splitter.on(";");
    public static void split() {
        String mails = "Tom@qq.com;Bob@qq.com;Tim@qq.com";

        List<String> mailList = splitter.splitToList(mails);
        System.out.println(mailList);

        Map<String, String> map = splitter.withKeyValueSeparator("@").split(mails);
        System.out.println(map);
    }
}

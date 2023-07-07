import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import java8.Person;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.curator.shaded.com.google.common.collect.Lists;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-15
 */
public class Test {
    public static void main(String[] args) throws ParseException, InterruptedException {



        Long a = 223244555L;
        Integer b = Integer.parseInt(a / 1000 + "");
        System.out.println(b == 223244);

        String date = "2023-02-16T07:15:25.359Z";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        df.setTimeZone(TimeZone.getTimeZone("UTC"));


        Date after = df.parse(date);

        System.out.println(DateFormatUtils.format(after, "yyyy-MM-dd HH:mm:ss"));

        String s = "2023-02-22 18:45:50.0";
        System.out.println(s.substring(0, s.length() - 2));


        String sss = "\r\n shddds \r\n sdsdsd sdsddsdiffc";

        sss = sss.replaceAll(" ", "");

        System.out.println(sss);
        System.out.println("==================");

        sss = sss.replaceAll("\r|\n", "");
        System.out.println(sss);


        System.out.println(DateUtils.parseDate("2023-05-31 14:19:29", "yyyy-MM-dd HH:mm:ss"));



        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        list = list.subList(0, 5);
    }
}

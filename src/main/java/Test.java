import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import cn.hutool.core.util.HashUtil;
import jackjson.ObjectMapperUtil;
import java8.Person;
import java8.extendTest.Son1;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.curator.shaded.com.google.common.collect.Lists;
import spring.extend.Father;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Math.abs(HashUtil.bkdrHash("172.16.19.173_172.16.65.137")) % 1000);
        System.out.println(StringUtils.equals(null, ""));
        Person person = new Person();
        person.setAge(12);
        Object personObj = ObjectMapperUtil.toJson(person);
        Person a = ObjectMapperUtil.fromJson(personObj, Person.class);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.contains(null));
    }
}

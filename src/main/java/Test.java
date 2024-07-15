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
        String a = "{\"name\":\"1\",\"nameOrigin\":\"1\",\"nameShow\":\"1\",\"value\":{\"1\":\"0\",\"2\":\"0\",\"3\":\"0.0\",\"4\":\"0.0\",\"5\":\"0.0\",\"6\":\"0.0\",\"7\":\"0.0\",\"8\":\"0.0\",\"9\":\"0.0\",\"10\":\"0.0\"}}";
        Set<String> set = new HashSet<>();
        set.add("172.16.66.14:8080");
        System.out.println(set.contains("172.16.66.14"));


        double currentFlowCountEma = 10251.672137122889;
        long addd = 121L;
        System.out.println(Double.parseDouble(String.format("%.1f", currentFlowCountEma)));
        System.out.println((double) addd);
    }
}

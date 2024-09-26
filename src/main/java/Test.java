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
        String metricDesc = "{\"ips\":[\"192.168.66.185\",\"172.19.12.186\",\"192.168.66.186\",\"41.29.2.185\",\"172.19.12.185\",\"41.29.2.186\"]}";
        Map<String, Object> metricDescMap = ObjectMapperUtil.fromJson(metricDesc, Map.class);
        List<String> a = (ArrayList) metricDescMap.get("ips");

    }
}

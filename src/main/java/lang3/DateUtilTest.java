package lang3;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @Author: Tyoukai
 * @Date: 2023/11/28 11:12
 */
public class DateUtilTest {
    public static void main(String[] args) {
        Date today = new Date();
        Date tomorrow = DateUtils.addDays(today, 1);
        String pattern = "yyyy.MM.dd";


        System.out.println("today:" + DateFormatUtils.format(today, pattern));
        System.out.println("tomorrow:" + DateFormatUtils.format(tomorrow, pattern));
    }
}

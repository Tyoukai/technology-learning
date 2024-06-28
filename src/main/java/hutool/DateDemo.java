package hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.HashUtil;

/**
 * @Author: Tyoukai
 * @Date: 2024/5/21 17:12
 */
public class DateDemo {
    public static void main(String[] args) {
        DateTime endDate = DateUtil.date();
        DateTime startDate = DateUtil.date().offset(DateField.HOUR, -24);
        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
        System.out.println(Math.abs(HashUtil.bkdrHash("0267f170fa3111e9bdcc00505685b6e9_02677a6afa3111e9bdcc00505685b6e9")) % 100);

    }
}

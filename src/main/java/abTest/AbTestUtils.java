package abTest;


import java.io.InputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class AbTestUtils {

    /**
     * abest比较
     *
     * @param aSupplier     原接口
     * @param bSupplier     新接口
     * @param convert       转换器
     * @param grayKey       灰度的key
     * @param comparable    新老接口的比较器
     * @param diffCallBack  新老接口有差异时的反馈函数
     * @param <T>
     * @param <R>
     * @return
     */
    public static<T, R> T doABTest(Supplier<T> aSupplier, Supplier<R> bSupplier, Function<R, T> convert,
            long grayKey, Comparator<T> comparable, BiConsumer<T, T> diffCallBack) {
        GrayConfig grayConfig = new GrayConfig(getConfig("grayConfig"));
        T result = null;
        R tmpResult = null;
        boolean hitGrayKey = false;
        if (grayConfig.hitGray(grayKey)) {
            hitGrayKey = true;
            tmpResult = bSupplier.get();
        } else {
            result = aSupplier.get();
        }

        // 命中灰度key，将新接口结果转换回老接口
        if (hitGrayKey) {
            result = convert.apply(tmpResult);
        }

        // 是否开启流量回放
        if (Boolean.parseBoolean(getConfig("trafficPlaybackSwitch"))) {
            flowPlayBack((hitGrayKey));
        }

        return result;
    }

    private static String getConfig(String key) {
        String value;
        try {
            Properties properties = new Properties();
            InputStream in = AbTestUtils.class.getClassLoader().getResourceAsStream("abTest.properties");
            properties.load(in);
            value = properties.getProperty(key);
        } catch (Exception e) {
            value = null;
            // ignore
        }
        return value;
    }

    private static void flowPlayBack(boolean hitGrayKey) {

    }
}

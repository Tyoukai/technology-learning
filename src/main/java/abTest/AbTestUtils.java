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
    public static<T, R> T doABTest(Supplier<T> aSupplier, Supplier<R> bSupplier, Function<T, R> convert,
            long grayKey, Comparator<T> comparable, BiConsumer<T, T> diffCallBack) {


        return null;
    }

    private String getConfig(String key) {
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
}

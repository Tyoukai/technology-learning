package abTest;


import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class AbTestHelper<T, R> {

    // 新老接口的比较器
    private Comparator<T> comparable;
    // 新老接口有差异时的反馈函数
    private BiConsumer<T, T> diffCallBack;
    // 新老接口返回值转换函数
    private Function<R, T> convert;

    public AbTestHelper(Comparator<T> comparable, BiConsumer<T, T> diffCallBack, Function<R, T> convert) {
        this.comparable = comparable;
        this.diffCallBack = diffCallBack;
        this.convert = convert;
    }

    /**
     * abest比较
     *
     * @param aSupplier     原接口
     * @param bSupplier     新接口
     * @param grayKey       灰度的key
     * @return
     */
    public T doABTest(Supplier<T> aSupplier, Supplier<R> bSupplier, int grayKey) {
        GrayConfig grayConfig = new GrayConfig(getConfig("grayConfig"));
        T result = null;
        R tmpResult = null;
        boolean hitGrayKey = false;
        if (grayConfig.hitGray(grayKey)) {
            hitGrayKey = true;
            tmpResult = bSupplier.get();
            System.out.println("命中灰度");
        } else {
            result = aSupplier.get();
            System.out.println("未命中灰度");
        }

        // 命中灰度key，将新接口结果转换回老接口
        if (hitGrayKey) {
            result = convert.apply(tmpResult);
        }

        // 是否开启流量回放
        if (Boolean.parseBoolean(getConfig("trafficPlaybackSwitch"))) {
            flowPlayBack(hitGrayKey, aSupplier, bSupplier, result);
        }

        return result;
    }

    private static String getConfig(String key) {
        String value;
        try {
            Properties properties = new Properties();
            InputStream in = AbTestHelper.class.getClassLoader().getResourceAsStream("abTest.properties");
            properties.load(in);
            value = properties.getProperty(key);
        } catch (Exception e) {
            value = null;
            // ignore
        }
        return value;
    }

    /**
     * 一般流量回放会放到一个线程池中异步执行，避免影响主流程响应
     *
     * @param hitGrayKey
     * @param aSupplier
     * @param bSupplier
     * @param result
     */
    private void flowPlayBack(boolean hitGrayKey, Supplier<T> aSupplier, Supplier<R> bSupplier, T result) {
        if (hitGrayKey) {
            T aResult = aSupplier.get();
            if (comparable.compare(aResult, result) != 0) {
                diffCallBack.accept(aResult, result);
            }
        } else {
            R bResult = bSupplier.get();
            T tmpResult = convert.apply(bResult);
            if (comparable.compare(result, tmpResult) != 0) {
                diffCallBack.accept(result, tmpResult);
            }
        }
    }
}

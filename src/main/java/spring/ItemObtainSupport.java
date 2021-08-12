package spring;

/**
 * 获取商品的抽象类
 */
public abstract class ItemObtainSupport {

    /**
     * 获取不同渠道的商品
     *
     * @param code
     * @return
     */
    public abstract String obtainItem(int code);

    /**
     * 校验商品
     *
     * @param code
     * @return
     */
    public boolean checkItem(int code) {
        return true;
    }
}

package com.springcloud.learning.others;

/**
 * 全局过滤器的执行顺序
 */
public enum GlobalFilterOrderEnum {
    PARAMETER_MAPPING(1, "参数映射"),
    GRPC_ROUTE(2, "grpc路由"),
    RESPONSE_WRITE(3, "response回写"),
    ;

    GlobalFilterOrderEnum(int order, String desc) {
        this.order = order;
        this.desc = desc;
    }
    private int order;
    private String desc;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

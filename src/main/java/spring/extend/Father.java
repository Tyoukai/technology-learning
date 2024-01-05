package spring.extend;

import javax.annotation.PostConstruct;

/**
 * @Author: Tyoukai
 * @Date: 2023/11/30 13:37
 */
public abstract class Father {

    @PostConstruct
    public void init() {
        System.out.println("init run!");
    }

}

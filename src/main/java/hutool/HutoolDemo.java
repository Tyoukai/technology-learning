package hutool;

import cn.hutool.core.util.HashUtil;

/**
 * @Author: Tyoukai
 * @Date: 2023/8/19 9:25
 */
public class HutoolDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(HashUtil.bkdrHash("src_16.98.12.6")) % 5000);
        System.out.println(Math.abs(HashUtil.bkdrHash("dst_16.98.12.6")) % 5000);


    }
}

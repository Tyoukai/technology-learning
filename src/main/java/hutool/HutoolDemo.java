package hutool;

import cn.hutool.core.util.HashUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Tyoukai
 * @Date: 2023/8/19 9:25
 */
public class HutoolDemo {

    static ExecutorService WORKER = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        System.out.println(Math.abs(HashUtil.bkdrHash("src_16.98.12.6")) % 5000);
        System.out.println(Math.abs(HashUtil.bkdrHash("dst_16.98.12.6")) % 5000);

        for (int i = 0; i < 50; i++) {
            WORKER.submit(() -> {
                while (true) {
                    int a = Math.abs(HashUtil.bkdrHash("src_16.98.12.6")) % 5000;
                    int b = Math.abs(HashUtil.bkdrHash("dst_16.98.12.6")) % 5000;
                    if (a != 2002) {
                        System.out.println("a:" + a);
                    }
                    if (b != 2209) {
                        System.out.println("b:" + b);
                    }
                }
            });
        }




    }
}

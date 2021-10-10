package com.springcloud.learning.others;

import reactor.core.publisher.Mono;

public class MonoDemo {

    public static void main(String[] args) {
//        doOnErrorOrSuccess();
//        map();
        then();
    }

    public static void fromCallable() {
        System.out.println("start:" + System.currentTimeMillis());
        Mono.fromCallable(() -> {
            return "a";
        }).subscribe(System.out::println);
    }

    public static void doOnErrorOrSuccess() {
        Mono.just(1.0)
                .map(n -> n / 10)
                .doOnError(e -> {
                    System.out.println("发生了错误");
                    e.printStackTrace();
                })
                .doOnSuccess(s -> {
                    System.out.println("执行成功:" + s);
                })
                .subscribe(System.out::println);
    }

    public static void publishOn() {

    }

    public static void map() {
        Mono a = Mono.just(1.0)
                .map(num -> num / 10)
                .map(num -> num / 10);
//                .subscribe(System.out::println);

        Mono b = Mono.just(1.0).flatMap(num -> Mono.just(num / 10));
    }

    public static void then() {
        Mono.just(1.0).then(Mono.just(2.0)).subscribe(System.out::println);
    }
}

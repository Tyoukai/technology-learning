package com.springcloud.learning.repository;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeCreated;

/**
 * 动态路由配置，存储介质zookeeper
 */
@Component
public class ZkRouteDefinitionRepository implements RouteDefinitionRepository, Watcher {

    private ZooKeeper zookeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private String host = "";
    private static final int SESSION_TIME_OUT = 2000;
    private String path = "/gateway";

    @PostConstruct
    public void init() {
        try {
            zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("zookeeper connection success");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
        // gateway路由所在节点
        if (path.equals(watchedEvent.getPath())) {
            switch (watchedEvent.getType()) {
                // 数据改变时，重新更新所有路由信息
                case NodeDataChanged:
                    break;
            }
        }

    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return null;
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }

}

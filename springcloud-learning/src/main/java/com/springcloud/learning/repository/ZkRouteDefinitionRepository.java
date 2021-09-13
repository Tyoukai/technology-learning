package com.springcloud.learning.repository;

import com.springcloud.learning.utils.ObjectMapperUtils;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * 动态路由配置，存储介质zookeeper
 */
@Component
public class ZkRouteDefinitionRepository implements RouteDefinitionRepository, Watcher, ApplicationEventPublisherAware {

    private ZooKeeper zookeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private String host = "42.192.49.234:2181";
    private static final int SESSION_TIME_OUT = 2000;
    private String path = "/gateway";
    private ApplicationEventPublisher applicationEventPublisher;

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
        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();
        String path = watchedEvent.getPath();
        // 连接创建
        if (Event.KeeperState.SyncConnected == state) {
            System.out.println("11111111");
            countDownLatch.countDown();
            return;
        }

        try {
            // 新增或修改路由
            if (path.contains(this.path) && (type == Event.EventType.NodeCreated || type == Event.EventType.NodeDataChanged )) {
                System.out.println(new String(zookeeper.getData(path, false, null)));
                applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        try {
            byte[] data = zookeeper.getData(path, false, null);
            String allRoute = new String(data);
            routeDefinitions = ObjectMapperUtils.fromJson(allRoute, RouteDefinition.class, List.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            try {
                String data = ObjectMapperUtils.toJson(routeDefinition);
                zookeeper.setData(path, data.getBytes(), -1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

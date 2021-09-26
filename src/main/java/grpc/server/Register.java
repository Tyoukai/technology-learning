package grpc.server;

/**
 * grpc 服务注册到zk
 */
public interface Register {
    String connectString = "42.192.49.234:2181";

    String registerPath = "/grpc/server/";

    /**
     * 服务注册到zk
     */
     void register();

    /**
     * 返回服务的名称
     *
     * @return
     */
    String getServiceName();
}

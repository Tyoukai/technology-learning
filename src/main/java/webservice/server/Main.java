package webservice.server;

import javax.xml.ws.Endpoint;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/9 9:11
 */
public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8085/ws_server/weather", new WeatherServiceImpl());
        System.out.println("发布天气服务成功...");
    }
}

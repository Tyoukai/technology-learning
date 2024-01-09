package webservice.client.webservice.server;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/9 9:26
 */
public class ClientTest {
    public static void main(String[] args) {
        WeatherServiceImplService factory = new WeatherServiceImplService();
        WeatherServiceImpl servicePort = factory.getWeatherServiceImplPort();
        String weather = servicePort.getWeatherByCityname("深圳");
        System.out.println(weather);
    }
}

package webservice.server;

import javax.jws.WebService;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/9 9:15
 */
@WebService
public class WeatherServiceImpl implements WeatherService {
    @Override
    public String getWeatherByCityname(String name) {
        return name;
    }
}

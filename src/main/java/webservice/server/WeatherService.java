package webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/9 9:12
 */


@WebService
public interface WeatherService {

    @WebMethod
    String getWeatherByCityname(String name);

}


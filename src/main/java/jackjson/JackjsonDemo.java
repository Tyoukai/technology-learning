package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Iterator;

/**
 * @author Echo
 * @Date 2023/1/9 10:12
 */
public class JackjsonDemo {

    public static void main(String[] args) throws JsonProcessingException, ParseException {
        ObjectMapper mapper = new ObjectMapper();

        String strJson = "{\n" +
                "        \"datasourceId\":\"1\",\n" +
                "        \"metricId\":\"2\",\n" +
                "        \"key\": \"totalCount\",\n" +
                "        \"alias\": \"总成交量\"\n" +
                "    }";

        JsonNode jsonNode = mapper.readTree(strJson);


        System.out.println(jsonNode.get("orderBy") == null);

        System.out.println(DateUtils.parseDate("2023-04-23 19:33:31.0", "yyyy-MM-dd HH:mm:ss.SSS"));
    }
}

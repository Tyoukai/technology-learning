package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws JsonProcessingException, ParseException {
        String str = "{\"app\":\"dashboard\",\"requestId\":\"Q191\",\"timezone\":\"browser\",\"panelId\":2,\"dashboardId\":166,\"range\":{\"from\":\"2023-03-09T00:16:51.432Z\",\"to\":\"2023-03-09T06:16:51.432Z\",\"raw\":{\"from\":\"now-6h\",\"to\":\"now\"}},\"timeInfo\":\"\",\"interval\":\"30s\",\"intervalMs\":30000,\"targets\":[{\"data\":[{\"datasourceId\":\"1\",\"metricIds\":[2]}],\"refId\":\"A\",\"target\":\"智能运维统一指标\",\"type\":\"timeseries\",\"datasource\":\"智能运维数据源\"}],\"maxDataPoints\":572,\"scopedVars\":{\"__interval\":{\"text\":\"30s\",\"value\":\"30s\"},\"__interval_ms\":{\"text\":\"30000\",\"value\":30000}},\"startTime\":1678342611434,\"rangeRaw\":{\"from\":\"now-6h\",\"to\":\"now\"},\"adhocFilters\":[]}";
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode databaseJson = objectMapper.readTree(str);

        String startTime = databaseJson.get("range").get("from").asText();
        String endTime = databaseJson.get("range").get("to").asText();

        JsonNode targets = databaseJson.get("targets");
        Iterator<JsonNode> targetsIterator = targets.elements();
        while (targetsIterator.hasNext()) {
            JsonNode target = targetsIterator.next();
            JsonNode data = target.get("data");

            Iterator<JsonNode> iterator = data.elements();
            while (iterator.hasNext()) {
                JsonNode config = iterator.next();
                String datasourceId = config.get("datasourceId").asText();
                List<String> metricIds = new ArrayList<>();
                Iterator<JsonNode> metricsIterator = config.get("metricIds").elements();
                while (metricsIterator.hasNext()) {
                    metricIds.add(metricsIterator.next().asText());
                    convertTime(startTime);
                    convertTime(endTime);
                }
            }
        }

    }

    private static String convertTime(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = dateFormat.parse(time);
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }
}

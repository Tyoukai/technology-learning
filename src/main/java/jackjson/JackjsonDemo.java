package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

/**
 * @author Echo
 * @Date 2023/1/9 10:12
 */
public class JackjsonDemo {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String strJson = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"zabbix\",\n" +
                "      \"name_show\": \"zabbix-线上\",\n" +
                "      \"data_source_type\": \"4\",\n" +
                "      \"collection_type\": \"2\",\n" +
                "      \"resource_desc\": \"{\\\"address\\\":\\\"172.16.66.14:9092,172.16.66.17:9092,172.16.66.18:9092\\\",\\\"topic\\\":\\\"test-online\\\"}\",\n" +
                "      \"create_time\": \"1672725702205\",\n" +
                "      \"update_time\": \"1672725702208\",\n" +
                "      \"is_delete\": \"0\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"database\": \"cmdbtest\",\n" +
                "  \"es\": 1673231678000,\n" +
                "  \"id\": 3386,\n" +
                "  \"isDdl\": false,\n" +
                "  \"mysqlType\": {\n" +
                "    \"id\": \"int\",\n" +
                "    \"name\": \"varchar(150)\",\n" +
                "    \"name_show\": \"varchar(256)\",\n" +
                "    \"data_source_type\": \"int\",\n" +
                "    \"collection_type\": \"int\",\n" +
                "    \"resource_desc\": \"text\",\n" +
                "    \"create_time\": \"bigint\",\n" +
                "    \"update_time\": \"bigint\",\n" +
                "    \"is_delete\": \"int\"\n" +
                "  },\n" +
                "  \"old\": [\n" +
                "    {\n" +
                "      \"resource_desc\": \"{\\n    \\\"address\\\":\\\"172.16.66.14:9092,172.16.66.17:9092,172.16.66.18:9092\\\",\\n    \\\"topic\\\":\\\"test-online\\\"\\n}\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"pkNames\": [\n" +
                "    \"id\"\n" +
                "  ],\n" +
                "  \"sql\": \"\",\n" +
                "  \"sqlType\": {\n" +
                "    \"id\": 4,\n" +
                "    \"name\": 12,\n" +
                "    \"name_show\": 12,\n" +
                "    \"data_source_type\": 4,\n" +
                "    \"collection_type\": 4,\n" +
                "    \"resource_desc\": 2005,\n" +
                "    \"create_time\": -5,\n" +
                "    \"update_time\": -5,\n" +
                "    \"is_delete\": 4\n" +
                "  },\n" +
                "  \"table\": \"om_data_sources\",\n" +
                "  \"ts\": 1673232663265,\n" +
                "  \"type\": \"UPDATE\"\n" +
                "}";

        JsonNode jsonNode = mapper.readTree(strJson);

        JsonNode dataNode = jsonNode.get("data");
        Iterator<JsonNode> iterator = dataNode.elements();
        while (iterator.hasNext()) {
            JsonNode tableData = iterator.next();
            System.out.println("id:" + tableData.get("id").asText());
            System.out.println("name:" + tableData.get("name").asText());

            String resourceDesc = tableData.get("resource_desc").asText();

            mapper.readTree(resourceDesc);
            System.out.println("address:" + mapper.readTree(resourceDesc).get("address").asText());
        }
        String tableName = jsonNode.get("table").asText();
        String type = jsonNode.get("type").asText();

        System.out.println("tableName:" + tableName);
        System.out.println("type:" + type);
    }
}

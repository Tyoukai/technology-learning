package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-06
 */
public class HashCodeTest {
    public static void main(String[] args) throws JsonProcessingException {
        String s = "E20210406180527001504195";

        System.out.println(s.hashCode());

        ObjectMapper mapper = new ObjectMapper();

        String str = "{\"flowId\":\"183870eabac2f507ec8f3614abfb8a86\",\"templateId\":\"17152bb2ad9a4a9de43faaa4bae933ba\",\"source\":\"\",\"nodeType\":\"approval\",\"timestamp\":1664418261981,\"data\":{\"currentHandlerName\":\" 鲁雄锋\",\"currentHandlerId\":\"15aecaa496471ef76e4aeaf44569a357\",\"currentNotifyNode\":\"N2.起草节点\",\"status\":\"submit\"}}";

        JsonNode node = mapper.readTree(str);
        JsonNode dataNode = node.get("data");
        System.out.println(dataNode.get("status").asText());

    }
}

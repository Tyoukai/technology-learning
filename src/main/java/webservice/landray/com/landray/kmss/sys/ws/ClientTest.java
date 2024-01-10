package webservice.landray.com.landray.kmss.sys.ws;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/9 10:00
 */
public class ClientTest {
    public static void main(String[] args) {
        IEkpWorkflowWebServiceService factory = new IEkpWorkflowWebServiceService();
        IEkpWorkflowWebService service = factory.getIEkpWorkflowWebServicePort();
        String result = service.doCommitWorkItem("ningfeng", "18cd23a6e8d5a3ed3f101d943d8b6773", "handler_pass", null, null, null, null, null);
        System.out.println("result:" + result);
    }
}

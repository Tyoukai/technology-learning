
package webservice.landray.com.landray.kmss.sys.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IEkpWorkflowWebServiceService", targetNamespace = "http://ws.sys.kmss.landray.com/", wsdlLocation = "http://172.19.65.1:801/sys/webservice/ekpWorkflowWebService?wsdl")
public class IEkpWorkflowWebServiceService
    extends Service
{

    private final static URL IEKPWORKFLOWWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException IEKPWORKFLOWWEBSERVICESERVICE_EXCEPTION;
    private final static QName IEKPWORKFLOWWEBSERVICESERVICE_QNAME = new QName("http://ws.sys.kmss.landray.com/", "IEkpWorkflowWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.19.65.1:801/sys/webservice/ekpWorkflowWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IEKPWORKFLOWWEBSERVICESERVICE_WSDL_LOCATION = url;
        IEKPWORKFLOWWEBSERVICESERVICE_EXCEPTION = e;
    }

    public IEkpWorkflowWebServiceService() {
        super(__getWsdlLocation(), IEKPWORKFLOWWEBSERVICESERVICE_QNAME);
    }

    public IEkpWorkflowWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IEKPWORKFLOWWEBSERVICESERVICE_QNAME, features);
    }

    public IEkpWorkflowWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, IEKPWORKFLOWWEBSERVICESERVICE_QNAME);
    }

    public IEkpWorkflowWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IEKPWORKFLOWWEBSERVICESERVICE_QNAME, features);
    }

    public IEkpWorkflowWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IEkpWorkflowWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IEkpWorkflowWebService
     */
    @WebEndpoint(name = "IEkpWorkflowWebServicePort")
    public IEkpWorkflowWebService getIEkpWorkflowWebServicePort() {
        return super.getPort(new QName("http://ws.sys.kmss.landray.com/", "IEkpWorkflowWebServicePort"), IEkpWorkflowWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEkpWorkflowWebService
     */
    @WebEndpoint(name = "IEkpWorkflowWebServicePort")
    public IEkpWorkflowWebService getIEkpWorkflowWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sys.kmss.landray.com/", "IEkpWorkflowWebServicePort"), IEkpWorkflowWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IEKPWORKFLOWWEBSERVICESERVICE_EXCEPTION!= null) {
            throw IEKPWORKFLOWWEBSERVICESERVICE_EXCEPTION;
        }
        return IEKPWORKFLOWWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
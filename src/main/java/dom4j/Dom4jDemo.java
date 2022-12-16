package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * @author Echo
 * @Date 2022/12/16 13:53
 */
public class Dom4jDemo {
    private static  String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<java version=\"1.8.0_265\" class=\"java.beans.XMLDecoder\">\n" +
            " <object class=\"java.util.HashMap\">\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a0fc15e03fab2</string>\n" +
            "   <object class=\"java.util.HashMap\">\n" +
            "    <void method=\"put\">\n" +
            "     <string>name</string>\n" +
            "     <string>鲁雄锋</string>\n" +
            "    </void>\n" +
            "    <void method=\"put\">\n" +
            "     <string>id</string>\n" +
            "     <string>15aecaa496471ef76e4aeaf44569a357</string>\n" +
            "    </void>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>attrCiName</string>\n" +
            "   <string>测试22</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a030486eb9d7e</string>\n" +
            "   <string>自研发</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_38_</string>\n" +
            "   <string>测试22</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_165_</string>\n" +
            "   <string></string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_115_</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_48_</string>\n" +
            "   <string>chencp1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>attrCiId</string>\n" +
            "   <string>测试22</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>network</string>\n" +
            "   <string>测试22</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_34_</string>\n" +
            "   <null/>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_33_</string>\n" +
            "   <string>否</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_22__text</string>\n" +
            "   <string>集中交易</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_51_</string>\n" +
            "   <string>luxf1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_71_</string>\n" +
            "   <string>本地备份</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_5_</string>\n" +
            "   <string>二类</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a0fbe23f10ff4</string>\n" +
            "   <object class=\"java.util.HashMap\">\n" +
            "    <void method=\"put\">\n" +
            "     <string>name</string>\n" +
            "     <string>陈传鹏</string>\n" +
            "    </void>\n" +
            "    <void method=\"put\">\n" +
            "     <string>id</string>\n" +
            "     <string>1541acbd8ab8a8206dbb16046b2b3e82</string>\n" +
            "    </void>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_74__text</string>\n" +
            "   <string>经纪业务集中交易系统</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_27_</string>\n" +
            "   <string>P2</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_39ff2846831c6a</string>\n" +
            "   <string>success</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_37_</string>\n" +
            "   <string>否</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_45_</string>\n" +
            "   <string>A 客户服务类</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_89_</string>\n" +
            "   <string>2</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_22_</string>\n" +
            "   <string>集中交易</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_74_</string>\n" +
            "   <string>经纪业务集中交易系统</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a030486eb9d7e_text</string>\n" +
            "   <string>自研发</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_50_</string>\n" +
            "   <string>敏态</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>col_72_</string>\n" +
            "   <string>三级</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_39ff0eb5def15a</string>\n" +
            "   <object class=\"java.util.Date\">\n" +
            "    <long>1670256000000</long>\n" +
            "   </object>\n" +
            "  </void>\n" +
            " </object>\n" +
            "</java>\n";

    public static void main(String[] args) throws DocumentException {
        Document doc =DocumentHelper.parseText(XML);
        Element javaElement = doc.getRootElement();
        System.out.println("根节点：" + javaElement.getName());

        List<Element> elementList = javaElement.elements();
        for(Element e : elementList) {
            System.out.println(e.getName());
        }

        Element objectElement = javaElement.element("object");
        List<Element> voidElementList = objectElement.elements("void");



    }
}

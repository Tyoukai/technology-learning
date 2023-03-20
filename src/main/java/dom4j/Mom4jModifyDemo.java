package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author: Tyoukai
 * @Date: 2023/3/20 10:43
 */
public class Mom4jModifyDemo {
    public static void main(String[] args) throws DocumentException, IOException {
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<java version=\"1.8.0_265\" class=\"java.beans.XMLDecoder\">\n" +
//                "    <object class=\"java.util.HashMap\">\n" +
//                "        <void method=\"put\">\n" +
//                "            <string>fd_qr_url</string>\n" +
//                "            <string>http://pangu.cjsctest.com.cn:5001/api/pangu/fixedAssetsPutInStorage/serialQRZip?processId=186e97994489a042141d40749caab5ed</string>\n" +
//                "        </void>\n" +
//                "        <void method=\"put\">\n" +
//                "            <string>mxb_id_index_</string>\n" +
//                "            <object class=\"java.util.HashMap\">\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_sbtzm</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_zcmc</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_cfswdd</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_cfbm</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_wdip</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_jgbh</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_jgwz</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "                <void method=\"put\">\n" +
//                "                    <string>fd_sbbqh</string>\n" +
//                "                    <null/>\n" +
//                "                </void>\n" +
//                "            </object>\n" +
//                "        </void>\n" +
//                "        <void method=\"put\">\n" +
//                "            <string>mxb_id</string>\n" +
//                "            <object class=\"java.util.ArrayList\">\n" +
//                "                <void method=\"add\">\n" +
//                "                    <object class=\"java.util.HashMap\">\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_sbtzm</string>\n" +
//                "                            <string>2222</string>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_zcmc</string>\n" +
//                "                            <string>测试资产</string>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_cfswdd</string>\n" +
//                "                            <string>天津IDC机房</string>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fdId</string>\n" +
//                "                            <string>186e979954c28553961862a421991401</string>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_cfbm</string>\n" +
//                "                            <string>信息技术总部</string>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_wdip</string>\n" +
//                "                            <null/>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_jgbh</string>\n" +
//                "                            <null/>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_jgwz</string>\n" +
//                "                            <null/>\n" +
//                "                        </void>\n" +
//                "                        <void method=\"put\">\n" +
//                "                            <string>fd_sbbqh</string>\n" +
//                "                            <string>90202200333</string>\n" +
//                "                        </void>\n" +
//                "                    </object>\n" +
//                "                </void>\n" +
//                "            </object>\n" +
//                "        </void>\n" +
//                "    </object>\n" +
//                "</java>";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<students> \n" +
                "  <student id=\"3333\" phone=\"15888888888\" sex=\"男\"> \n" +
                "    <name>张三</name>  \n" +
                "    <age>18</age>  \n" +
                "    <school>清华</school> \n" +
                "  </student>  \n" +
                "  <student id=\"99999\" phone=\"15999999999\" sex=\"女\"> \n" +
                "    <name>李四</name>  \n" +
                "    <age>28</age>  \n" +
                "    <school>北大</school> \n" +
                "  </student>  \n" +
                "  <AAAA> \n" +
                "    <aa1>aa111</aa1>  \n" +
                "    <aa2>aa222</aa2> \n" +
                "  </AAAA>  \n" +
                "  <BBBB/> \n" +
                "  <void method=\"put\">\n" +
                "\t<string>fd_cfswdd</string>\n" +
                "\t<null/>\n" +
                "  </void>\n" +
                "</students>";
        Document doc = DocumentHelper.parseText(xml);
        Element voidElement= doc.getRootElement().element("void");;
        Element stringElement = voidElement.element("string");
        stringElement.setText("1qaazz");
        Element nullElement = voidElement.element("null");
        nullElement.detach();
        Element newStringElement = voidElement.addElement("string");
        newStringElement.addText("11223ddsse24dddd");


//        //指定文件输出的位置
//        FileOutputStream out =new FileOutputStream("E:/student.xml");
//        // 指定文本的写出的格式：
//        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
//        format.setEncoding("UTF-8");
//        //1.创建写出对象
//        XMLWriter writer=new XMLWriter(out,format);
//        //2.写出Document对象
//        writer.write(doc);
//        //3.关闭流
//        writer.close();
        System.out.println(doc.asXML());

    }
}

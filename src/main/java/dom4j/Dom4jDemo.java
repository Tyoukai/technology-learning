package dom4j;

import org.dom4j.*;

import java.util.List;

/**
 * @author Echo
 * @Date 2022/12/16 13:53
 */
public class Dom4jDemo {
    private static  String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<java version=\"1.7.0_79\" class=\"java.beans.XMLDecoder\">\n" +
            " <object class=\"java.util.HashMap\">\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bfaa8549c3a</string>\n" +
            "   <string>张珂为-技术组成员</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917fc8207a28</string>\n" +
            "   <string>0</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917ffda861ec</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be7cf8e288a</string>\n" +
            "   <object class=\"java.util.ArrayList\">\n" +
            "    <void method=\"add\">\n" +
            "     <object class=\"java.util.HashMap\">\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5bfbf9c855ce</string>\n" +
            "       <object class=\"java.util.HashMap\">\n" +
            "        <void method=\"put\">\n" +
            "         <string>id</string>\n" +
            "         <string>141112c05e9be33cb1793fb4b95846b0</string>\n" +
            "        </void>\n" +
            "        <void method=\"put\">\n" +
            "         <string>name</string>\n" +
            "         <string>长江保荐</string>\n" +
            "        </void>\n" +
            "       </object>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fdId</string>\n" +
            "       <string>18519e5f65c6d42304ec0f5456bb5d14</string>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5beac5380b36</string>\n" +
            "       <string>备注1</string>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5bea90ecc37a</string>\n" +
            "       <double>50.0</double>\n" +
            "      </void>\n" +
            "     </object>\n" +
            "    </void>\n" +
            "    <void method=\"add\">\n" +
            "     <object class=\"java.util.HashMap\">\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5bfbf9c855ce</string>\n" +
            "       <object class=\"java.util.HashMap\">\n" +
            "        <void method=\"put\">\n" +
            "         <string>id</string>\n" +
            "         <string>1411138cf2f89c6fa3427db4da783ee7</string>\n" +
            "        </void>\n" +
            "        <void method=\"put\">\n" +
            "         <string>name</string>\n" +
            "         <string>长江证券行政序列_中后台部门_法律合规部</string>\n" +
            "        </void>\n" +
            "       </object>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fdId</string>\n" +
            "       <string>18519e5f65cffa2eeafd245445fae604</string>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5beac5380b36</string>\n" +
            "       <string>备注2</string>\n" +
            "      </void>\n" +
            "      <void method=\"put\">\n" +
            "       <string>fd_3a5bea90ecc37a</string>\n" +
            "       <double>50.0</double>\n" +
            "      </void>\n" +
            "     </object>\n" +
            "    </void>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917fa74d35d8</string>\n" +
            "   <string>项目筛选表</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be502e328bc</string>\n" +
            "   <string>立项原因说明</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf8d7db18d2</string>\n" +
            "   <string>1、完成阶段目标1&#13;\n" +
            "2、完成阶段目标2</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be33bc763b4</string>\n" +
            "   <object class=\"java.util.HashMap\">\n" +
            "    <void method=\"put\">\n" +
            "     <string>id</string>\n" +
            "     <string>141116326e34bd3e3fdd44646b5a06cd</string>\n" +
            "    </void>\n" +
            "    <void method=\"put\">\n" +
            "     <string>name</string>\n" +
            "     <string>长江期货_公司领导</string>\n" +
            "    </void>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bfa2a050850</string>\n" +
            "   <string>张珂为-项目经理</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a7484e4ad28c2</string>\n" +
            "   <string>2</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be19e11779c</string>\n" +
            "   <string>项目立项申请表</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917fffc3cfe6</string>\n" +
            "   <string>0</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bee9adcd874</string>\n" +
            "   <string>table_1_start</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a75eef5b45150</string>\n" +
            "   <string>table_1_end</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917fb88dd9a4</string>\n" +
            "   <string>0</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917ffd503c9e</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf7946aa642</string>\n" +
            "   <string>时间</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf6ed941708</string>\n" +
            "   <object class=\"java.math.BigDecimal\">\n" +
            "    <string>14475</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917ffeca7af2</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf81b069702</string>\n" +
            "   <object class=\"java.util.Date\">\n" +
            "    <long>1671120000000</long>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917ffe753544</string>\n" +
            "   <string>0</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be2c2f91624</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bfa72c1fffe</string>\n" +
            "   <string>张珂为-业务代表</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_4_2</string>\n" +
            "   <object class=\"java.math.BigDecimal\">\n" +
            "    <string>111</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_4_3</string>\n" +
            "   <string>备注5</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_4_1</string>\n" +
            "   <string>资本性支出-长期待摊费用</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a917fff4978e4</string>\n" +
            "   <string>1</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be6dc149664</string>\n" +
            "   <string>项目成本分摊方式</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be7cf8e288a_index_</string>\n" +
            "   <object class=\"java.util.HashMap\">\n" +
            "    <void method=\"put\">\n" +
            "     <string>fd_3a5bfbf9c855ce</string>\n" +
            "     <null/>\n" +
            "    </void>\n" +
            "    <void method=\"put\">\n" +
            "     <string>fd_3a5beac5380b36</string>\n" +
            "     <null/>\n" +
            "    </void>\n" +
            "    <void method=\"put\">\n" +
            "     <string>fd_3a5bea90ecc37a</string>\n" +
            "     <null/>\n" +
            "    </void>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bfa9a054ba6</string>\n" +
            "   <string>张珂为-技术代表</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf89d63cf74</string>\n" +
            "   <object class=\"java.util.Date\">\n" +
            "    <long>1672329600000</long>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_3_3</string>\n" +
            "   <string>备注3</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_3_1</string>\n" +
            "   <string>资本性支出-硬件</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bf9c7dd57f8</string>\n" +
            "   <string>人员</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_3_2</string>\n" +
            "   <object class=\"java.math.BigDecimal\">\n" +
            "    <string>22</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_2_1</string>\n" +
            "   <string>资本性支出-软件</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_1_3</string>\n" +
            "   <string>明细</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_1_1</string>\n" +
            "   <string>类别</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_1_2</string>\n" +
            "   <string>金额（万元）</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_2_2</string>\n" +
            "   <object class=\"\t\">\n" +
            "    <string>100</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_2_3</string>\n" +
            "   <string>备注4</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bfa5d96c1ea</string>\n" +
            "   <string>张珂为-业务组成员</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_5_2</string>\n" +
            "   <object class=\"java.math.BigDecimal\">\n" +
            "    <string>2121</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_5_1</string>\n" +
            "   <string>费用性支出-技术开发费用</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5bee6c0a58c4</string>\n" +
            "   <string>项目资源</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_5_3</string>\n" +
            "   <string>备注6</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a7674e35f4d6a</string>\n" +
            "   <string>1、因财务总部对项目预算资本性支出与费用化支出严格分类管控，请在提交预算金额时尽量预估准确。/n2、长期分摊费用：折旧年限在1年以上（不含1年）的各项费用。如一次性支付1年以上的费用。/n3、费用性支出：折旧年限在一年以下（含1年）的各项费用。</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_6_3</string>\n" +
            "   <string>备注7</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_6_2</string>\n" +
            "   <object class=\"java.math.BigDecimal\">\n" +
            "    <string>12121</string>\n" +
            "   </object>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be25815d65c</string>\n" +
            "   <string>原始项目立项测试</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3a5be5d6d4c492</string>\n" +
            "   <string>立项目标说明</string>\n" +
            "  </void>\n" +
            "  <void method=\"put\">\n" +
            "   <string>fd_3_6_1</string>\n" +
            "   <string>费用性支出-其他费用</string>\n" +
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

        for (Element element : voidElementList) {
//            System.out.println(element.attribute("method").getData());
            List<Element> strElements = element.elements("string");
            if (strElements.size() == 2) {
                System.out.println("===========");
                System.out.println(strElements.get(0).getTextTrim());
                System.out.println(strElements.get(1).getTextTrim());
            }

            List<Element> objElements = element.elements("object");
            if (objElements.size() == 1) {
                Attribute attribute = objElements.get(0).attribute("class");
                if (attribute.getData().equals("java.math.BigDecimal")) {
                    System.out.println("数值类型：" + objElements.get(0).element("string").getData() );
                }
            }
        }




    }
}

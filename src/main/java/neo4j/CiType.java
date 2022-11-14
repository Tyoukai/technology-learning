package neo4j;

import org.neo4j.graphdb.Label;

/**
 * @author Echo
 * @Date 2022/11/12 20:12
 */
public enum CiType implements Label {
    UNKNOW("-1"),
    物理服务器("04236db002c34f8897dc47ea48a96f32"),
    交换机("072a4c9061df47b199ec78b8aa440635"),
    人员("0a6f1c75c10743188f0b143414d7e2db"),
    域名("145e8dca6634442487cef97f6b813a57"),
    网络("25a9a3cbc3e34a2bb2f196ac56240f7a"),
    防火墙连接("28f7fa949ff347f092ed6d9ab38f3f36"),
    盘古("2b0ee28af5314de180ec0daf957559d7"),
    负载均衡实服务("3d22473fe3044a87b415a39b9482caf8"),
    数据库("3eb08b6925804889a741d789423483c2"),
    工位信息("424d2bdb2e024774ab2dd69aad0ee8f6"),
    存储("5d778683a387492a8b2f512b8ffbdae3"),
    应用模块("6e2534a1166a4a40b742bf1cb6a63378"),
    虚拟服务器("7088c4d031d64eaa85d4033561800d4e"),
    基础资源("951b5bfef2b74d4cbf4c895ba0c1bc1a"),
    服务组("99649e4bbf5b4cf695ece718d6582b13"),
    ip网段信息("9d7745c1a4e149c7b84a43f04f02a896"),
    图书("a615f8b45cbf4c4f951736ba5aa9a1e9"),
    互联网IP地址("a6da671a33e74b6a83c169a6022b7665"),
    IP地址("b09aa16560f44e6da01ea73c91f35726"),
    机柜("b469c4ab86be488ebd6ab6cfa5f3f202"),
    网络接口("be2b79bb4b16428ba1075fc83ce684af"),
    互联网服务("c360b79cc4e944209abc26e769ee47c3"),
    FEX交换机("d2954f90b43340a5bbd7691935c964ff"),
    端口IP组("d8c83675dc8f41e7ad2a28238ea0425d"),
    负载均衡虚服务("dbfc8af92f194ace9bc1b2b5624231c7"),
    证书与授权("dc109c0b08d244b6b530f62ab3bb61d7"),
    网络线路("dd969e9627a54843b8c7fc25a04af7da"),
    网络监控设备("dfe0c45f780740bc8078d395d52f2f00"),
    应用系统("f066f847f866410787d961301f8bb98a"),
    系统和软件("fa89086c039f4e10bc260995fc9be1b9"),
    测试环境公网端口映射("fc39eb7ce65343868f4d5bc312397080"),
    交换机接口("fc39eb7ce65343868f4d5bc319b89708"),
    ;

    private String id;

    CiType(String id) {
        this.id = id;
    }

    public static CiType getType(String id) {
        for (CiType type : values()) {
            if (type.id.equals(id)) {
                return type;
            }
        }

        return UNKNOW;
    }

}

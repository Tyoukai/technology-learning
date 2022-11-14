package neo4j;

import org.neo4j.graphdb.RelationshipType;

/**
 * @author Echo
 * @Date 2022/11/12 20:37
 */
public enum CiRelationType implements RelationshipType {
    UNKNOW("-1"),
    备份("07992efe8b1d4424834745727144e255"),
    组成("0d2f76c5e213450cb70bb365cc4fbcd0"),
    访问("1472c132cac749429cedb22b0b8a25a9"),
    使用("155aa125bc124fd3af79b596b3503f75"),
    安装部署("a14cb829ef844eebb22384e13a7a4c91"),
    依赖("a97bff564c8041aaa0496284c4865e43"),
    运行于("b97121620a984558a7d6ef2886a7f172"),
    连接("f439f511cec343199bd7b73fa6371435"),
    ;

    private String id;

    CiRelationType(String id) {
        this.id = id;
    }

    public static CiRelationType getType(String id) {
        for (CiRelationType type : values()) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return UNKNOW;
    }

}

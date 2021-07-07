package mapStructure;

import java.util.Collections;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-07-07
 */
public class Main {
    public static void main(String[] args) {
        Source source = new Source();
        source.setAge(11);
        source.setName("zkw");
        source.setCreateTime(2333L);
        source.setId(1);

        SubObjectSource subObject = new SubObjectSource();
        subObject.setSubAge(12);
        subObject.setSubName("subObject");
        subObject.setSex(true);

        source.setSubObjectSource(Collections.singletonList(subObject));

        Target target = ConvertMapper.INSTANCE.toTarget(source);

        System.out.println(target);
    }
}

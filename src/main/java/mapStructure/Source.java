package mapStructure;

import java.util.List;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-07-07
 */
public class Source extends Base {
    String name;

    int age;

    List<SubObjectSource> subObjectSource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SubObjectSource> getSubObjectSource() {
        return subObjectSource;
    }

    public void setSubObjectSource(List<SubObjectSource> subObjectSource) {
        this.subObjectSource = subObjectSource;
    }
}

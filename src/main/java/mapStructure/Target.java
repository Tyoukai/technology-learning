package mapStructure;

import java.util.List;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-07-07
 */
public class Target {
    int id;
    long createTime;
    String name;
    int age;

    List<SubObjectTarget> subObjectTarget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

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

    public List<SubObjectTarget> getSubObjectTarget() {
        return subObjectTarget;
    }

    public void setSubObjectTarget(List<SubObjectTarget> subObjectTarget) {
        this.subObjectTarget = subObjectTarget;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", subObjectTarget=" + subObjectTarget +
                '}';
    }
}

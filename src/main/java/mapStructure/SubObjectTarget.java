package mapStructure;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-07-07
 */
public class SubObjectTarget {
    private int subAge;
    private String subName;
    private int sex;

    public int getSubAge() {
        return subAge;
    }

    public void setSubAge(int subAge) {
        this.subAge = subAge;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SubObjectTarget{" +
                "subAge=" + subAge +
                ", subName='" + subName + '\'' +
                ", sex=" + sex +
                '}';
    }
}

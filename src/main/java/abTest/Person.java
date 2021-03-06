package abTest;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-19
 */
public class Person {
    private String name;
    private String age;
    private String idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}

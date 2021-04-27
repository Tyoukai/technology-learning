package java8;

import java.util.AbstractList;
import java.util.List;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-12
 */
public class Person extends AbstractList {
    public Integer age;
    public String name;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

package spring;

import org.springframework.beans.BeanUtils;

import java8.Person;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-30
 */
public class BeanUtilsTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(11);

        Person target = new Person();
        BeanUtils.copyProperties(person, target);

        System.out.println(target);
        System.out.println(target == person);
    }
}

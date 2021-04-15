package java8;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-12
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ReflectTest reflectTest = new ReflectTest();
        Person person = new Person();
        person.setName(null);
        person.setAge(null);
        Field field = Person.class.getField("name");
        System.out.println(field.get(person) == null);


        Type[] types = Person.class.getGenericInterfaces();
        for (Type type : types) {
            System.out.println(type);
            System.out.println(type instanceof ParameterizedType);
        }
    }
}

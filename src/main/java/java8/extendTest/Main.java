package java8.extendTest;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:47
 */
public class Main {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1.message = "son1";
        son1.map.put("key1", "value1");
        son1.setLike("son1");
        son1.getFatherMap().put("key1", "value1");
        Son2 son2 = new Son2();
        son2.message = "son2";
        son2.map.put("key2", "value2");
        son2.getFatherMap().put("key2", "value2");
        son2.setLike("son2");
        System.out.println(son1.message == son2.message);
        System.out.println(son1.map == son2.map);
        System.out.println(son1.getFatherMap() == son2.getFatherMap());
    }
}

package nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Echo
 * @Date 2022/11/15 14:46
 */
public class AddUser {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("weikai1"));
    }
}

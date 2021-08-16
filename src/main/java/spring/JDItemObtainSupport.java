package spring;

import org.springframework.stereotype.Service;

@Service(value = "jDItemObtainSupport")
public class JDItemObtainSupport extends ItemObtainSupport {

    @Override
    public String obtainItem(int code) {
        return "JD";
    }
}

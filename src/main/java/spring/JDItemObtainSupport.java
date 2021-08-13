package spring;

import org.springframework.stereotype.Service;

@Service
public class JDItemObtainSupport extends ItemObtainSupport {

    @Override
    public String obtainItem(int code) {
        return "JD";
    }
}

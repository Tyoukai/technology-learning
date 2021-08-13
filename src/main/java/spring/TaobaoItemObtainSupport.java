package spring;

import org.springframework.stereotype.Service;

@Service
public class TaobaoItemObtainSupport extends ItemObtainSupport {

    @Override
    public String obtainItem(int code) {
        return "taobao";
    }
}

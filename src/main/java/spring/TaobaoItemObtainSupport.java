package spring;

import org.springframework.stereotype.Service;

@Service(value = "taobaoItemObtainSupport")
public class TaobaoItemObtainSupport extends ItemObtainSupport {

    @Override
    public String obtainItem(int code) {
        return "taobao";
    }
}

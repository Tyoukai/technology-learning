package spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FactoryApplicationAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, ItemObtainSupport> map = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ItemObtainSupport getItemObtainSupport(String name) {
        init();

        return map.get(name);
    }

    private void init() {
        if (map.size() != 0) {
            return;
        }

        map.put("jDItemObtainSupport", (ItemObtainSupport) applicationContext.getBean("jDItemObtainSupport"));
        map.put("taobaoItemObtainSupport", (ItemObtainSupport) applicationContext.getBean("taobaoItemObtainSupport"));
    }
}

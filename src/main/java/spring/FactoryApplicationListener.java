package spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FactoryApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, ItemObtainSupport> itemFactoryMap = new HashMap<>();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, ItemObtainSupport> typeBeanMap = event.getApplicationContext().
                getBeansOfType(ItemObtainSupport.class);

        for (Map.Entry<String, ItemObtainSupport> entry : typeBeanMap.entrySet()) {
            if (!itemFactoryMap.containsKey(entry.getKey())) {
                System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
                itemFactoryMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public ItemObtainSupport getItemObtainSupport(String name) {
        return itemFactoryMap.get(name);
    }
}

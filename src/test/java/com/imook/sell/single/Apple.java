package com.imook.sell.single;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**te
 * @author KnoWsea
 * @create 2019-03-17 9:25
 */

@Component
public class Apple {
    private String name;
    private String addre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddre() {
        return addre;
    }

    public void setAddre(String addre) {
        this.addre = addre;
    }
}

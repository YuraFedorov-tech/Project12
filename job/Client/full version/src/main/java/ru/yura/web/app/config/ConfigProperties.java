package ru.yura.web.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/*
 *
 *@Data 09.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class ConfigProperties {
    @Autowired
    private Environment env;

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }
}

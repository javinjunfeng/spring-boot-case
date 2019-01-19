package top.javinjunfeng.springbootweb.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: javinjunfeng
 * @Date: 2019/1/19 11:29 AM
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix="case")
public class NeoProperties {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

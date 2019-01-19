package top.javinjunfeng.springbootweb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.javinjunfeng.springbootweb.model.NeoProperties;
import top.javinjunfeng.springbootweb.model.OtherProperties;

import javax.annotation.Resource;

/**
 * @Author: javinjunfeng
 * @Date: 2019/1/19 10:08 AM
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${case.title}")
    private String title;

    @Test
    public void testSingle() {
        Assert.assertEquals(title,"唱着远方的龟");
    }

    @Resource
    private NeoProperties properties;

    @Test
    public void testMore() throws Exception {
        System.out.println("title: "+properties.getTitle());
        System.out.println("description: "+properties.getDescription());
    }

    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testOther() throws Exception {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("blog:"+otherProperties.getBlog());
    }
}

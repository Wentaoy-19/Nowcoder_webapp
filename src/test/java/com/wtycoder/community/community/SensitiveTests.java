package com.wtycoder.community.community;

import com.wtycoder.community.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "这里可以赌博，嫖娼可以，吸毒也可以开票hh";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "这里可以赌&博，嫖娼可以，吸毒也可以开票hh";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }

}

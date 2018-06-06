package com.anyway.common.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 生成验证码配置
 * @author: wang_hui
 * @date: 2018/6/6 下午3:48
 * @since: 1.0.0
 */
@Configuration
public class KaptchaConfig {

    @Bean("producer")
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");//是否带边框
        properties.put("kaptcha.textproducer.font.color", "black");//字体颜色
        properties.put("kaptcha.textproducer.char.space", "5");//字符间距
        properties.put("kaptcha.image.width", "100");//图片宽度
        properties.put("kaptcha.image.height", "30");//图片高度
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}

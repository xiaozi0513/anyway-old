package com.anyway.modules.sys.controller;

import com.anyway.common.utils.R;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 * @author: wang_hui
 * @date: 2018/6/6 上午10:22
 * @since: 1.0.0
 */
@Slf4j
@Controller
public class SysLoginController {

    @Autowired
    private Producer producer;

    @GetMapping("/")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录验证
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    @ResponseBody
    public R login(String username, String password, String captcha) {
        log.debug("username=" + username + ",password=" + password + ",captcha=" + captcha);
        //校验验证码

        //校验用户密码

        return R.error(501, "用户名错误");
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/sys/logout", method = RequestMethod.GET)
    public String logout() {
        log.info("用户退出了......");
        return "redirect:login.html";
    }

    /**
     * 获取验证码
     * @param response
     */
    @RequestMapping(value = "/captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpg", os);
    }

}

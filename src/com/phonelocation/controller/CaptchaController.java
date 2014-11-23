package com.phonelocation.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 控制器：验证码获取
 * 
 * @author sumy
 *
 */
@Controller
public class CaptchaController {

    @Autowired
    private Producer captchaProducer = null;

    /**
     * 获取验证码并写入Session<br>
     * 使用Captcha库
     */
    @RequestMapping(value = "/captcha-image")
    public ModelAndView getKaptchaImage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        // 设置response头信息
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // 获取验证码文本并写入Session
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // 根据验证码文本生成图片
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);// ImageIO封装了常见的图像 I/O 操作
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
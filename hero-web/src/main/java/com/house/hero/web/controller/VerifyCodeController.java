package com.house.hero.web.controller;

import com.house.hero.common.utils.ImageUtil;
import com.house.hero.common.utils.RedisUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/1/30
 * @ Description：验证使用验证码
 * @ throws
 */
@RestController
public class VerifyCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyCodeController.class);
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 生成验证码
     *
     * @param time
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value="获取随机数", notes="时间随机数做key值,生成四位随机数")
    @ApiImplicitParam(name = "time", value = "随机数key值", required = true, paramType = "query",dataType = "Integer")
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public void getCode(@RequestParam(value = "time") String randomUuId,HttpServletResponse response) {

        if (StringUtils.isEmpty(randomUuId)) {
            //假如key值为空,抛出错误信息
        }
        // 利用图片工具生成图片
        // 第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = ImageUtil.createImage();
        String valicodeRealFour = (String) objs[0]; // 后台程序生成的随机的 真实四位数字验证码
        // 将图片验证码的数字 放入到缓存中,设置失效时间60s
        redisUtil.set(randomUuId, valicodeRealFour, 60 * 5);
        LOGGER.info("随机UUID_key:" + randomUuId + "; 图片验证码数字：" + valicodeRealFour);

        // 将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        try {
            // response.getOutputStream()将图片以流的形式写到前端页面
            ImageIO.write(image, "png", response.getOutputStream());
        } catch (IOException e) {
            LOGGER.info("call ProduceImageValicode Method error :", e);
        }
        //禁止图像缓存。
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//        response.setContentType("image/png");
    }
}

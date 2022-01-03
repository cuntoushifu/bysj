package com.ruoyi.web.controller.common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.service.ISysConfigService;

/**
 * 验证码操作处理
 *
 * @author ruoyi
 */
@RestController
public class CaptchaController
{

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysConfigService configService;
    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) throws IOException
    {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = configService.selectCaptchaOnOff();
        ajax.put("captchaOnOff", captchaOnOff);
        if (!captchaOnOff)
        {
            return ajax;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;


        // 生成验证码
//        算术验证码    数字加减乘除
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(114,38);
        //        几位数运算，默认2位
        captcha.setLen(2);
        //        算术运算  运算表达式
        System.out.println(captcha.getArithmeticString());

        //        运算结果
        String result = captcha.text();
        System.out.println(result);

//      存储redis
        redisCache.setCacheObject(verifyKey, result, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        ImageIO.createImageOutputStream(captcha.getArithmeticString());


        ajax.put("uuid", uuid);
        ajax.put("image", captcha.toBase64());
        return ajax;
    }
}

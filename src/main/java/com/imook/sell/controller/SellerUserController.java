package com.imook.sell.controller;

import com.imook.sell.config.ProjectUrlConfig;
import com.imook.sell.constant.CookieConstant;
import com.imook.sell.constant.RedisConstant;
import com.imook.sell.converter.OrderFormToOrderDTOConverter;
import com.imook.sell.dataobject.SellerInfo;
import com.imook.sell.dto.OrderDTO;
import com.imook.sell.enums.ResultEnum;
import com.imook.sell.exception.SellException;
import com.imook.sell.form.LoginForm;
import com.imook.sell.form.ProductForm;
import com.imook.sell.service.SellerService;
import com.imook.sell.utils.CookieUtil;
import com.imook.sell.utils.ResultVOUtil;
import jdk.nashorn.internal.parser.Token;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author KnoWsea
 * @create 2019-01-01 20:36
 */
@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm form,
                              BindingResult bindingResult,
                              HttpServletResponse response,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()) {
            log.error("[商家登录] 参数不正确,orderForm={}", form);
            //抛出表单错误信息的部分
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        //1.openid去和数据库里面的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByUsernameAndPassword(form.getUsername(), form.getPassword());
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), "token", expire, TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        return new ModelAndView("redirect:/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response,
                       HttpServletRequest request,
                       Map<String, Object> map){
        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie !=null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null , 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}

package com.imook.sell.service.impl;

import com.imook.sell.config.WechatAccountConfig;
import com.imook.sell.dto.OrderDTO;
import com.imook.sell.service.PushMessage;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author KnoWsea
 * @create 2019-01-13 19:10
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲,请记得收货!!"),
                new WxMpTemplateData("keynote1", "微信点餐 "),
                new WxMpTemplateData("keynote2", orderDTO.getBuyerPhone()),
                new WxMpTemplateData("keynote3", orderDTO.getOrderId()),
                new WxMpTemplateData("keynote4", orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keynote5", "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("[微信模板消息] 发送失败，{}", e);
        }
    }
}

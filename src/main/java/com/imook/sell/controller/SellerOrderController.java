package com.imook.sell.controller;

import com.imook.sell.config.WechatAccountConfig;
import com.imook.sell.dto.OrderDTO;
import com.imook.sell.enums.ResultEnum;
import com.imook.sell.service.OrderService;
import com.imook.sell.service.impl.OrderServiceImpl;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;
import java.util.Map;

/**卖家端操作
 * @author KnoWsea
 * @create 2018-12-30 13:44
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        System.out.println(orderDTOPage.getContent());
        return new ModelAndView("order/list",map);
    }


    @GetMapping("cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (Exception e) {
            log.error("[买家取消订单] 发生异常{}",e.getMessage());
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list?page="+page+"&size="+size);
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list?page="+page+"&size="+size);
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               Map<String, Object> map){
        OrderDTO orderDTO;

        try {
            orderDTO = orderService.findOne(orderId);
        } catch (Exception e) {
            log.error("[卖家查询订单详情] 发生异常{}",e.getMessage());
            map.put("msg",e.getMessage());
            map.put("currentPage",page);
            map.put("size",size);
            map.put("url","/sell/seller/order/list?page="+page+"&size="+size);
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/detail",map);
    }

    @GetMapping("finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
                                 @RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 Map<String, Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (Exception e) {
            log.error("[卖家完结订单] 发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list?page="+page+"&size="+size);
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list?page="+page+"&size="+size);;
        return new ModelAndView("common/success");
    }
}

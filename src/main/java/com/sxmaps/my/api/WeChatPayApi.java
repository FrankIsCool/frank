package com.sxmaps.my.api;

import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayOrderQueryV3Request;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryV3Result;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import org.apache.kafka.common.errors.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

/**
 * 微信接口
 *
 * @author frank
 * @module
 * @date 2021/7/16 10:28
 */
@Service
public class WeChatPayApi {
    @Value("${wx.pay.notifyUrl}")
    private String NOTIFY_URL = "https://www.weixin.qq.com/wxpay/pay.php";

    private final Logger log = LoggerFactory.getLogger(WeChatPayApi.class);

    @Autowired
    private WxPayService payService;

    /**
     * 创建支付二维码
     *
     * @param payNo     支付流水号
     * @param payAmount 支付金额
     * @param schoolNo  网校编码
     * @return
     * @throws IOException
     */
    public String createOrder(String payNo, BigDecimal payAmount, String schoolNo) {
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setOutTradeNo(payNo);
        request.setBody("课程费用充值");
        request.setNotifyUrl(NOTIFY_URL);
        request.setAttach(schoolNo);
        request.setSpbillCreateIp("113.96.209.103");
        request.setProductId("pro001");
        //构建金额信息
        request.setTotalFee(payAmount.multiply(BigDecimal.valueOf(100)).intValue());
        try {
            WxPayNativeOrderResult order = this.payService.createOrder(WxPayConstants.TradeType.Specific.NATIVE, request);
            if (null != order && null != order.getCodeUrl()) {
                return order.getCodeUrl();
            }
        } catch (WxPayException e) {
            log.error("【微信】创建支付二维码错误：{}", e.getCustomErrorMsg());
            throw new ApiException("【微信】创建支付二维码错误：" + e.getCustomErrorMsg());
        }
        return null;
    }

    /**
     * 查询支付结果
     *
     * @param payNo 支付流水号
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public WxPayOrderQueryV3Result getOrder(String payNo) {
        WxPayOrderQueryV3Request request = new WxPayOrderQueryV3Request();
        request.setOutTradeNo(payNo);
        try {
            return this.payService.queryOrderV3(request);
        } catch (WxPayException e) {
            log.error("【微信】创建支付二维码错误：{}", e.getCustomErrorMsg());
            throw new ApiException("【微信】创建支付二维码错误：" + e.getCustomErrorMsg());
        }
    }
}

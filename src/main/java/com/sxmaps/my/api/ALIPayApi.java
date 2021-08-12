package com.sxmaps.my.api;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.sxmaps.my.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 支付宝接口
 *
 * @author frank
 * @module
 * @date 2021/7/16 10:28
 */
@Service
public class ALIPayApi {

    @Value("${alipay.url}")
    private String URL;
    @Value("${alipay.appId}")
    private String APP_ID;
    @Value("${alipay.privateKey}")
    private String PRIVATE_KEY;
    @Value("${alipay.alipayPublicKey}")
    private String ALIPAY_PUBLIC_KEY;
    @Value("${alipay.notifyUrl}")
    private String NOTIFY_URL;
    private final Logger log = LoggerFactory.getLogger(ALIPayApi.class);

    private final String CHARSET = "utf-8";
    private final String SIGNTYPE = "RSA2";
    /**
     * 获取请求Client
     *
     * @return
     */
    private AlipayClient getClient() {
        return new DefaultAlipayClient(URL, APP_ID, PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, SIGNTYPE);
    }

    /**
     * 创建支付二维码
     *
     * @param model
     * @return
     */
    private AlipayTradePrecreateResponse createOrder(Map<String,Object> model) {

        AlipayClient alipayClient = getClient();
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(NOTIFY_URL);
        request.setBizContent(JSONObject.toJSONString(model));
        try {
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if (!response.isSuccess()) {
                log.error("【支付宝】创建支付二维码错误：{}" , response.getSubMsg());
                throw new ApiException("【支付宝】创建支付二维码错误：" + response.getSubMsg());
            }
            return response;
        } catch (AlipayApiException e) {
            log.error("【支付宝】创建支付二维码错误：", e);
            throw new ApiException("【支付宝】创建支付二维码错误!");
        }
    }

    /**
     * 查询支付结果
     *
     * @param model
     * @return
     */
    private AlipayTradeQueryResponse getOrder(Map<String,Object> model) {
        AlipayClient alipayClient = getClient();
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(JSONObject.toJSONString(model));
        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if (!response.isSuccess()) {
                log.error("【支付宝】查询支付结果错误：{}", response.getSubMsg());
                throw new ApiException("【支付宝】查询支付结果错误：" + response.getSubMsg());
            }
            return response;
        } catch (AlipayApiException e) {
            log.error("【支付宝】查询支付结果错误：", e);
            throw new ApiException("【支付宝】查询支付结果错误!");
        }
    }

    /**
     * 查询支付结果
     *
     * @param payNo 支付流水号
     * @return
     */
    public AlipayTradeQueryResponse getOrder(String payNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("out_trade_no",payNo);
        return getOrder(param);
    }

    /**
     * 创建支付二维码
     *
     * @param payNo    支付流水号
     * @param amount   支付金额
     * @param schoolNo 网校编码
     * @return
     */
    public AlipayTradePrecreateResponse createOrder(String payNo, BigDecimal amount, String schoolNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("out_trade_no",payNo);
        param.put("total_amount",amount);
        param.put("subject","升学教育课程充值");
        param.put("passback_params",schoolNo);
        param.put("timeout_express","30m");
        param.put("qr_code_timeout_express","30m");
        return createOrder(param);
    }
    /**
     *  获取回调参数，并转成map对象
     *
     * @param request
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @Author frank
     * @Date  2021/7/30 14:08
     */
    public static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<>();
        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;
            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.substring(1));
            } else {
                retMap.put(name, "");
            }
        }
        return retMap;
    }
    public Boolean checkSign(Map<String, String> params){
        try {
            return AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY,CHARSET, SIGNTYPE);
        } catch (AlipayApiException e) {
            log.error("【支付宝】回调验签失败：{}", e.getErrMsg());
            return Boolean.FALSE;
        }
    }
    public Boolean checkAppId(String appId){
        return appId.equals(APP_ID);
    }
    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016101300674532","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCAzJx9dKQNOhziMgVFZjJR4Pxq+dVxIMdOtZkvQHgIMLzpPEn0dzMEH4RB7IsUwZny8g6XMLkKg7nHs7NxaPgv+jSY8inMOaGOF7RJoHcnJ1EStJXKjWWyLD3X7gfOqHZ4aCv3mRsEBaDLMtbmmrkrBR53HZ8mKso1Ngw2mafRyxombKW3buESSVYeWJ2g5CLfVYQjhqQWIeAU+394MzoCY74ivMJO1CzZBm2xrQzbZkSYn8Eqs025Oz9xLCDvKKxNgGVN9vBvTtrlZClMDa3s+4ekRULHQ6+S0Gg3PCYgR/RqvsS+SV0ARpgEW7dAOoyP1K6xqConMfhpTkbJz5WvAgMBAAECggEAaiOzpjMT6g6EtOaRr3Ibb5wfhyyg9xwTAsrmFKllASLg2rejHkGImhI61HTQ3Gb6rdlJqtAs/Pw2gdqVupTNSgQ/ifat+S1Y9BaWrMH+zxY4WljUw9mn/58zy5jNeEEdd/YonV7fg3371tfrfpfslgYe5/xSJYrHnfgPMoOHZ3tzmr/rlNsCTNv7ixyI9WE2BgVZvV+AwS9iigRPLm2dFaAlD39F+juUFM4dkaAbmVsB6A4u/W2v8MEVChVJRdgRSWeXNMIE94Msa/sPHPoGrPII6tpeQjlgHFtKcoLcSIA4Bhg559B4OFz/BqzzTsKIzv9WxlK/tp5b148ysdtPOQKBgQC41Hrth7U9ncICuKF1LIZTqnExoY7N8gM3K6DCjnVA3nX4+JCQd68bcMZOaps4jiG6IouQDLNfbK6c7MB2H/TzoKkP7csjZnSC4EzknTUABFcdX408Wr/5oANnUyNOYVupQAG7WqJihtKX5h22C+1jcTOkwZsgAHD136tm77thIwKBgQCyZO5AvH6fiSWWUp37njw0aXVGyCxH2A8dDpRR7zQkYiWHnuHnueQOQNNvHeYAQ6lPWgCvn565LKEVr/UD85rGnk3DPZwZvdSMBeidkwy1Zy0yZHFy5hwlmUDPeKzCZjf6Cv4b7+uYqHDjm5q8Yj+KH7HkG7z6jzKSWUXEhSGQBQKBgQCJnoPtKneTakxTtF9bnIxj7Wuc1bs7srAcOxrW4jWB2GIkwAb72nGCUAUHzC7I/GM2cZRS7HH+YjDdXRasnXzIjd5zos33DMlBzXrTWg5lddXbZBMIVlXMqwz9uRR3vtv9+E+RzZlNHS/etBN5QgY+XcJjMVisikeReznnSibN2wKBgG0636dDw0Rr9VfVvmYSvUpaSDTO3E4hPR/NjYOds4+TiOdBoZEBgWI4zz16URpYU5MCyOjAE6/OY9OjqaKBxoNW6sZhMvOQCFS0SXoyT9XDFymD1vNDcniTHdvrR9zAOgYgNPdmMBuJB5ZV8Kjof39TaNkDIvNIOu7hOpbZ7XMBAoGBAI4e1tCK2yFB0CIfKv++PsSlmp0b/wit/ErQBLGj+NCal1S2b9GOgAmuM60DtNPUQjBVeACsAx19HgC6amfrrTfLoh0rTx9wTXvk9RKSu8adCQokNHWGl6ZjKiwlf8FibLb5BsVO4lbEixm2kMit0/QbfTJ1mbaW8LUwb0ecdg2Q"
            ,"json","GBK","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiGAuwmhPtMSeQY2PYOAKLYLpH1XfQJhnOeFf04d4CgSwDrsO+6IXTAc+iyb0LQODI04gifPNbYOsmVajVBU5JnGS2QB75jWqP6zn3IolfYfq1IzmWvNzFceNosOjNe2hOZbyMWfc37ycbnmVgo1fUr54Letj2QcBRKqMqaKHR9LJ8lXM0WdbMejuQoYZcn0y83Lazj8n7yM0ke0t/rMgUbxr6bFCQ1/2vbJn74CL+c9aMEzaMc4EGPR54fgSw+238B86P8YUwE/8cQW+2MAK8A0xuF8THFu6LgOoY5li/fypsQCCW2THeY8GAWtzMNZcu+QHseE51ASqN0liPzDVdQIDAQAB","RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizContent("{" +
            "\"out_trade_no\":\"20150320010101001\"," +
            "\"seller_id\":\"2088102146225135\"," +
            "\"total_amount\":88.88," +
            "\"discountable_amount\":80.00," +
            "\"subject\":\"Iphone6 16G\"," +
            "      \"goods_detail\":[{" +
            "        \"goods_id\":\"apple-01\"," +
            "\"goods_name\":\"ipad\"," +
            "\"quantity\":1," +
            "\"price\":2000," +
            "\"goods_category\":\"34543238\"," +
            "\"categories_tree\":\"124868003|126232002|126252004\"," +
            "\"body\":\"特价手机\"," +
            "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
            "        }]," +
            "\"body\":\"Iphone6 16G\"," +
            "\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
            "\"operator_id\":\"yx_001\"," +
            "\"store_id\":\"NJ_001\"," +
            "\"disable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
            "\"enable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
            "\"terminal_id\":\"NJ_T_001\"," +
            "\"extend_params\":{" +
            "\"sys_service_provider_id\":\"2088511833207846\"," +
            "\"card_type\":\"S0JP0000\"," +
            "\"specified_seller_name\":\"XXX的跨境小铺\"" +
            "    }," +
            "\"timeout_express\":\"90m\"," +
            "\"settle_info\":{" +
            "        \"settle_detail_infos\":[{" +
            "          \"trans_in_type\":\"cardAliasNo\"," +
            "\"trans_in\":\"A0001\"," +
            "\"summary_dimension\":\"A0001\"," +
            "\"settle_entity_id\":\"2088xxxxx;ST_0001\"," +
            "\"settle_entity_type\":\"SecondMerchant、Store\"," +
            "\"amount\":0.1" +
            "          }]," +
            "\"settle_period_time\":\"7d\"" +
            "    }," +
            "\"merchant_order_no\":\"20161008001\"," +
            "\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
            "\"business_params\":{" +
            "\"campus_card\":\"0000306634\"," +
            "\"card_type\":\"T0HK0000\"," +
            "\"actual_order_time\":\"2019-05-14 09:18:55\"," +
            "\"good_taxes\":\"10.00\"" +
            "    }," +
            "\"qr_code_timeout_express\":\"90m\"" +
            "  }");
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}

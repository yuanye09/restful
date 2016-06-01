package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.MD5;
import com.kudian.common.utils.StringUtils;
import com.kudian.pay.HttpsUtils;
import com.kudian.restful.service.CartService;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.QueryCartInfoRetVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.pay.BookInfo;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/4/27.
 */
@RestController
@RequestMapping("pay")
public class PayController {

    private static final Logger logger = Logger.getLogger(PayController.class);

    @RequestMapping(value = "bookorder")
    public JSONObject bookorder() {
        // BookInfo bi = new BookInfo();
        JSONObject o = new JSONObject();

        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("	<appid>wxd381916cf0bbf29d</appid>");
        sb.append("	<attach>test</attach>");
        sb.append("	<body>APPtest</body>");
        sb.append("	<mch_id>1339045001</mch_id>");
        sb.append("	<nonce_str>65c8fac043994edd8fcdad587c8dc6c1</nonce_str>");
        sb.append("	<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>");
        sb.append("	<out_trade_no>1415659990</out_trade_no>");
        sb.append("	<total_fee>1</total_fee>");
        sb.append("	<trade_type>APP</trade_type>");
        sb.append("	<sign>641102A7CE7BCA933C261E31ECF62F4B</sign>");
        sb.append("</xml>");

        // 本地起的https服务
        String httpsUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

        // 密码
        String password = "123456";
        // 密钥库
        String keyStorePath = "/opt/soft/tomcat.keystore";
        // 信任库
        String trustStorePath = "/opt/soft/tomcat.keystore";

        HttpsUtils uts = new HttpsUtils(password, keyStorePath, trustStorePath);
        String r = uts.post(httpsUrl, sb.toString());
        logger.info("返回报文:" + r);

        try {
            SAXReader reader = new SAXReader();
            Document doc;
            doc = DocumentHelper.parseText(r);

            String returncode = doc.selectSingleNode("/xml/return_code").getText();
            String returnmsg = doc.selectSingleNode("/xml/return_msg").getText();
            String appid = doc.selectSingleNode("/xml/appid").getText();
            String mch_id = doc.selectSingleNode("/xml/mch_id").getText();
            String nonce_str = doc.selectSingleNode("/xml/nonce_str").getText();
            String sign = doc.selectSingleNode("/xml/sign").getText();
            String result_code = doc.selectSingleNode("/xml/result_code").getText();
            String prepay_id = doc.selectSingleNode("/xml/prepay_id").getText();
            String trade_type = doc.selectSingleNode("/xml/trade_type").getText();

            StringBuffer sbf = new StringBuffer();
            String timestamp = System.currentTimeMillis() / 1000 + "";
            sbf.append("appid=");
            sbf.append(appid);
            sbf.append("&noncestr=");
            sbf.append(nonce_str);
            sbf.append("&package=");
            sbf.append("Sign=WXPay");
            sbf.append("&partnerid=");
            sbf.append(mch_id);
            sbf.append("&prepayid=");
            sbf.append(prepay_id);
            sbf.append("&timestamp=");
            sbf.append(timestamp);
            sbf.append("&key=b4eaea65dd014bc9ad8a9e881dd85a36");

            String s11 = MD5.getMessageDigest(sbf.toString().getBytes());

            o.put("appid", appid);
            o.put("noncestr", nonce_str);
            o.put("package", "Sign=WXPay");
            o.put("partnerid", mch_id);
            o.put("prepayid", prepay_id);
            o.put("timestamp", timestamp);
            o.put("sign", s11.toUpperCase());
//            bi.setReturn_code(doc.selectSingleNode("/xml/return_code").getText());
//            bi.setReturn_msg(doc.selectSingleNode("/xml/return_msg").getText());
//            bi.setAppid(doc.selectSingleNode("/xml/appid").getText());
//            bi.setMch_id(doc.selectSingleNode("/xml/mch_id").getText());
//            bi.setNonce_str(doc.selectSingleNode("/xml/nonce_str").getText());
//            bi.setSign(doc.selectSingleNode("/xml/sign").getText());
//            bi.setResult_code(doc.selectSingleNode("/xml/result_code").getText());
//            bi.setPrepay_id(doc.selectSingleNode("/xml/prepay_id").getText());
//            bi.setTrade_type(doc.selectSingleNode("/xml/trade_type").getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}

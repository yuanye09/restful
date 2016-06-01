package com.kudian.restful.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/8.
 */
@RestController
@RequestMapping("payback")
public class PayBackController {
    private static final Logger logger = Logger.getLogger(PayBackController.class);

    @RequestMapping(value = "dowork")
    public String dowork(HttpServletRequest request) {

        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }

        // 去掉最后一个空格
        queryString = queryString.substring(0, queryString.length() - 1);
        logger.info("payback:" + queryString);
        return "success";
    }
}

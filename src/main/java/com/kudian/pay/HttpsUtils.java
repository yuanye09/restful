package com.kudian.pay;

import com.kudian.common.utils.MD5;
import com.kudian.restful.vo.pay.BookInfo;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import javax.net.ssl.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/**
 * 
 * @author admin
 *
 */
public class HttpsUtils {

	public HttpsUtils(String password,
                      String keyStorePath, String trustStorePath) {
		try {
			initHttpsURLConnection(password, keyStorePath, trustStorePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /** 
     * 初始化HttpsURLConnection. 
     * @param password 
     *            密码 
     * @param keyStorePath 
     *            密钥库路径 
     * @param trustStorePath 
     *            信任库路径 
     * @throws Exception 
     */  
    public void initHttpsURLConnection(String password,  
    		String keyStorePath, String trustStorePath) throws Exception {  
    	// 声明SSL上下文  
    	SSLContext sslContext = null;  
    	// 实例化主机名验证接口  
    	HostnameVerifier hnv = new HostnameVerifier() {
    		@Override
    		public boolean verify(String urlHostName, SSLSession session) {
    			System.out.println("Warning: URL Host:" + urlHostName + " vs. " + session.getPeerHost());
    			return true;
    		}
    	};
    	
    	try {  
    		sslContext = getSSLContext(password, keyStorePath, trustStorePath);  
    	} catch (GeneralSecurityException e) {  
    		e.printStackTrace();  
    	}  
    	if (sslContext != null) {  
    		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext  
    				.getSocketFactory());  
    	}  
    	HttpsURLConnection.setDefaultHostnameVerifier(hnv);  
    }  

    /** 
     * 获得KeyStore. 
     * @param keyStorePath 
     *            密钥库路径 
     * @param password 
     *            密码 
     * @return 密钥库 
     * @throws Exception 
     */  
    public KeyStore getKeyStore(String password, String keyStorePath)  
            throws Exception {  
        // 实例化密钥库  
        KeyStore ks = KeyStore.getInstance("JKS");  
        // 获得密钥库文件流  
        FileInputStream is = new FileInputStream(keyStorePath);  
        // 加载密钥库  
        ks.load(is, password.toCharArray());  
        // 关闭密钥库文件流  
        is.close();  
        return ks;  
    }  
  
    /** 
     * 获得SSLSocketFactory. 
     * @param password 
     *            密码 
     * @param keyStorePath 
     *            密钥库路径 
     * @param trustStorePath 
     *            信任库路径 
     * @return SSLSocketFactory 
     * @throws Exception 
     */  
    public SSLContext getSSLContext(String password,  
            String keyStorePath, String trustStorePath) throws Exception {  
        // 实例化密钥库  
        KeyManagerFactory keyManagerFactory = KeyManagerFactory  
                .getInstance(KeyManagerFactory.getDefaultAlgorithm());  
        // 获得密钥库  
        KeyStore keyStore = getKeyStore(password, keyStorePath);  
        // 初始化密钥工厂  
        keyManagerFactory.init(keyStore, password.toCharArray());  
  
        TrustManagerFactory trustManagerFactory = TrustManagerFactory
        		.getInstance("SunX509", "SunJSSE");
        // 获得信任库  
        KeyStore trustStore = getKeyStore(password, trustStorePath);  
        // 初始化信任库  
        trustManagerFactory.init(trustStore);  
        // 实例化SSL上下文  
        SSLContext ctx = SSLContext.getInstance("SSL", "SunJSSE");
        // 初始化SSL上下文  
        TrustManager[] tm = { new MyX509TrustManager(keyStorePath, password) };
        ctx.init(null, tm, new java.security.SecureRandom());
        // 获得SSLSocketFactory  
        return ctx;  
    }  


    /** 
     * 发送请求. 
     * @param httpsUrl 
     *            请求的地址 
     * @param xmlStr 
     *            请求的数据 
     */  
    public String post(String httpsUrl, String xmlStr) {  
        HttpsURLConnection urlCon = null;  
        try {  
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();  
            urlCon.setDoInput(true);  
            urlCon.setDoOutput(true);  
            urlCon.setRequestMethod("POST");
            urlCon.setRequestProperty("Content-Type", "application/json");
            urlCon.setRequestProperty("User-Agent", "Apache-HttpClient/4.3.2 (java 1.7)");

            urlCon.setUseCaches(false);  
            urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
            urlCon.getOutputStream().flush();  
            urlCon.getOutputStream().close();

            return getStreamAsString(urlCon.getInputStream(), "UTF-8");
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";
    }  
  
    /** 
     * 发送请求. 
     * @param httpsUrl 
     *            请求的地址 
     * @param xmlStr 
     *            请求的数据 
     */  
    public String put(String httpsUrl, String xmlStr) {  
        HttpsURLConnection urlCon = null;  
        try {  
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();  
            urlCon.setDoInput(true);  
            urlCon.setDoOutput(true);  
            urlCon.setRequestMethod("PUT");
            urlCon.setRequestProperty("Content-Type", "application/json");
            urlCon.setRequestProperty("User-Agent", "Apache-HttpClient/4.3.2 (java 1.7)");

            urlCon.setUseCaches(false);  
            urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
            urlCon.getOutputStream().flush();  
            urlCon.getOutputStream().close();  
            
            return getStreamAsString(urlCon.getInputStream(), "UTF-8");
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";
    }  
    
    /** 
     * 发送请求. 
     * @param httpsUrl 
     *            请求的地址 
     *            请求的数据
     */  
    public String delete(String httpsUrl) {  
        HttpsURLConnection urlCon = null;  
        try {  
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();  
            urlCon.setDoInput(true);  
            urlCon.setDoOutput(true);  
            urlCon.setRequestMethod("DELETE");
            urlCon.setRequestProperty("Content-Type", "application/json");
            urlCon.setRequestProperty("User-Agent", "Apache-HttpClient/4.3.2 (java 1.5)");

            urlCon.setUseCaches(false);  

            return getStreamAsString(urlCon.getInputStream(), "UTF-8");
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return "";
    }  

	private static String getStreamAsString(InputStream stream, String charset) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
			StringWriter writer = new StringWriter();

			char[] chars = new char[256];
			int count = 0;
			while ((count = reader.read(chars)) > 0) {
				writer.write(chars, 0, count);
			}

			return writer.toString();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

    /** 
     * 测试方法. 
     * @param args 
     * @throws Exception 
     */  
    public static void main(String[] args) throws Exception {  
    	
        // 密码
        String password = "123456";
        // 密钥库
        String keyStorePath = "d:\\tomcat.keystore";
        // 信任库
        String trustStorePath = "d:\\tomcat.keystore";
//
//        // 本地起的https服务
//        String httpsUrl = "https://101.201.74.2/user/login";
//
//        HttpsUtils uts = new HttpsUtils(password, keyStorePath, trustStorePath);
//        String json = "{\n" +
//                "  \"name\": \"guoling\",\n" +
//                "  \"password\": \"123456\"\n" +
//                "}";
//        System.out.println(uts.post(httpsUrl, json));

        StringBuffer sb = new StringBuffer();
//        sb.append("<xml>");
//        sb.append("	<appid>wxd381916cf0bbf29d</appid>");
//        sb.append("	<attach>test</attach>");
//        sb.append("	<body>APPtest</body>");
//        sb.append("	<mch_id>1339045001</mch_id>");
//        sb.append("	<nonce_str>65c8fac043994edd8fcdad587c8dc6c1</nonce_str>");
//        sb.append("	<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>");
//        sb.append("	<out_trade_no>1415659990</out_trade_no>");
//        sb.append("	<total_fee>0.01</total_fee>");
//        sb.append("	<trade_type>APP</trade_type>");
//        sb.append("	<sign>48847A860BC59CFBCD414F6C569B1CE6</sign>");
//        sb.append("</xml>");

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

        HttpsUtils uts = new HttpsUtils(password, keyStorePath, trustStorePath);
//        System.out.println(uts.post(httpsUrl, sb.toString()));
        BookInfo bi = new BookInfo();
        String r = uts.post(httpsUrl, sb.toString());


        try {
            SAXReader reader = new SAXReader();
            Document doc;
            doc = DocumentHelper.parseText(r);

//            bi.setReturn_code(doc.selectSingleNode("/xml/return_code").getText());
//            bi.setReturn_msg(doc.selectSingleNode("/xml/return_msg").getText());
//            bi.setAppid(doc.selectSingleNode("/xml/appid").getText());
//            bi.setMch_id(doc.selectSingleNode("/xml/mch_id").getText());
//            bi.setNonce_str(doc.selectSingleNode("/xml/nonce_str").getText());
//            bi.setSign(doc.selectSingleNode("/xml/sign").getText());
//            bi.setResult_code(doc.selectSingleNode("/xml/result_code").getText());
//            bi.setPrepay_id(doc.selectSingleNode("/xml/prepay_id").getText());
//            bi.setTrade_type(doc.selectSingleNode("/xml/trade_type").getText());

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
            sbf.append(System.currentTimeMillis() / 1000 + "");
            sbf.append("&key=b4eaea65dd014bc9ad8a9e881dd85a36");

            String s11 = MD5.getMessageDigest(sbf.toString().getBytes());
            System.out.println(s11.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

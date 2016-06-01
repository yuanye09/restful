package com.kudian.common.utils;

import java.security.MessageDigest;

public class MD5 {

	private MD5() {}
	
	public final static String getMessageDigest(byte[] buffer) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(buffer);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		String str = "appid=wxd381916cf0bbf29d&attach=test&body=APPtest&mch_id=1339045001&nonce_str=65c8fac043994edd8fcdad587c8dc6c1&notify_url=http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php&out_trade_no=1415659990&total_fee=1&trade_type=APP&key=b4eaea65dd014bc9ad8a9e881dd85a36";
		System.out.println(MD5.getMessageDigest(str.getBytes()).toUpperCase());
	}
}

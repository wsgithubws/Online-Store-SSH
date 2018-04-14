package cn.itcast.shop.utils;

import java.util.UUID;

/**
 * 生成随机字符串的工具
 *
 */
public class UUIDUtils {
  
	/**
	 * 获取随机字符串
	 */
	public static String  getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}

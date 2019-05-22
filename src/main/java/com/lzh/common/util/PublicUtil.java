package com.lzh.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 
 *
 */
public class PublicUtil {

	
	
	/**
	 * 系统参数存储组件
	 * */
	public static Map<String,String> ParamMap = new HashMap<String,String>();
	/**
	 * 设置跨域http返回头
	 * 
	 * @param response
	 */
	public static void setResponse(HttpServletResponse response) {
		response.addHeader("content-type", "application:json;charset=UTF-8");// Json数据格式
																		// 采用utf-8字符集
		response.addHeader("Access-Control-Allow-Origin", "*");// 解决跨域问题
		response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");// Method设置为Post
		response.addHeader("Access-Control-Allow-Headers",
				"x-requested-with,content-type");// x-requested-with为XMLHttpRequest为ajax请求
	}
	
	//通过xml 发给微信消息
	public static String setXml(String return_code, String return_msg) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put("return_code", return_code);
		parameters.put("return_msg", return_msg);
		return "<xml><return_code><![CDATA[" + return_code + "]]>" + 
				"</return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
	}
}

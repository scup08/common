package com.lzh.common.util;

public class RandomUtil {

	/**
	 * 设置最小值最大值获取随机整数
	 * @param min 最小整数值 
	 * @param max 最大整数值
	 */
	public static Integer getRandomInt(Integer min,Integer max) {
		Integer rs = (int)(Math.random()*(max-min+1)+min);
		return rs;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			System.out.println(getRandomInt(1,1));
		}
	}
}

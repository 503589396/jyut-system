/**
 * 
 */
package com.jyut.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @date Sep 24, 2016
 * @author wztscau
 * @project ���˹���ϵͳ������
 */
public class JsonDealer {

	private JsonListener listener;

	public JsonDealer(){
		
	}
	

	public static <T> JSONObject beanToJsonObject(T t) {
		// ����Beanת����JsonString������JsonStringת����JsonObject��
		String jsonString = JSON.toJSONString(t);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		return jsonObject;
	}

	public static<T> T jsonObjectToBean(JSONObject obj,Class<T> clz) {
		T bean = JSON.toJavaObject(obj, clz);
		return bean;

	}

	public static Map<String, String> jsonStringToMap(String jsonString){
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		Set<Entry<String,Object>> entrySet = jsonObject.entrySet();
		Map<String, String> map = new HashMap<>();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey().toLowerCase();
			String value = String.valueOf(entry.getValue()).toLowerCase();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * 
	 * @param obj
	 */

	public void setJsonListener(JsonListener listener) {
		this.listener = listener;
	}

	// public abstract void attachToBean();

	public interface JsonListener {

		void fromJsonEntry(int pos, String key, String value);
	}
}

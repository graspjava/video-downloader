/**
 * 
 */
package com.github.graspjava.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Rahul.Vishvakarma1
 *
 */
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> String toJsonString(T instance) {
		if(instance == null) return null;
		
		String json = null;
		try {
			json = mapper.writeValueAsString(instance);
		} catch (JsonProcessingException e) {
			//
		}
		return json;
	}
	
	public static <T> T jsonStringToInstance(String json, Class<T> type) {
		if(json == null) return null;
		T t = null;
		try {
			t = mapper.readValue(json, type);
			
		} catch (IOException e) {
			//
		}
		return t;
	}
}

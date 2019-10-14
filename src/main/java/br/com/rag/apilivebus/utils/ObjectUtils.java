package br.com.rag.apilivebus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectUtils extends org.springframework.util.ObjectUtils {
	
	public static boolean isAllNonNull(Object... objects) {
		return !isEmpty(objects);
	}
	
	public static boolean isOneNonNull(Object... objects) {
		for (Object obj : objects) {
			if (!isEmpty(obj)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAllNull(Object... objects) {
		for (Object obj :
			objects) {
			if(obj != null)
				return false;
		}
		return true;
	}
	
	public static boolean isOneNull(Object... objects) {
		for (Object obj : objects) {
			if (isEmpty(obj)) {
				return true;
			}
		}
		return false;
	}

	public static <T> T clone(T object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return (T) mapper.readValue(mapper.writeValueAsString(object), object.getClass());
	}
}

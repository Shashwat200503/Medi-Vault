package com.medivault.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple API response builder. You can replace with a POJO if you prefer.
 */
public class ResponseUtil {

    public static Map<String, Object> success(Object data) {
        Map<String, Object> m = new HashMap<>();
        m.put("status", "success");
        m.put("data", data);
        return m;
    }

    public static Map<String, Object> success(String message, Object data) {
        Map<String, Object> m = new HashMap<>();
        m.put("status", "success");
        m.put("message", message);
        m.put("data", data);
        return m;
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> m = new HashMap<>();
        m.put("status", "error");
        m.put("message", message);
        return m;
    }
}

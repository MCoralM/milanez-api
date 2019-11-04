package br.com.milanez.core;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author moises
 */
public class QueryParameter {

    private Map<String, Object> params;

    public QueryParameter(String name, Object value) {
        params = new HashMap<>();
        params.put(name, value);
    }

    public QueryParameter add(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> getParameters() {
        return params;
    }

}

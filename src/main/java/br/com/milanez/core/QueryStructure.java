package br.com.milanez.core;

import br.com.milanez.util.FreemarkerUtil;
import br.com.milanez.util.XmlUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moises
 */
@XmlRootElement(name = "queries")
@XmlAccessorType(XmlAccessType.FIELD)
public final class QueryStructure {

    private static Map<String, QueryStructure> instances;

    @XmlElement(name = "query")
    private List<Query> queries;

    protected QueryStructure() {
    }

    public static QueryStructure getInstance(String queryTemplate) {
        if (instances == null) {
            instances = new HashMap<>();
            instances.put(queryTemplate, XmlUtil.unmarshall(queryTemplate.toLowerCase(), QueryStructure.class));
        } else if (!instances.containsKey(queryTemplate)) {
            instances.put(queryTemplate, XmlUtil.unmarshall(queryTemplate.toLowerCase(), QueryStructure.class));
        }

        return instances.get(queryTemplate);
    }

    public List<Query> getQueries() {
        return queries;
    }

    public void setQueries(List<Query> queries) {
        this.queries = queries;
    }

    public Query getQueryByName(String name) {
        if (queries == null || name == null || name.trim().isEmpty()) {
            return null;
        }

        for (Query query : queries) {
            if (query.getName().equals(name.toLowerCase())) {
                return query;
            }
        }
        return null;
    }

    public String getProcessedQueryByName(String name, Map<String, Object> params) {
        Query query = getQueryByName(name);
        if (query == null || query.getSql() == null || query.getSql().trim().isEmpty()) {
            return null;
        }

        return FreemarkerUtil.processTemplate(query.getSql(), params);
    }

}

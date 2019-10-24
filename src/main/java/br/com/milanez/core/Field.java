package br.com.milanez.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author moises
 */
@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "column-name")
    private String columnName;
    @XmlAttribute(name = "type")
    private String type;

    public Field() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Class getTypeClass() {
        if ("integer".equals(type) || "int".equals(type)) {
            return Integer.class;
        } else if ("string".equals(type)) {
            return String.class;
        }
        //TODO.: all Other types
        return null;
    }

    public String getMethodNameSet() {
        return "set" + StringUtils.capitalize(name);
    }

}

package br.com.milanez.core;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moises
 */
@XmlRootElement(name = "entity-mapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntityMapper {

    @XmlAttribute(name = "entity")
    private String entityName;
    @XmlElement(name = "field")
    private List<Field> fields;

    public EntityMapper() {
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Class getEntityClass() {
        try {
            return Class.forName(entityName);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

}

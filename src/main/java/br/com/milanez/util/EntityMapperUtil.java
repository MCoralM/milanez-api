/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.milanez.util;

import br.com.milanez.core.Field;
import br.com.milanez.core.Query;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author moises
 */
public class EntityMapperUtil {

    public static <T> T mapToEntity(Class<?> clss, Query query, ResultSet result) {
        if (clss == null || query == null || result == null) {
            return null;
        }
        try {
            T entityConverted = (T) clss.getClass().newInstance();
            List<Field> fields = query.getEntityMapper().getFields();
            while (result.next()) {
                for (Field field : fields) {
                    Method setMethod = entityConverted.getClass().getDeclaredMethod(field.getMethodNameSet(), field.getTypeClass());
                    setMethod.invoke(result.getObject(field.getColumnName(), field.getTypeClass()));
                }
            }
            return entityConverted;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

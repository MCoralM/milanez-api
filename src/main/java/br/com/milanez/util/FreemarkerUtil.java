package br.com.milanez.util;

import freemarker.template.Template;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 *
 * @author moises
 */
public class FreemarkerUtil {

    public static String processTemplate(String templateContent, Map<String, Object> parameters) {
        try {
            Template freemarkerTemplate = new Template(null, new StringReader(templateContent), null);
            StringWriter writer = new StringWriter();
            freemarkerTemplate.process(parameters, writer);
            String result = writer.toString();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

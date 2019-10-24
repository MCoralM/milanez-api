package br.com.milanez.util;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author moises
 */
public class XmlUtil {

    public static String marshall() {
        return null;
    }

    public static <T> T unmarshall(String xml, Class clss) {
        try {
            JAXBContext jContext = JAXBContext.newInstance(clss);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            return (T) unmarshallerObj.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

package br.com.milanez.util;

import br.com.milanez.core.LowerCaseStreamReaderDelegate;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

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
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            InputStream is = IOUtils.toInputStream(xml);
            XMLStreamReader xReader = new LowerCaseStreamReaderDelegate(xmlInputFactory.createXMLStreamReader(is));

            return (T) unmarshallerObj.unmarshal(xReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

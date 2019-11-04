package br.com.milanez.util;

import java.io.InputStream;

/**
 *
 * @author moises
 */
public class IOUtils {

    public static String toString(InputStream is) {
        try {
            return org.apache.commons.io.IOUtils.toString(is, "UTF-8");

        } catch (Exception e) {
        }
        return null;
    }

    @Deprecated
    public static InputStream toInputStream(String input) {
        try {
            return org.apache.commons.io.IOUtils.toInputStream(input);

        } catch (Exception ex) {
        }

        return null;
    }
}

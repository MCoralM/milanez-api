/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}

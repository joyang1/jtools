package cn.tommyyang.jtools.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author : TommyYang
 * @Time : 4/13/22 10:25 PM
 * @Software: IntelliJ IDEA
 * @File : UrlUtils.java
 */
public class UrlUtils {

    /**
     * url编码
     *
     * @param url
     */
    public static String encodeUrl(String url) throws UnsupportedEncodingException {
       return encodeUrl(url, "UTF-8");
    }

    /**
     * url编码，指定编码类型
     *
     * @param url
     * @param enc
     */
    public static String encodeUrl(String url, String enc) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, enc);
    }

}

package cn.tommyyang.jtools.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author : TommyYang
 * @Time : 4/13/22 10:25 PM
 * @Software: IntelliJ IDEA
 * @File : EncodeUtils.java
 */
public class EncodeUtils {
    /**
     * 日志
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(EncodeUtils.class);

    /**
     * url编码
     *
     * @param url
     */
    public static String encodeUrl(String url) {
        return encodeUrl(url, "UTF-8");
    }

    /**
     * url编码，指定编码类型
     *
     * @param url
     * @param enc
     */
    public static String encodeUrl(String url, String enc) {
        try {
            return URLEncoder.encode(url, enc);
        } catch (Exception e) {
            LOGGER.error("encode url error, 不支持该编码", e);
        }
        return "";
    }

    /**
     * url解码
     *
     * @param encUrl
     * @return
     */
    public static String decodeUrl(String encUrl) {
        return decodeUrl(encUrl, "UTF-8");
    }

    /**
     * url解码，执行解码类型
     *
     * @param encUrl
     * @param enc
     * @return
     */
    public static String decodeUrl(String encUrl, String enc) {
        try {
            return URLDecoder.decode(encUrl, enc);
        } catch (Exception e) {
            LOGGER.error("decode url error, 不支持该编码", e);
        }
        return "";
    }

}

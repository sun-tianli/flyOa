package com.eaglesoft.zjhz.common.utils.aes;

import java.security.Key;

public interface EncryptUtil {
    /**
     * 自定义私钥
     */
    static String private_key = "666666";

    /**
     * 根据KEY生成种子(keystr)获取KEY
     *
     * @param keystr
     * @return KEY
     */
    public Key getKey(String keystr);

    /**
     * 直接根据16进制字符串生成Key
     *
     * @param keyStr 16机制字符串
     */
    public Key getHexKey(String keyStr);

    /**
     * AES方式加密字符串
     *
     * @param str
     * @param key
     * @return 16进制字符串
     */
    public String encoder(String str, String key);

    /**
     * AES方式加密字符串
     *
     * @param str
     * @param key
     * @return 16进制字符串
     */
    public String encoder(String str, Key key);


    /**
     * 以默认密钥AES方式加密字符串
     *
     * @param str
     * @return 16进制字符串
     */
    public String encoder(String str);


    /**
     * AES方式解密字符串
     *
     * @param str
     * @param key
     * @return
     */
    public String decoder(String str, Key key);

    /**
     * AES方式解密字符串
     *
     * @param str
     * @param key
     * @return
     */
    public String decoder(String str, String key);

    /**
     * 以默认密钥AES方式解密字符串
     *
     * @param str
     * @return
     */
    public String decoder(String str);
}

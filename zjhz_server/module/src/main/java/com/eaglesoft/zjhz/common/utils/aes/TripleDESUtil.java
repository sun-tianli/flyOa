package com.eaglesoft.zjhz.common.utils.aes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;


/**
 * 3DES方式加密、解密
 * (3DES是个比较安全的单钥加密、解密类型)
 *
 * @author chenli by 2011
 * @version 4.0
 */
public class TripleDESUtil implements EncryptUtil {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据KEY生成种子(keystr)获取KEY
     * 采用168位  即k1！=k3
     *
     * @param keystr
     * @return KEY
     */
    public Key getKey(String keystr) {
        Key key = null;
        try {
            KeyGenerator kg = KeyGenerator.getInstance("DESede");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
            secureRandom.setSeed(keystr.getBytes("UTF-8"));
            kg.init(168, secureRandom);
            key = kg.generateKey();
        } catch (Exception e) {
            log.error("获取3DES KEY异常.", e);
        }
        return key;
    }

    /**
     * 直接根据16进制字符串生成Key
     *
     * @param keyStr
     * @return
     * @author xiezh
     * @data Oct 23, 2012
     */
    public Key getHexKey(String keyStr) {
        Key key = null;
        try {
            byte[] bytes = javax.xml.bind.DatatypeConverter.parseHexBinary(keyStr);
            key = new SecretKeySpec(bytes, "DESede");
        } catch (Exception e) {
            System.out.println("获取KEY DESede异常:" + e);
        }
        return key;
    }

    /**
     * 3DES方式加密字符串
     *
     * @param str
     * @param key
     * @return 16进制字符串
     */
    public String encoder(String str, Key key) {
        String result = "";
        try {
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] ebytes = cipher.doFinal(str.getBytes("UTF-8"));
            result = javax.xml.bind.DatatypeConverter.printHexBinary(ebytes);
        } catch (Exception e) {
            log.error("用3DES加密异常.", e);
        }
        return result;
    }


    /**
     * 以默认密钥DES方式加密字符串
     *
     * @param str
     * @return 16进制字符串
     */
    public String encoder(String str) {
        return encoder(str, private_key);//默认密钥
    }

    /**
     * 以指定密钥DES方式加密字符串
     *
     * @param str    明文
     * @param keyStr 密钥
     * @return 16进制字符串
     */
    public String encoder(String str, String strkey) {
        Key key = this.getKey(strkey);
        return encoder(str, key);
    }


    /**
     * DES方式解密字符串
     *
     * @param str
     * @param key
     * @return
     */
    public String decoder(String str, Key key) {
        String result = "";
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytes = javax.xml.bind.DatatypeConverter.parseHexBinary(str);
            byte[] dbytes = cipher.doFinal(bytes);
            result = new String(dbytes, "UTF-8");
        } catch (Exception e) {
            log.error("3DES解密异常" + e);
        }

        return result;
    }

    /**
     * 以默认密钥DES方式解密字符串
     *
     * @param str
     * @param key
     * @return
     */
    public String decoder(String str) {
        Key key_ = this.getKey(private_key);//默认密钥
        return decoder(str, key_);
    }

    public String decoder(String str, String key) {
        Key key_ = this.getKey(key);
        return decoder(str, key_);
    }
}

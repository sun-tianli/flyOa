package com.eaglesoft.zjhz.common.utils.aes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;


/**
 * AES方式加密、解密
 * (AES是个比较安全的单钥加密、解密类型)
 * @author zxp
 * @version 4.0
 *
 */
public class AESUtil implements EncryptUtil{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 根据KEY生成种子(keystr)获取KEY
	 * @param keystr
	 * @return KEY
	 */
	public Key getKey(String keystr){
		Key key=null;
		try {
			KeyGenerator kg=KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG","SUN");  
			secureRandom.setSeed(keystr.getBytes("UTF-8")); 
			kg.init(128, secureRandom);
			key=kg.generateKey();
		} catch (Exception e) {
			log.error("获取AES KEY异常",e);
		}
		return key;
	}
	
	/**
	 * 直接根据16进制字符串生成Key
	 * @param keyStr
	 * @return 
	 * @author xiezh 
	 * @data Oct 23, 2012
	 */
	public Key getHexKey(String keyStr){
		Key key=null;
		try {
		    byte[] bytes=javax.xml.bind.DatatypeConverter.parseHexBinary(keyStr);
		    key=new SecretKeySpec(bytes,"AES");
		} catch (Exception e) {
			System.out.println("获取KEY AES异常:"+e);
		}
		return key;
	}

	/**
	 * AES方式加密字符串
	 * @param str
	 * @param key
	 * @return 16进制字符串
	 */
	public String encoder(String str,Key key){
		String result="";
		try {
			Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] ebytes=cipher.doFinal(str.getBytes("UTF-8"));
			result=javax.xml.bind.DatatypeConverter.printHexBinary(ebytes);
		} catch (Exception e) {
			log.error("AES加密异常",e);
		} 
		return result;
	}
	
	public String encoder(String str, String key) {
		Key key_=this.getKey(key);//默认密钥
		return encoder(str, key_);
	}
	
	/**
	 * 以默认密钥AES方式加密字符串
	 * @param str
	 * @return 16进制字符串
	 */
	public String encoder(String str){
		Key key=this.getKey(private_key);//默认密钥
		return encoder(str, key);
	}
	
	
	
	/**
	 *  AES方式解密字符串
	 * @param str
	 * @param key
	 * @return
	 */
	public String decoder(String str,Key key){
		String result="";
		try {
			Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] bytes=javax.xml.bind.DatatypeConverter.parseHexBinary(str);
			byte[] dbytes=cipher.doFinal(bytes);
			result=new String(dbytes,"UTF-8");
		} catch (Exception e) {
			log.error("用AES解密异常str="+str+"。", e);
		} 
		return result;
	}
	
	public String decoder(String str, String key) {
		Key key_=this.getKey(key);//默认密钥
		return decoder(str, key_);
	}
	/**
	 * 以默认密钥AES方式解密字符串
	 * @param str
	 * @return
	 */
	public String decoder(String str){
		Key key=this.getKey(private_key);
		return decoder(str, key);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(new AESUtil().encoder("nihao","qlsxkpwd"));
		System.out.println(new AESUtil().getHexKey("4D48A55F6D0A9E69761C9FF77F6C9B1E"));
//		System.out.println("请选择功能1：加密。2：解密。3:AES方式。4：3DES方式。  退出请按q");
//		System.out.println("默认是AES 加密:");
//		Scanner scanner = new Scanner(System.in);
//		EncryptUtil util = new AESUtil();
//		util.getHexKey("45375EB9804A93C0BAB8A36C62278122");
//		boolean encode = true;
//		while(scanner.hasNext()){
//			String str = scanner.next();
//			if("1".equals(str)){
//				encode = true;
//				System.out.print("请输入需要加密的字符串：");
//				continue;
//			}else if("2".equals(str)){
//				encode = false;
//				System.out.print("请输入需要解密的字符串：");
//				continue;
//			}else if("3".equals(str)){
//				System.out.print("现在使用AES加解密，请输入字符串：");
//				util = new AESUtil();
//				continue;
//			}else if("4".equals(str)){
//				System.out.print("现在使用3DES加解密，请输入字符串：");
//				util = new TripleDESUtil();
//				continue;
//			}
//			
//			if("q".equals(str)){
//				break;
//			}
//			if(encode){
//				System.out.println("结果："+util.encoder(str));
//				System.out.print("请输入需要加密的字符串：");
//			}else{
//				System.out.println("结果："+util.decoder(str));
//				System.out.print("请输入需要解密的字符串：");
//			}
//		}
		
	}
}

package com.eaglesoft.zjhz.common.utils.sm2;

/**
 * 钥匙串
 * Created by lx on 2019/8/29
 */
public class SM2Keys {
    private String publicKey;

    private String privateKey;

    public SM2Keys(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

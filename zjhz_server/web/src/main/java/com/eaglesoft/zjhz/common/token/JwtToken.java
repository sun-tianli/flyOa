package com.eaglesoft.zjhz.common.token;
 
import lombok.Data;

@Data
public class JwtToken {

    private String token;

    private String exipreAt;

    public JwtToken(String token) {
        this.token = token;
    }

    public JwtToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
    }


}
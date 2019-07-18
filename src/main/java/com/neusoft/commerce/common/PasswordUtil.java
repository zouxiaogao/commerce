package com.neusoft.commerce.common;


import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {


    /**
     * 获得加密后的密码
     * @param password
     * @return
     */
    public static String encryptedPasswordBySha256(String password) {
        String encryPassword = DigestUtils.sha256Hex(password);
        return encryPassword;
    }
}

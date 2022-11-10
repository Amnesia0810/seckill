package com.amnesia.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author Amnesia
 */
@Component
public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }
    private static final String SALT = "1a2b3c4d";
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + SALT.charAt(0)+SALT.charAt(2)+inputPass+SALT.charAt(5)+SALT.charAt(4);
        return md5(str);
    }
    public static String fromPassToDbPass(String fromPass,String salt) {
        String str = ""+salt.charAt(2)+salt.charAt(5)+fromPass+salt.charAt(1)+salt.charAt(3);
        return md5(str);
    }
    public static String inputPassToDbPass(String inputPass) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDbPass(fromPass,SALT);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(fromPassToDbPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456"));
    }
}

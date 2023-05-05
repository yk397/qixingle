package com.sixandone.qixingle.util;

import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName yk
 * @Descprition:用户解密的工具类
 * @Autor DELL
 * @Date 2023/5/5 15:05
 **/

public class EncryptedDataUtils {
    private String appid;
    private String sessionKey;

    private String originalData;

    public String getOriginalData() {
        return originalData;
    }

    /**
     *
     * @param appid 小程序的appid
     * @param sessionKey 在登陆后会获得sessionKey
     */
    public EncryptedDataUtils(String appid, String sessionKey) {
        this.appid = appid;
        this.sessionKey = sessionKey;
    }

    public encryptErrcode decryptData(String encryptedData, String iv) throws Exception {

        if (sessionKey.length() != 24) {
            return encryptErrcode.ILLEGAL_AES_KEY;
        }
        if (iv.length() != 24) {
            return encryptErrcode.ILLEGAL_IV;
        }
        byte[] raw = sessionKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw,"AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE,skeySpec,ips);
        byte[] encrypted = new BASE64Decoder().decodeBuffer(encryptedData);
        if(encrypted == null){
            return encryptErrcode.ILLEGAL_BUFFER;
        }

        try {
            byte[] original = cipher.doFinal(encrypted);
            originalData = new String(original);
            if(originalData == null){
                return encryptErrcode.AES_FAIL;
            }
            return encryptErrcode.OK;
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}

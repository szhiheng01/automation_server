package com.creditease.selenium.Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.log4j.Logger;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DESCoder {

    private final static String CHARSET = "utf-8";
    private static       Logger LOG     = Logger.getLogger(DESCoder.class);
    /**
     * 对cipherText进行DES解密
     *
     * @param cipherText
     * @return
     */
    public static String desDecrypt(String cipherText, String desKey) {
        String decryptStr = null;
        try {
            // 解密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, genSecretKey(desKey));
            byte[] output = cipher.doFinal(hexStringToByte(cipherText));
            decryptStr = new String(output, CHARSET);

        } catch (Exception e) {
            LOG.info(e);
        }
        return decryptStr;
    }

    /**
     * 对message进行DES加密
     *
     * @param message
     * @return
     */
    public static String desEncrypt(String message, String desKey) {
        String encryptStr = null;
        try {
            // 加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, genSecretKey(desKey));
            byte[] cipherText = cipher.doFinal(message.trim().getBytes(CHARSET));
            encryptStr = byteToStr(cipherText);
        } catch (Exception e) {
            //e.printStackTrace();
            LOG.info(e);
        }
        return encryptStr;
    }

    private static SecretKey genSecretKey(String key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec desKeySpec = new DESKeySpec(hexStringToByte(key));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(desKeySpec);
    }

    private static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

}

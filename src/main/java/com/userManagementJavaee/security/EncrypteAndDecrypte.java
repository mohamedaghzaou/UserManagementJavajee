package com.userManagementJavaee.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class EncrypteAndDecrypte {
	
	private static   Cipher cipherE;
    public EnDecrypt() throws Exception {

    }

    public static  SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }
    public static  String encrypt(String algorithm, String input, SecretKey key) throws Exception{

        cipherE =Cipher.getInstance(algorithm);
        cipherE.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipherE.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }
    public static  String decrypt(String algorithm, String cipherText, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        GCMParameterSpec spec = new GCMParameterSpec(128 ,cipherE.getIV());
        cipher.init(Cipher.DECRYPT_MODE, key,spec);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }

}

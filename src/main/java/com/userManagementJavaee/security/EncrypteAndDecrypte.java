package com.userManagementJavaee.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

import java.util.Base64;



public class EncrypteAndDecrypte {
	
	private static   Cipher cipherE;
	private static   SecretKey key;
	private static  String algorithm;
	private static GCMParameterSpec  spec ;
    private static  Base64.Decoder d;
    private static  Base64.Encoder e;

    public EncrypteAndDecrypte() {
    }
    
    static {
    	try {
			key = generateKey(128);
			algorithm = "AES/GCM/NoPadding";
	    	 cipherE =Cipher.getInstance(algorithm);
	    	 byte[] IV = new byte[16];
	    	 spec = new GCMParameterSpec(128 ,IV);
	           d = Base64.getDecoder();
	           e= Base64.getEncoder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // generate key
    public static  SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }
    public static  String encrypt( String input) throws Exception{
    	 cipherE =Cipher.getInstance(algorithm);
         cipherE.init(Cipher.ENCRYPT_MODE, key,spec);
        byte[] cipherText = cipherE.doFinal(input.getBytes());
        return e
                .encodeToString(cipherText);
    }
    public static  String decrypt(String cipherText) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] plainText = cipher.doFinal(d
                .decode(cipherText));
        return new String(plainText);
    }

}

package com.avvero.bot_aes_encryption.service;

import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by belyaev-ay on 24.05.17.
 */
@Service
public class AesEncryptionService {

    public String encrypt(String key, String schema, String value) {
        try {
            Cipher cipher = Cipher.getInstance(schema, "BC");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
            return new String(cipher.doFinal(value.getBytes()));
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

}

package com.example.qingtingserver.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class AESCyperUtils {
    @Getter
    public String aesKeyFilePath;

    public AESCyperUtils(@Value("${AES_KEY}")String aesKeyFilePath) {
        this.aesKeyFilePath = aesKeyFilePath;
    }

    // 读取二进制密钥文件并返回密钥
    private byte[] loadAESKey() throws IOException {
        return Files.readAllBytes(Paths.get(aesKeyFilePath));
    }

    private SecretKey getSecretKey() {
        try {
            byte[] key = loadAESKey();
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            return secretKey;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用密钥进行加密
     * @param data 要加密的字符串
     * @return 返回加密后的字符串，如果加密失败则返回null
     */
    public String encrypt(String data) throws Exception {
        SecretKey secretKey = getSecretKey();
        if (secretKey == null) { return null; }

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);  // 将加密后的数据转换为 Base64 字符串
    }

    // 使用密钥进行解密
    public String decrypt(String encryptedData) throws Exception {
        SecretKey secretKey = getSecretKey();
        if (secretKey == null) { return null; }
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);

        return new String(decryptedData);  // 解密后的数据
    }


}

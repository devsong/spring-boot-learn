package com.gzs.learn.boot.crypto;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

public class CryptoTest {
    @Test
    public void testProviders() {
        Provider[] providers = Security.getProviders();
        Provider bonucyProvider = new BouncyCastleProvider();
        System.out.println(bonucyProvider.getName() + ",info:" + bonucyProvider.getInfo());
        Security.addProvider(new BouncyCastleProvider());

        for (Provider provider : providers) {
            System.out.println("name:" + provider.getName());
            // System.out.println("info:" + provider.getInfo());
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5", BouncyCastleProvider.PROVIDER_NAME);
            String md5 = new String(Hex.encode( digest.digest("123456".getBytes())));
            System.out.println(md5);
        } catch (NoSuchAlgorithmException | NoSuchProviderException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testSign() {

    }
}

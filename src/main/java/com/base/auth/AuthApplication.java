package com.base.auth;

import com.base.auth.model.Hash;
import com.base.auth.model.RSA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AuthApplication.class, args);

        Hash hash = new Hash();

        //String o = "paçoca";
        //System.out.println("Hash: " + hash.geraHash(o));

        RSA rsa = new RSA();

        //rsa.gerarChave();
    }



}

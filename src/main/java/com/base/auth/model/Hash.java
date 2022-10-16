package com.base.auth.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hash {

    public String geraHash(String objeto) throws Exception{

        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte hash[] = algoritmo.digest(objeto.getBytes(StandardCharsets.UTF_8));

        StringBuilder saida = new StringBuilder();
        for(byte a : hash){
            saida.append(String.format("%02X", 0xFF & a));
        }
        return saida.toString();
    }



}



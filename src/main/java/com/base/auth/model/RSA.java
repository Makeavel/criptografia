package com.base.auth.model;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAKeyGenParameterSpec;

public class RSA {

    private final byte[] def = new byte[1024];
    private String ChavePrivada;
    private String ChavePublica;

    public void gerarChave() throws Exception {

        KeyPairGenerator gerador = KeyPairGenerator.getInstance("RSA");
        //tamanho da chave
        gerador.initialize(new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4));
        //cria as chaves
        KeyPair keyPair = gerador.generateKeyPair();
        //passando chave publica para arquivo
        ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("Publico"));
        saida.writeObject(keyPair.getPublic());
        this.ChavePublica = keyPair.getPublic().toString();
        saida.close();
        //passando chave privada para arquivo
        saida = new ObjectOutputStream((new FileOutputStream(("privado"))));
        saida.writeObject(keyPair.getPrivate());
        this.ChavePrivada = keyPair.getPrivate().toString();
        saida.close();
        System.out.println("Publico: " + ChavePublica + "\n\n" + "Privado: " +  ChavePrivada);
    }

    public Key recebeChave(  ) throws Exception {

        ObjectOutputStream saida = new ObjectOutputStream( new FileOutputStream("arquivo"));

        //Key chave

        return null;
    }

    public void criptografar(Key chave , InputStream input , OutputStream output) throws Exception{

        Cipher cifra = Cipher.getInstance("RSA");
        // inicializando criptografia com a chave
        cifra.init(Cipher.ENCRYPT_MODE, chave);
        // entrada sem criptografia
        CipherOutputStream cifraSaida = new CipherOutputStream(output , cifra);

        int cont;
        // pega o in criptografa e joga no out
        while((cont = input.read(def)) >= 0){
            cifraSaida.write(def,0, cont);
        }
        cifraSaida.close();
    }

    public void decriptografar(Key chave , InputStream input , OutputStream output) throws Exception{

        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.DECRYPT_MODE, chave);
        CipherInputStream cifraEntrada = new CipherInputStream(input, cifra);

        int cont;
        while((cont = input.read(def)) >= 0){
            output.write(def , 0 , cont);
        }
        cifraEntrada.close();
    }

    public String getChavePrivada(){
        return ChavePrivada;
    }
    public String getChavePublica(){
        return ChavePublica;
    }

}

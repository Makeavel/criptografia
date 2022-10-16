package com.base.auth.service;

import com.base.auth.model.Hash;
import org.springframework.stereotype.Service;

@Service
public class HashServiceImpl implements HashService{

    Hash hash = new Hash();

    @Override
    public String createHash(String object) throws Exception {
        return hash.geraHash(object);
    }


}

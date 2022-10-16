package com.base.auth.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface HashService {

    String createHash(String object) throws Exception;
}

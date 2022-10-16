package com.base.auth.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    private String email;
    private String pass;
    private Hash  hash;

    

}

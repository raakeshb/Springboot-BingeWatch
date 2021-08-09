package com.example.restapiBingewatch.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface userrepo extends MongoRepository<users,String> {

    users findByUsername(String username);
}

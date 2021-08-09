package com.example.restapiBingewatch.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface movierepo extends MongoRepository<movies, String> {


}

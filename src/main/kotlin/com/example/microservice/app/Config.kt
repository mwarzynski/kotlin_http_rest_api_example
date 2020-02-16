package com.example.microservice.app

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing


@Configuration
@EnableMongoAuditing
class MongoConfig {}
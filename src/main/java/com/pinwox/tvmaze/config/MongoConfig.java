package com.pinwox.tvmaze.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

        @Bean
    public MappingMongoConverter mappingMongoConverter(
            MongoDatabaseFactory databaseFactory,
            MongoMappingContext context) {

        MappingMongoConverter converter =
                new MappingMongoConverter(
                        new DefaultDbRefResolver(databaseFactory),
                        context
                );

        converter.setTypeMapper(
                new DefaultMongoTypeMapper(null)
        );

        return converter;
    }

}

package com.denys.multiple_users.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties
public record DataSources(
        @Value("${data-sources}")
        List<Source> dataSources) {

    public record Source(
            String name,
            String strategy,
            String url,
            String table,
            String user,
            String password,
            Mapping mapping
    ) {

        public record Mapping(
                String id,
                String username,
                String name,
                String surname
        ) {

        }
    }
}

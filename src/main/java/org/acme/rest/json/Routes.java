package org.acme.rest.json;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.MongoClient;

import org.apache.camel.builder.RouteBuilder;

import io.quarkus.mongodb.runtime.MongoClientName;

@ApplicationScoped
public class Routes extends RouteBuilder {

    @Inject
    @MongoClientName("users")
    MongoClient mongoClient1;

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=1000")
                .log("Hello World");
    }
}

package com.dlwhitehurst.camel.resource;

import com.dlwhitehurst.camel.service.ContactService;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {
    @Autowired
    private ContactService service;

    //@BeanInject
    //private OrderProcessor processor;

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").port(8080).host("localhost").bindingMode(RestBindingMode.json);

        rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
                .setBody(constant("Welcome to java techie")).endRest();

        rest().get("/api/v1/contacts").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getAllContacts())
                .endRest();

     //   rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
       //         .route().process(processor).endRest();
    }}

package com.dlwhitehurst.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Value("${dlwhitehurst.api.path}")
    //String contextPath;
    @Value("${server.port}")
    String serverPort;
    @Component
    class RestApi extends RouteBuilder {
        @Override
        public void configure() {
            CamelContext context = new DefaultCamelContext();

            // overall REST config
            restConfiguration()
                    //.contextPath(contextPath)
                    .port(serverPort)
                    .enableCORS(true)
                    .apiContextPath("/api-doc")
                    .apiProperty("api.title", "TwoHump REST API")
                    .apiProperty("api.version", "v1")
                    .apiContextRouteId("doc-api")
                    .component("servlet")
                    .bindingMode(RestBindingMode.json);

            // the REST resource(s) configuration
            rest("/api/")
                    .id("api-route")
                    .consumes("application/json")
                    .post("/bean")
                    .bindingMode(RestBindingMode.json)
                    .type(MyBean.class)
                    .to("direct:remoteService");

            from("direct:remoteService")
                    .routeId("direct-route")
                    .tracing()
                    .log(">>> ${body.id}")
                    .log(">>> ${body.name}")
                    .transform().simple("Hello ${in.body.name}")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
        }
    }
}

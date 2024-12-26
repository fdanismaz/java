package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import helloworld.HelloWorldServiceGrpc;
import helloworld.Helloworld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.wiremock.grpc.GrpcExtensionFactory;
import org.wiremock.grpc.dsl.WireMockGrpcService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.wiremock.grpc.dsl.WireMockGrpc.*;

public class TestSayHello {

    static WireMockServer server;

    @BeforeAll
    static void init() {
        server = new WireMockServer(
                WireMockConfiguration.wireMockConfig()
                        .port(50051)
                        .withRootDirectory("src/test/resources/wiremock")
                        .extensions(new GrpcExtensionFactory())
        );

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        System.out.println("WireMock gRPC server is running at: " + server.baseUrl());
    }

    @Test
    public void testSayHello() {
        WireMockGrpcService mockService =
                new WireMockGrpcService(
                        new WireMock(server.port()),
                        HelloWorldServiceGrpc.SERVICE_NAME
                );

        Helloworld.HelloWorldRequest.Builder requestBodyBuilder = Helloworld.HelloWorldRequest.newBuilder().setName("john").setSurname("doe");
        Helloworld.HelloWorldResponse.Builder responseBodyBuilder = Helloworld.HelloWorldResponse.newBuilder().setMessage("Hello JD");

        mockService.stubFor(
                method("SayHello")
                        .withRequestMessage(equalToMessage(requestBodyBuilder))
                        .willReturn(message(responseBodyBuilder))
        );

        String name = "john";
        String surname = "doe";
        String result = callService(name, surname);
        assertEquals(String.format("Hello JD", name, surname), result);

        mockService.verify(1, "SayHello").withRequestMessage(equalToMessage(requestBodyBuilder));
    }

    private String callService(String name, String surname) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/grpc/sample/hello"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(getRequestBody(name, surname)))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper deserializer = new ObjectMapper();
            SayHelloClientResponse responseObj = deserializer.readValue(response.body(), SayHelloClientResponse.class);
            return responseObj.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRequestBody(String name, String surname) {
        SayHelloClientRequest requestBody = SayHelloClientRequest.builder()
                .name(name)
                .surname(surname)
                .build();
        ObjectMapper serializer = new ObjectMapper();
        try {
            return serializer.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

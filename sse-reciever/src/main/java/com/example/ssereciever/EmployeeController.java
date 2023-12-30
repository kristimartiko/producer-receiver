package com.example.ssereciever;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

    @RequestMapping(value = "/api/employees", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getAsyncData() {
        String uri = "http://localhost:8080/sse";
        return WebClient.create(uri)
                .get()
                .retrieve()
                .bodyToFlux(String.class);
    }

}

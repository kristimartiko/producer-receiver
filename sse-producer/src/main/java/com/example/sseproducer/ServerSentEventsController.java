package com.example.sseproducer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ServerSentEventsController {

    @RequestMapping("/sse")
    public @ResponseBody SseEmitter handle() {
        SseEmitter emitter = new SseEmitter();
        List<Employee> employees = getDummyEmployees();
        new Thread(() -> {
            for (Employee employee: employees) {
                try {
                    emitter.send(SseEmitter.event().name("Employee: ").data(employee));
                    Thread.sleep(200);
                } catch (IOException | InterruptedException e) {
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        }).start();
        return emitter;
    }

    public List<Employee> getDummyEmployees() {
        return List.of(
                new Employee("John", "Doe", "A873411"),
                new Employee("William", "Mark", "A74935"),
                new Employee("Henn", "Spark", "A546093"),
                new Employee("Tom", "Stark", "A32589"),
                new Employee("Massimilian", "Sweng", "A234897")
        );
    }
}

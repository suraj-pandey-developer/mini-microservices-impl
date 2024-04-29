package com.greet.api.controller;

import com.greet.api.client.WelcomeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//    @Autowired
    private WelcomeApiClient welcomeApiClient;

    @GetMapping("/greet")
    public String getGreetMessage() {
        String greetMsg = "Good Morning, " ;
//        String welcomeMsg = welcomeApiClient.invokeWelcomeApi();
//        return greetMsg+welcomeMsg;
        return greetMsg;
    }
}

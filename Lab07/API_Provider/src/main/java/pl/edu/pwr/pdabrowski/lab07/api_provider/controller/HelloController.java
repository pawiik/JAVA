package pl.edu.pwr.pdabrowski.lab07.api_provider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.pdabrowski.lab07.api_provider.service.HelloService;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;
    @GetMapping("/")
    public String hello(){
//        return helloService.hello();
    return "Hello";
    }

}

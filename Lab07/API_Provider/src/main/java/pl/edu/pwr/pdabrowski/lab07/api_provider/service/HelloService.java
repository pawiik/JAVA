package pl.edu.pwr.pdabrowski.lab07.api_provider.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello(){
        return "Hello";
    }
}

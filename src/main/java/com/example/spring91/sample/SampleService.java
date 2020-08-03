package com.example.spring91.sample;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class SampleService {
    public String getName() {
        return "keesun";
    }
}

package com.hew.demotest.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Testentity {

    private String name;
    private Integer age;
}

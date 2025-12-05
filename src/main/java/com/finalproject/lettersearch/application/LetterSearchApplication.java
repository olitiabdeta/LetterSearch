package com.finalproject.lettersearch.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.finalproject.lettersearch")
public class LetterSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetterSearchApplication.class, args);
    }

}

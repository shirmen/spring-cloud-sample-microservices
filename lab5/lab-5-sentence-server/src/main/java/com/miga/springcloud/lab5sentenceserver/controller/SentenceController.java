package com.miga.springcloud.lab5sentenceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sentence")
    public String getSentence() {

        return getWord("SUBJECT") + " "
                + getWord("VERB") + " "
                + getWord("ARTICLE") + " "
                + getWord("ADJECTIVE") + " "
                + getWord("NOUN") + ".";
    }

    public String getWord(String service) {
        return restTemplate.getForObject("http://" + service, String.class);
    }
}

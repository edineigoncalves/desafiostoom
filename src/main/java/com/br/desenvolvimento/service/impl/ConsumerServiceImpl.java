package com.br.desenvolvimento.service.impl;

import com.br.desenvolvimento.service.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerServiceImpl implements ConsumerService {

    private final String API_KEY = "";

    @Override
    public void getLongLatGoogle() {
        RestTemplate rest = new RestTemplate();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key="+API_KEY;
        ResponseEntity<String> response = rest.getForEntity(url, String.class);

        System.out.println( response.toString() );

    }


}

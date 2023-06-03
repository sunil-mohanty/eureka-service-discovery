package com.ski.spring.cloud.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {

    private static final String SERVICE_NAME = "eureka-service";

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("/ping")
    public String greeting(Model model) {

        InstanceInfo service = eurekaClient
          .getApplication(SERVICE_NAME)
          .getInstances()
          .get(0);

        String hostName = service.getHostName();
        int port = service.getPort();

        URI url = URI.create("http://" + hostName + ":" + port + "/ping");
        System.out.println("url :" + url);
        ResponseEntity<String> response = new RestTemplate().getForEntity(url, String.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}

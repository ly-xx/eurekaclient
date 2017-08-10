package com.example.demo.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxx
 * @version V1.0.0
 * @date 2017-8-9
 */

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/index")
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello：host:"+instance.getHost()+" port:"+instance.getPort()
                +" service_id:"+instance.getServiceId());
        return "hello world!";
    }
}

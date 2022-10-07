package com.client.ws.ws.rasmooplus.integration.impl;

import com.client.ws.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.client.ws.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.client.ws.ws.rasmooplus.integration.WsRaspayIntegration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private RestTemplate restTemplate;

    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        return null;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        return null;
    }

    @Override
    public Boolean proccessPayment(PaymentDto dto) {
        return null;
    }

}
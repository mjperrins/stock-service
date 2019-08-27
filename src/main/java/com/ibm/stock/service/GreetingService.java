package com.ibm.stock.service;

import com.ibm.stock.model.GreetingResponse;

public interface GreetingService {
    GreetingResponse getGreeting(String nameVariable);
}

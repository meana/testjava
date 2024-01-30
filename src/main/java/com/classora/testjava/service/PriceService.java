package com.classora.testjava.service;

import com.classora.testjava.dto.PriceResponse;
import java.time.LocalDateTime;

public interface PriceService {
    PriceResponse getPrice(Integer productId, Integer brandId, LocalDateTime date);
}

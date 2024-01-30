package com.classora.testjava.dto;

import java.time.LocalDateTime;

public record PriceResponse(
        Integer productId,
        Integer brandId,
        Integer priceList,
        LocalDateTime startDate,
        LocalDateTime endDate
) { }


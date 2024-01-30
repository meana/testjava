package com.classora.testjava.service.impl;

import com.classora.testjava.dto.PriceResponse;
import com.classora.testjava.mapper.PricesMapper;
import com.classora.testjava.model.Price;
import com.classora.testjava.repository.PriceRepository;
import com.classora.testjava.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;
    private final PricesMapper mapper;
    @Override
    public PriceResponse getPrice(Integer productId, Integer brandId, LocalDateTime date) {
        Price price = repository.findApplicablePrices(date, productId, brandId)
                .stream()
                .findFirst()
                .orElse(null);

        return mapper.priceToPriceResponse(price);

    }
}

package com.classora.testjava.mapper;

import com.classora.testjava.dto.PriceResponse;
import com.classora.testjava.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    PriceResponse priceToPriceResponse(Price price);
}

package com.classora.testjava.mapper;

import com.classora.testjava.dto.PriceResponse;
import com.classora.testjava.model.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    PriceResponse priceToPriceResponse(Prices price);
}

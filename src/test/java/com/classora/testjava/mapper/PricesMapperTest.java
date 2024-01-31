package com.classora.testjava.mapper;

import com.classora.testjava.dto.PriceResponse;
import com.classora.testjava.model.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PricesMapperTest {

    @Autowired
    PricesMapper mapper;
    @Test
    void mapperShouldProduceNotNullDto() {
        Prices price = new Prices(1L, 1, LocalDateTime.now(),
                LocalDateTime.now(), 1, 1, 1,
                BigDecimal.valueOf(2.5), "EUR");

        PriceResponse response = mapper.priceToPriceResponse(price);

        assertNotNull(response);
        assertEquals(response.brandId(), price.getBrandId());
        assertEquals(response.priceList(), price.getPriceList());
        assertEquals(response.productId(), price.getProductId());
        assertEquals(response.startDate(), price.getStartDate());
        assertEquals(response.endDate(), price.getEndDate());
    }
}

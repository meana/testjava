package com.classora.testjava.controller;

import com.classora.testjava.service.PriceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PriceControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private PriceController priceController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @ParameterizedTest
    @CsvSource({
            "35455, 1, '2020-06-14T10:00:00', 35.50",
            "35455, 1, '2020-06-14T16:00:00', 25.45",
            "35455, 1, '2020-06-14T21:00:00', 35.50",
            "35455, 1, '2020-06-15T10:00:00', 30.50",
            "35455, 1, '2020-06-16T21:00:00', 38.95"
    })
    void shouldRespondProperly(Integer productId, Integer brandId, String date, double expectedPrice) throws Exception {
        String url = String.format("/api/products/%d/prices?date=%s&brandId=%d", productId, date, brandId);

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(expectedPrice));
    }

    @Test
    void shouldFailInCaseOfWrongParameters() throws Exception {
        mockMvc.perform(get("/api/products/35455/prices?date=2020-06-14T10:00:00"))
                .andExpect(status().isBadRequest());
    }
}

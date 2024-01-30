package com.classora.testjava.controller;

import com.classora.testjava.dto.PriceResponse;
import com.classora.testjava.service.PriceService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@Validated
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/{productId}/prices")
    public ResponseEntity<?> getPrice(@PathVariable @NotNull Integer productId,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull LocalDateTime date,
                                       @RequestParam @NotNull Integer brandId) {

        PriceResponse response = priceService.getPrice(productId, brandId, date);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}

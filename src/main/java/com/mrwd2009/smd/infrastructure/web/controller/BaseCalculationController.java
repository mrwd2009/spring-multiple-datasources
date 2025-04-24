package com.mrwd2009.smd.infrastructure.web.controller;

import com.mrwd2009.smd.core.usecase.BaseCalculationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("${app.base-uri:/api}/base-calculation")
public class BaseCalculationController {
    private BaseCalculationUseCase baseCalculationUseCase;
    @GetMapping("calculate")
    public Boolean calculate() {
        baseCalculationUseCase.calculate();
        return true;
    }
}

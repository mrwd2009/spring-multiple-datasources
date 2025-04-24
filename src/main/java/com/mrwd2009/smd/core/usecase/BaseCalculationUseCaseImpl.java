package com.mrwd2009.smd.core.usecase;

import com.mrwd2009.smd.core.repository.contractmodel.DeftableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BaseCalculationUseCaseImpl implements BaseCalculationUseCase {
    private DeftableRepository deftableRepository;
    @Override
    public void calculate() {
        var def = deftableRepository.findById(10L);
        System.out.println(def.get());
    }
}

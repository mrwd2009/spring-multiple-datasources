package com.mrwd2009.smd.core.usecase;

import com.mrwd2009.smd.core.repository.contractmodel.DeftableRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseCalculationUseCaseImpl implements BaseCalculationUseCase {
    private final DeftableRepository deftableRepository;
    private static final Log logger = LogFactory.getLog(BaseCalculationUseCaseImpl.class);
    @PersistenceContext(unitName = "baseModelUnit")
    private EntityManager entityManager;
    @Override
    public void calculate() {
        var def = deftableRepository.findById(10L);
        var user = entityManager.createQuery("select b.id, b.version from BillingCycleEntity b").setMaxResults(1).getSingleResult();
        logger.info("test logger");
        System.out.println(user);
        System.out.println(def.get());
    }
}

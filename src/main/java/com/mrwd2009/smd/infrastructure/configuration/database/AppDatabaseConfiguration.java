package com.mrwd2009.smd.infrastructure.configuration.database;

import jakarta.persistence.EntityManagerFactory;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class AppDatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.base-model")
    public DataSource baseModel() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.contract-model")
    public DataSource contractModel() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.billing-model")
    public DataSource billingModel() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.global-meta")
    public DataSource globalMeta() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaProperties properties, ObjectProvider<PersistenceUnitManager> persistenceUnitManagers) {
        var vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(properties.isShowSql());
        vendorAdapter.setGenerateDdl(properties.isGenerateDdl());
        return new EntityManagerFactoryBuilder(vendorAdapter, source -> properties.getProperties(), persistenceUnitManagers.getIfAvailable());
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.mrwd2009.smd.core.repository.basemodel",
            entityManagerFactoryRef = "baseModelEntityManagerFactory",
            transactionManagerRef = "baseModelPTM"
    )
    public static class BaseModelJpa {
        @Bean()
        public LocalContainerEntityManagerFactoryBean baseModelEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("baseModel") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.mrwd2009.smd.core.entity.baseModel")
                    .persistenceUnit("baseModelUnit")
                    .build();
        }
        @Bean(name = "baseModelPTM")
        public PlatformTransactionManager baseModelPlatformTransactionManager(@Qualifier("baseModelEntityManagerFactory") EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }

        @Bean
        public SpringLiquibase baseModelLiquibase(@Qualifier("baseModel") DataSource dataSource) {
            var liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog("classpath:db/basemodel/master.xml");
            liquibase.setShouldRun(true);
            return liquibase;
        }
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.mrwd2009.smd.core.repository.contractmodel",
            entityManagerFactoryRef = "contractModelEntityManagerFactory",
            transactionManagerRef = "contractModelPTM"
    )
    public static class ContractModelJpa {
        @Bean()
        public LocalContainerEntityManagerFactoryBean contractModelEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("contractModel") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.mrwd2009.smd.core.entity.contractmodel")
                    .persistenceUnit("contractModelUnit")
                    .build();
        }
        @Bean(name = "contractModelPTM")
        public PlatformTransactionManager contractModelPlatformTransactionManager(@Qualifier("contractModelEntityManagerFactory") EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }

        @Bean
        public SpringLiquibase contractModelLiquibase(@Qualifier("contractModel") DataSource dataSource) {
            var liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog("classpath:db/contractmodel/master.xml");
            liquibase.setShouldRun(true);
            return liquibase;
        }
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.mrwd2009.smd.core.repository.billingmodel",
            entityManagerFactoryRef = "billingModelEntityManagerFactory",
            transactionManagerRef = "billingModelPTM"
    )
    public static class BillingModelJpa {
        @Bean()
        public LocalContainerEntityManagerFactoryBean billingModelEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("billingModel") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.mrwd2009.smd.core.entity.billingmodel")
                    .persistenceUnit("billingModelUnit")
                    .build();
        }
        @Bean(name = "billingModelPTM")
        public PlatformTransactionManager billingModelPlatformTransactionManager(@Qualifier("billingModelEntityManagerFactory") EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }

        @Bean
        public SpringLiquibase billingModelLiquibase(@Qualifier("billingModel") DataSource dataSource) {
            var liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog("classpath:db/billingmodel/master.xml");
            liquibase.setShouldRun(true);
            return liquibase;
        }
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.mrwd2009.smd.core.repository.globalmeta",
            entityManagerFactoryRef = "globalMetaEntityManagerFactory",
            transactionManagerRef = "globalMetaPTM"
    )
    public static class GlobalMetaJpa {
        @Bean()
        public LocalContainerEntityManagerFactoryBean globalMetaEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("globalMeta") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.mrwd2009.smd.core.entity.globalmeta")
                    .persistenceUnit("globalMetaUnit")
                    .build();
        }
        @Bean(name = "globalMetaPTM")
        public PlatformTransactionManager globalMetaPlatformTransactionManager(@Qualifier("globalMetaEntityManagerFactory") EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }

        @Bean
        public SpringLiquibase globalMetaLiquibase(@Qualifier("globalMeta") DataSource dataSource) {
            var liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog("classpath:db/globalmeta/master.xml");
            liquibase.setShouldRun(true);
            return liquibase;
        }
    }
}

package com.packtpub.hands.on.reactive.kotlin.chapter10.springdataexample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = CustomersRepository.class)
public class ApplicationConfiguration {
  @Bean
  @ConfigurationProperties(prefix = "example.datasource")
  DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder,
                                                              DataSource dataSource) {
    return factoryBuilder.dataSource(dataSource)
        .packages(Customer.class)
        .persistenceUnit("persistenceUnit")
        .build();
  }
}

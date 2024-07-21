package com.app.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.app.customer.Customer;
import com.app.customer.CustomerRepository;

import javax.transaction.Transactional;

@Configuration
public class LoadDatabase {

    @Bean
    @Transactional
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("Имя1", "email1@example.com"));
            customerRepository.save(new Customer("Имя2", "email2@example.com"));
        };
    }
}

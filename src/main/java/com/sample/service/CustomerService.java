package com.sample.service;

import com.sample.domain.CustomerEntity;
import com.sample.exception.BadRequestException;
import com.sample.model.Customer;
import com.sample.repository.CustomerJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Random;
@Slf4j
@Service
public class CustomerService {

    private final CustomerJpaRepository repository;

    public CustomerService(CustomerJpaRepository repository) {
        this.repository = repository;
    }

    public Long create(Customer customer) {

        if(repository.getByPhoneNumber(customer.getPhoneNumbers().get(0)) != null){
            throw new BadRequestException("Customer Phone number already registered!");
        }

        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(new Random().nextLong())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumbers().get(0))
                .type(customer.getType())
                .build();
        return repository.save(customerEntity).getId();
    }

    public Long update(Customer customer, Long id) {

        try{
            repository.getById(id);
        }catch (Exception ex){
            log.error("CustomerID:{} does not exist.", id);
            throw new BadRequestException(String.format("CustomerID:%s does not exist.", id));
        }

        if(customer.getPhoneNumbers() != null){
            throw new BadRequestException("Phone number is not updatable");
        }

        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(id)
                .name(customer.getName())
                .type(customer.getType())
                .build();
        return repository.save(customerEntity).getId();
    }

    public Customer retrieve(Long id) {
        CustomerEntity customerEntity;
        try{
            customerEntity = repository.getById(id);
        }catch (JpaObjectRetrievalFailureException | EntityNotFoundException ex ){
            log.error("CustomerID:{} does not exist.", id);
            throw new BadRequestException(String.format("CustomerID:%s does not exist.", id));
        }
        return Customer.builder()
                .id(String.valueOf(id))
                .name(customerEntity.getName())
                .phoneNumbers(Collections.singletonList(customerEntity.getPrimaryPhoneNumber()))
                .type(customerEntity.getType())
                .build();
    }

    public void deleteCustomer(Long id) {
        try{
            repository.deleteById(id);
        }catch (Exception ex){
            log.error("Unable to delete customer. Ex: ", ex);
            throw ex;
        }
    }
}

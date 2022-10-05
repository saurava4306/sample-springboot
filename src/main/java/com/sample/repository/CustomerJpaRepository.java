package com.sample.repository;

import com.sample.aspect.CustomerPhoneAlreadyRegisteredHandler;
import com.sample.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long>{
    @CustomerPhoneAlreadyRegisteredHandler
    @Query(value = "select * from CUSTOMERS where CUSTOMER_PHONE= :phoneNumber", nativeQuery = true)
    CustomerEntity getByPhoneNumber(String phoneNumber);
}

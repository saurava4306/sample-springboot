package srv.sxm.service;

import org.springframework.stereotype.Service;
import srv.sxm.domain.CustomerEntity;
import srv.sxm.exception.BadRequestException;
import srv.sxm.model.Customer;
import srv.sxm.repository.CustomerJpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Random;

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
            CustomerEntity existingCustomerEntity = repository.getById(id);
        }catch (Exception ex){
            throw new BadRequestException("CustomerID do not exists");
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
}

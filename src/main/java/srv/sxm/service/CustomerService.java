package srv.sxm.service;

import org.springframework.stereotype.Service;
import srv.sxm.model.Customer;
import srv.sxm.repository.CustomerRepository;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String create(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return repository.save(customer);
    }
}

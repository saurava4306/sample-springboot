package srv.sxm.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import srv.sxm.model.Customer;

@Component
public class CustomerRepository{
    private final MongoTemplate mongoTemplate;

    public CustomerRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String save(Customer customer) {
        return mongoTemplate.save(customer).getId();
    }
}

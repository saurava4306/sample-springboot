package srv.sxm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import srv.sxm.domain.CustomerEntity;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long>{
    @Query(value = "select * from CUSTOMERS where CUSTOMER_PHONE= :phoneNumber", nativeQuery = true)
    CustomerEntity getByPhoneNumber(String phoneNumber);
}

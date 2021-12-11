package srv.sxm.domain;

import srv.sxm.model.CustomerType;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @Column(name = "CUSTOMER_TYPE")
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @Column(name = "CUSTOMER_PHONE", nullable = false, length = 15, unique = true, updatable = false)
    private String primaryPhoneNumber;

    public Long getId() {
        return id;
    }

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String name, CustomerType type, String primaryPhoneNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public static CustomerEntity.CustomerEntityBuilder builder() {
        return new CustomerEntity.CustomerEntityBuilder();
    }

    public static class CustomerEntityBuilder {
        private Long id;
        private String name;
        private CustomerType type;
        private String phoneNumber;

        public CustomerEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public CustomerEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public CustomerEntityBuilder type(final CustomerType type) {
            this.type = type;
            return this;
        }

        public CustomerEntityBuilder phoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(this.id, this.name, this.type, this.phoneNumber);
        }


    }
}

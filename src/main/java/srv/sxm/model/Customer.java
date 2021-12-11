package srv.sxm.model;

import java.util.List;


public class Customer {
    private String name;
    private String id;
    private CustomerType type;
    private List<String> phoneNumbers;

    public Customer(String name, String id, CustomerType type, List<String> phoneNumbers) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.phoneNumbers = phoneNumbers;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

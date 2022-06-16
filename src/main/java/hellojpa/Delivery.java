package hellojpa;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipCode;
    private DeleveryStatus deleveryStatus;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}

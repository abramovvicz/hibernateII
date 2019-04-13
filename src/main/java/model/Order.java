package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order extends BasicEntity {

    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;
}

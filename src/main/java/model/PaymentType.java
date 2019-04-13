package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "payments_type")
public class PaymentType extends BasicEntity{

    @Column(name = "name",length = 40)
    private String name;

    @Column(name = "code",unique = true)
    private PaymentTypeCode code;

    @OneToMany(mappedBy = "paymentType")
    private List<Order> orders;
}

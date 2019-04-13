package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "payments_type")
public class PaymentType extends BasicEntity{

    @Column(name = "name",length = 40)
    private String name;

    @Column(name = "code",unique = true)
    private PaymentTypeCode code;
}

package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "order_details")
public class OrderDetails extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "copy_id",unique = true)
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}

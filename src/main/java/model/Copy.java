package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "copies")
public class Copy extends BasicEntity{

    @Column(name = "cost")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "format_id")
    private Format format;

    @OneToMany(mappedBy = "copy")
    private List<OrderDetails> orderDetails;

}
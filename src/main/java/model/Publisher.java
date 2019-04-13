package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher extends BasicEntity{

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email",unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "publisher")
    List<Book> bookList;
}

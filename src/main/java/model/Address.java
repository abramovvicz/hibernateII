package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends BasicEntity{

    @Column(name = "city",nullable = false,length = 40)
    private String city;

    @Column(name = "zip_code",nullable = false,length = 6)
    private String zipCode;

    @Column(name = "street", nullable = false,length = 50)
    private String street;

    @Column(name = "street_no",nullable = false,length = 10)
    private String streetNo;

    @Column(name = "home_no",length = 10)
    private String homeNo;

    @OneToMany(mappedBy = "address")
    private List<Publisher> publishers;

}

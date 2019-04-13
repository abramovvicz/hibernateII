package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends BasicEntity{

    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name="last_name",length = 50)
    private String lastName;

    @Column(name = "sex",length = 1)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "phone_number",length=11)
    private String phoneNumber;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "create_date",nullable = false)
    private LocalDateTime createDate;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}

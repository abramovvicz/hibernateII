package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BasicEntity{

    @Column(name = "name",nullable = false,length = 40) //varchar(40) not null
    private String name;

    @Column(name = "code",nullable = false,unique = true, length = 40)
    @Enumerated(EnumType.STRING)
    private CategoryCode code;

    @OneToMany(mappedBy = "category")
    List<Book> booksList;




}

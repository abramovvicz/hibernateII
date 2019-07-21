package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NamedQueries({



})


@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BasicEntity{

    @Column(name = "name",nullable = false,length = 40) //varchar(40) not null
    private String name;

    @Column(name = "code",nullable = false, unique = true, length = 40)
    @Enumerated(EnumType.STRING)
    private CategoryCode code;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)   // one to many - domyslnie lazy pobieraj zachłannie
    List<Book> booksList;


    //one to many - LAZY deafult
    //one to one - LAZY deafult
    //many to many - EAGER deafult
    // LAZY - czyli nie dociąga wszystkiego
    // eager - dociaga od razu wszystko



}

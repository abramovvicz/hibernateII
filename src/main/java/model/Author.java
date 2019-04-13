package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author extends BasicEntity{

    @Column(name = "first_name",length = 40,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 40,nullable = false)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "sex",length = 1)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @JoinTable(name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @ManyToMany
    private List<Book> books;
}

package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book extends BasicEntity {

    @Column(name = "title", nullable = false, length = 40)
    private String title;

    @Column(name = "pages_number")
    private int pagesNumber;

    @Column(name = "isbn")
    private Long isbn;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

}

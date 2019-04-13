package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "formats")
public class Format extends BasicEntity {

    @Column(name = "name", nullable = false,length = 40)
    private String name;

    @Column(name = "code", nullable = false,unique = true,length = 40)
    private String code;

    @OneToMany(mappedBy = "format")
    private List<Copy> copies;

}

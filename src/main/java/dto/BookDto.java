package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private Integer pagesNumber;


    public BookDto(Long id, String title, Integer pagesNumber) {
        this.id = id;
        this.title = title;
        this.pagesNumber = pagesNumber;
    }
}

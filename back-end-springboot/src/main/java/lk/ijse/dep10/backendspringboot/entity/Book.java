package lk.ijse.dep10.backendspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private String isbn;
    private String title;
}

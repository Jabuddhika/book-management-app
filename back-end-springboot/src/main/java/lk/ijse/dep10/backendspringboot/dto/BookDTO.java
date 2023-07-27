package lk.ijse.dep10.backendspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @NotBlank(message = "ISBN can't be empty")
    private String isbn;
    @NotBlank(message = "Title can't be empty")
    private String title;
}

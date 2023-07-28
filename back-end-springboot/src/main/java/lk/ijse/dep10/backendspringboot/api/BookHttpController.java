package lk.ijse.dep10.backendspringboot.api;

import lk.ijse.dep10.backendspringboot.business.custom.BookBO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookHttpController {

    private final BookBO bookBO;
    public BookHttpController(BookBO bookBO) {
        this.bookBO = bookBO;

    }


    @GetMapping
    public List<BookDTO> getAllBooks() throws Exception {
        System.out.println("get");
       return bookBO.getAllBooks();
   }

   @PostMapping(consumes = "application/json")
   @ResponseStatus(HttpStatus.CREATED)
   public void saveBook(@RequestBody @Valid BookDTO bookDTO) throws Exception {
      bookBO.saveBook(bookDTO);
   }
}

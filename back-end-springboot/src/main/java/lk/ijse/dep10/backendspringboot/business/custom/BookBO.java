package lk.ijse.dep10.backendspringboot.business.custom;

import lk.ijse.dep10.backendspringboot.dto.BookDTO;

import java.util.List;

public interface BookBO {

    List<BookDTO> getAllBooks() throws Exception;

    void saveBook(BookDTO bookDTO) throws Exception;
}

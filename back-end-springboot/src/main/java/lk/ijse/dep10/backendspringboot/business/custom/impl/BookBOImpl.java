package lk.ijse.dep10.backendspringboot.business.custom.impl;

import lk.ijse.dep10.backendspringboot.business.custom.BookBO;
import lk.ijse.dep10.backendspringboot.business.exception.DuplicateRecordException;
import lk.ijse.dep10.backendspringboot.business.util.Transformer;
import lk.ijse.dep10.backendspringboot.dao.custom.BookDAO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookBOImpl implements BookBO {

    private final Transformer transformer;

    private final BookDAO bookDAO;

    public BookBOImpl(Transformer transformer, BookDAO bookDAO) {
        this.transformer = transformer;
        this.bookDAO = bookDAO;
    }

    @Override
    public List<BookDTO> getAllBooks() throws Exception {
        return bookDAO.findAll().stream().map(transformer::fromBookEntity).collect(Collectors.toList());

    }

    @Override
    public void saveBook(BookDTO bookDTO) throws Exception {
        if (bookDAO.existsById(bookDTO.getIsbn())) {
            throw new DuplicateRecordException(bookDTO.getIsbn() + " already exists");
        }
        bookDAO.save(transformer.toBookEntity(bookDTO));
    }
}

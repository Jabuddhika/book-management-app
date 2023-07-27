package lk.ijse.dep10.backendspringboot.dao.util;

import lk.ijse.dep10.backendspringboot.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


public class Mapper {

 public static final RowMapper<Book>  BOOK_ROW_MAPPER=((rs, rowNum) -> {
  return new Book(rs.getString("isbn"), rs.getString("title"));
 });


}

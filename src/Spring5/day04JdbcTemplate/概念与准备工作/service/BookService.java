package Spring5.day04JdbcTemplate.概念与准备工作.service;

import Spring5.day04JdbcTemplate.概念与准备工作.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bookDao;

}

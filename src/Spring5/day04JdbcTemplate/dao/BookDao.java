package Spring5.day04JdbcTemplate.dao;

import Spring5.day04JdbcTemplate.entity.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);

    public void delete(String id);

    public void update(Book book);

    public int selectCount();


    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}

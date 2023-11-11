package com.wendy.jdbc.dao;

import com.wendy.jdbc.dao.po.BookPo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:16
 * @Version 1.0
 */
@Repository
public class BookRepositoryImpl implements BookRepository {
    @Resource
    private JdbcTemplate jdbc;

    @Override
    public Iterable<BookPo> queryBooks() {
        return jdbc.query("select * from t_book", this::mapRowToCategory);
    }

    @Override
    public BookPo queryBook(long id) {
        return jdbc.queryForObject("select id, book_name, author, publisher, published_date from t_book where id=?",
                this::mapRowToCategory, id);
    }

    @Override
    public void save(BookPo bookPo) {
        bookPo.setId(System.currentTimeMillis());
        String sql = "insert into t_book (id, book_name, author, publisher, published_date) values (?, ?, ?, ?, ?)";
        Object[] args = {bookPo.getId(), bookPo.getBookName(), bookPo.getAuthor(), bookPo.getPublisher(), bookPo.getPublishedDate()};
        jdbc.update(sql, args);
    }

    private BookPo mapRowToCategory(ResultSet rs, int rowNum) throws SQLException {
        return new BookPo(rs.getLong("id"), rs.getString("book_name"),
                rs.getString("author"), rs.getString("publisher"),
                rs.getDate("published_date"));
    }
}

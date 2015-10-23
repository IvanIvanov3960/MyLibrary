package com.softserve.academy.dao.book;

import java.util.List;

import com.softserve.academy.model.book.Book;

public interface BookDao {

	Integer addBook(Book book);

	void saveBook(Book book);

	void deleteBook(Integer bookID);

	List<Book> listBooks();

	Book findBookByID(Integer bookID);

}

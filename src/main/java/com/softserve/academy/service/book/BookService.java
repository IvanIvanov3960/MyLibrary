package com.softserve.academy.service.book;

import java.util.List;

import com.softserve.academy.model.book.Book;

public interface BookService {

	Integer addBook(Book book);

	void editBook(Book book);

	void deleteBook(Integer id);

	List<Book> listBook();

	Book findByID(Integer bookID);
}

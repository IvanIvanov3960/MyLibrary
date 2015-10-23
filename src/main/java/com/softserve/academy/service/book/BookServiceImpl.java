package com.softserve.academy.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.dao.book.BookDao;
import com.softserve.academy.model.book.Book;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
    BookDao dao;

	@Override
	public Integer addBook(Book book) {
		dao.addBook(book);
		return book.getBookId();
	}

	@Override
	public void editBook(Book book) {
		dao.saveBook(book);
	}

	@Override
	public void deleteBook(Integer id) {
		dao.deleteBook(id);
	}

	@Override
	public List<Book> listBook() {
		return dao.listBooks();
	}

	@Override
	public Book findByID(Integer bookID) {
		return dao.findBookByID(bookID);
	}

}

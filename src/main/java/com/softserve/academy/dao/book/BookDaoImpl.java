package com.softserve.academy.dao.book;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.academy.dao.AbstractDao;
import com.softserve.academy.model.book.Book;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

	@Override
	public void saveBook(Book book) {
		persist(book);

	}

	@Override
	public void deleteBook(Integer bookID) {
		Query query = getSession().createSQLQuery("delete from books where book_id = :id");
		query.setInteger("id", bookID);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		Criteria criteria = createEntityCriteria();
		List<Book> books = (List<Book>) criteria.list();
		for(Book user : books){
            Hibernate.initialize(user.getAuthor());
        }
		return books;
	}

	@Override
	public Integer addBook(Book book) {
		String queryStr = "insert into books values(" + book.getBookId() + ", " + book.getBookName() + ", " 
	+ book.getAuthor() + ", " + book.isStatus();
		Query query = getSession().createSQLQuery(queryStr);
		query.executeUpdate();
		return book.getBookId();
	}

	@Override
	public Book findBookByID(Integer bookID) {
		Book book = getByKey(bookID);
		if (book != null) {
			Hibernate.initialize(book.getAuthor());
		}
		return book;
//		Query query = getSession().createSQLQuery("select from books where book_id = :id");
//		query.setInteger("id", bookID);
//		query.executeUpdate();
//		return findBookByID(bookID);
	}

}

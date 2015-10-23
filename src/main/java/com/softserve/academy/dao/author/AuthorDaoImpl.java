package com.softserve.academy.dao.author;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.academy.dao.AbstractDao;
import com.softserve.academy.model.author.Author;
import com.softserve.academy.model.book.Book;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDao<Integer, Book> implements AuthorDao {

	@Override
	public Integer addAuthor(Author author) {
		String queryStr = "insert into book values(" + author.getAuthorID() + ", " + author.getAuthorName() + ", "
				+ author.getAuthorCountry();
		Query query = getSession().createSQLQuery(queryStr);
		query.executeUpdate();
		return author.getAuthorID();
	}

	@Override
	public void deleteAuthor(int id) {
//		Author author = findById(author.getAuthorID());
		Query query = getSession().createSQLQuery("delete from author where author_id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Author> listAuthor() {
		Criteria criteria = createEntityCriteria();
		return (List<Author>) criteria.list();
	}

	@Override
	public Author findById(Integer id) {
		Author author = findById(id);
        if(author!=null){
            Hibernate.initialize(author.getBooks());
        }
        return author;
	}

	@Override
	public void editAuthor(int id) {
		Author entity = findById(id);

		if (entity != null) {
			entity.setAuthorName(entity.getAuthorName());
			entity.setAuthorCountry(entity.getAuthorCountry());
			entity.setBooks(entity.getBooks());
		}
		
	}

}

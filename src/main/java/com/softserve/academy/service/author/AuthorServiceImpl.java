package com.softserve.academy.service.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.dao.author.AuthorDao;
import com.softserve.academy.model.author.Author;


@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
    AuthorDao dao;

	@Override
	public void addAuthor(Author author) {
		dao.addAuthor(author);
	}

	@Override
	public void editAuthor(Author author) {
		dao.editAuthor(author.getAuthorID());
	}

	@Override
	public void deleteAuthor(Integer id) {
		dao.deleteAuthor(id);
	}

	@Override
	public List<Author> listAuthor() {
		return dao.listAuthor();
	}

	@Override
	public Author findByID(Integer id) {
		return dao.findById(id);
	}

}

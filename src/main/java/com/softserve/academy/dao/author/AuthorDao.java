package com.softserve.academy.dao.author;

import java.util.List;

import com.softserve.academy.model.author.Author;

public interface AuthorDao {
	
	Author findById(Integer id);

	Integer addAuthor(Author author);

	void deleteAuthor(int id);

	List<Author> listAuthor();

	void editAuthor(int id);

}

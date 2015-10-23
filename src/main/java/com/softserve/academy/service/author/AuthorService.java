package com.softserve.academy.service.author;

import java.util.List;

import com.softserve.academy.model.author.Author;

public interface AuthorService {

	void addAuthor(Author author);

	void editAuthor(Author author);

	void deleteAuthor(Integer id);

	List<Author> listAuthor();

	Author findByID(Integer authorID);
}

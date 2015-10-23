package com.softserve.academy.model.author;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.softserve.academy.model.book.Book;

@Entity
@Table(name="author")
public class Author {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorID;
	
	@Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;
	
	@Size(min=3, max=50)
    @Column(name = "COUNTRY", nullable = false)
    private String country;
	
	@Autowired
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderColumn(name = "book_id")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return name;
	}

	public void setAuthorName(String name) {
		this.name = name;
	}

	public String getAuthorCountry() {
		return country;
	}

	public void setAuthorCountry(String country) {
		this.country = country;
	}
	
	
	
}

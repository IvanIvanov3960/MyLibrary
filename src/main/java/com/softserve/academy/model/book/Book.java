package com.softserve.academy.model.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.softserve.academy.model.author.Author;


@Entity
@Table(name="book")
public class Book {
	@Id
	@Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
	
	@Size(min=3, max=50)
    @Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "author_id")
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getBookId() {
		return bookID;
	}

	public void setBookId(int id) {
		this.bookID = id;
	}
	
	public String getBookName() {
		return name;
	}

	public void setBookName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}

package com.softserve.academy.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.model.author.Author;
import com.softserve.academy.model.book.Book;
import com.softserve.academy.service.author.AuthorService;
import com.softserve.academy.service.book.BookService;

@Controller
@RequestMapping(value = "/authors/{id}")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;

	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/allbooks" }, method = RequestMethod.GET)
    public String listBooks(@PathVariable Integer id, ModelMap model){
		Author author = authorService.findByID(id);
		List<Book> books = author.getBooks();
		
		model.addAttribute("books", books);
		model.addAttribute("author", author);
		
		return "allbooks";
		
	}
	
	@RequestMapping(value = { "/books/new" }, method = RequestMethod.GET)
	public String addNewBook(ModelMap model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("edit", false);

		return "books/addNewBook";
	}

	@RequestMapping(value = { "/books/new" }, method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult result, ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "books/addNewBook";
		}

		Author author = authorService.findByID(id);
		author.getBooks().add(book);
		book.setAuthor(author);
		bookService.addBook(book);
		
		return "redirect:/authors/{id}/books";
	}

	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.GET)
	public String editBook(@PathVariable Integer id, @PathVariable int book_id, ModelMap model) {
		Book book = bookService.findByID(book_id);
		Author author = book.getAuthor();
		
		model.addAttribute("book", book);
		model.addAttribute("author", author);
		model.addAttribute("edit", true);

		return "books/addNewBook";
	}
	
	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.PUT)
	public String updateBook(@Valid Book formBook, BindingResult result, ModelMap model, @PathVariable Integer id,
			@PathVariable Integer book_id) {

		if (result.hasErrors()) {
			return "books/addNewBook";
		}
		
		Author author = authorService.findByID(id);
		Book  dbBook = bookService.findByID(book_id);
		
		dbBook = formBook;

		bookService.editBook(dbBook);
		author.getBooks().add(dbBook);

		
		return "redirect:/authors/{id}/books";
	}
	
	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable int id, @PathVariable int book_id) {
		Book book = bookService.findByID(book_id);
		Author author = authorService.findByID(id);
		
		author.getBooks().remove(book);
		bookService.deleteBook(id);
		
		return "redirect:/authors/{id}/books/";
	}
}

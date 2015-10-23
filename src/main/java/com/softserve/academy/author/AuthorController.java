package com.softserve.academy.author;

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
import com.softserve.academy.service.author.AuthorService;


@Controller
@RequestMapping({ "/authors" })
public class AuthorController {

	@Autowired
	AuthorService service;

	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing authors.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listAllAuthors(ModelMap model) {
		List<Author> authors = service.listAuthor();
		model.addAttribute("authors", authors);

		return "authors/all";
	}

	/*
	 * This method will provide the medium to add a new author.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String addNewAuthor(ModelMap model) {
		Author author = new Author();
		model.addAttribute("author", author);
		model.addAttribute("edit", false);
		model.addAttribute("countries", author.getAuthorCountry());
		
		return "authors/addNewAuthor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving author in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveAuthor(@Valid Author author, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "authors/addNewAuthor";
		}

		service.addAuthor(author);
		
		return "redirect:/authors/";
	}

	/*
	 * This method will provide the medium to update an existing author.
	 */
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public String editAuthor(@PathVariable int id, ModelMap model) {
		Author author = service.findByID(id);
		model.addAttribute("author", author);
		model.addAttribute("edit", true);

		return "authors/addNewAuthor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating author in database. It also validates the user input
	 */
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public String updateAuthor(@Valid Author author, BindingResult result, ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "authors/addNewAuthor";
		}

		service.editAuthor(author);

		return "redirect:/authors/";
	}

	/*
	 * This method will delete an author by it's ID value.
	 */
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public String deleteAuthor(@PathVariable int id) {
		service.deleteAuthor(id);

		return "redirect:/authors/";
	}
}
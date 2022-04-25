package com.example.mongoBookStore.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoBookStore.model.Book;
import com.example.mongoBookStore.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/addBook")
	private String saveBook(@RequestBody Book book) {
		long start = System.currentTimeMillis();
		bookRepository.save(book);
		long end = System.currentTimeMillis();
		System.out.println("Save time for one record: " + (end-start));
		return "Added book with id : "+book.getId();
	}

	@PostMapping("/addBooks")
	private String saveBooks(@RequestBody List<Book> books) {
		long start = System.currentTimeMillis();
		bookRepository.saveAll(books);
		long end = System.currentTimeMillis();
		System.out.println("Save time for all records : " + (end-start));
		return "Added books";
	}

	@GetMapping("/findAllBooks")
	public List getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findBook/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		long start = System.currentTimeMillis();
		bookRepository.findById(id);
		long end = System.currentTimeMillis();
		System.out.println("Fetch time for one record: " + (end-start));
		return bookRepository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		long start = System.currentTimeMillis();
		bookRepository.deleteById(id);
		long end = System.currentTimeMillis();
		System.out.println("Time to Delete one record : " + (end-start));
		return "Book Deleted with id : "+id;
	}
	@DeleteMapping("/deleteAll")
	public String deleteBooks() {
		long start = System.currentTimeMillis();
		bookRepository.deleteAll();
		long end = System.currentTimeMillis();
		System.out.println("Time to Delete all records : " + (end-start));
		return "Deleted All Books";
	}
}

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
		bookRepository.save(book);
		return "Added book with id : "+book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		bookRepository.findById(id);
		return bookRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		 bookRepository.deleteById(id);
		 return "Book Deleted with id : "+id;
	}
}

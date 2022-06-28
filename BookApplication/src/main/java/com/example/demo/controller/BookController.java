package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.DataNotFoundException;
import com.example.demo.bookentity.BookEntity;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody BookEntity bookEntity) throws DataNotFoundException
	{
		BookEntity entity = bookService.saveBook(bookEntity);
		return "Book Added with Id: "+entity.getId();
	}
	
	@GetMapping("/getBookById")
	public String getBookById(@RequestParam("id") Integer id) throws DataNotFoundException {
		BookEntity bookEntity =  bookService.getBookById(id);
		return "Book Details with Id: "+ bookEntity.getId() + " Author: " + bookEntity.getAuthor() 
		+  " Title: " + bookEntity.getTitle() +  " Price: " + bookEntity.getPrice();
	}

	@DeleteMapping("/deleteBookById")
	public String deleteBook(@RequestParam("id") Integer id) throws DataNotFoundException {
		bookService.deleteBookById(id);
		return "Book Deleted with Id: "+id;
	}
	
	@PutMapping("/updateBookById")
	public String updateBook(@RequestParam("id") Integer id, @RequestBody BookEntity bookEntity) throws DataNotFoundException {
		Integer id1 = bookService.updateBookById(id , bookEntity);
		return "Book updated with Id: "+id1;
	}
	
	@GetMapping("/getBookByPrice")
	public List<BookEntity> getBookByPrice(@RequestParam("price") Double price) throws DataNotFoundException {
		List<BookEntity> bookEntity =  bookService.getBookByPrice(price);
		return bookEntity;
	}

}

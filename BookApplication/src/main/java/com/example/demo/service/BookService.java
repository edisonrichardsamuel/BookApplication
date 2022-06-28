package com.example.demo.service;

import java.util.List;

import com.example.demo.Exceptions.DataNotFoundException;
import com.example.demo.bookentity.BookEntity;

public interface BookService {

	public BookEntity saveBook(BookEntity bookEntity) throws DataNotFoundException;

	public BookEntity getBookById(Integer id) throws DataNotFoundException;

	public void deleteBookById(Integer id) throws DataNotFoundException;

	public Integer updateBookById(Integer id, BookEntity bookEntity) throws DataNotFoundException;

	public List<BookEntity> getBookByPrice(Double price) throws DataNotFoundException;

}

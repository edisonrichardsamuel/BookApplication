package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.DataNotFoundException;
import com.example.demo.bookentity.BookEntity;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public BookEntity saveBook(BookEntity bookEntity) throws DataNotFoundException
	{
		BookEntity entity = bookRepo.save(bookEntity);
		if(entity.getId()==null)
		{
			throw new DataNotFoundException("Book not added successfully ID: "+bookEntity.getId());
		}
		else
		{
			return entity;
		}
	}
	
	@Override
	public BookEntity getBookById(Integer id) throws DataNotFoundException
	{
		Optional<BookEntity> entity = bookRepo.findById(id);
		if(entity.isEmpty())
		{
			throw new DataNotFoundException("No Book is found with ID: "+id);
		}
		else
		{
			return entity.get();
		}
	}
	
	@Override
	public void deleteBookById(Integer id) throws DataNotFoundException
	{
		bookRepo.deleteById(id);
	}
	
	@Override
	public Integer updateBookById(Integer id, BookEntity bookEntity) throws DataNotFoundException
	{
		Optional<BookEntity> entity = bookRepo.findById(id);
		if(entity.isEmpty())
		{
			throw new DataNotFoundException("No Book is found with ID: "+id+" to update");
		}
		else
		{
			@SuppressWarnings("deprecation")
			BookEntity bookEntity1 = bookRepo.getById(id);
			bookEntity1.setTitle(bookEntity.getTitle());
			bookEntity1.setAuthor(bookEntity.getAuthor());
			return bookRepo.save(bookEntity1).getId();
		}
	}

	@Override
	public List<BookEntity> getBookByPrice(Double price) throws DataNotFoundException {
		
		List<BookEntity> bookList = bookRepo.getBookByPrice(price);
		if(bookList.isEmpty())
		{
			throw new DataNotFoundException("No Book is found with Price Greater than "+price);
		}
		else
		{
			return bookList;
		}
	}

}

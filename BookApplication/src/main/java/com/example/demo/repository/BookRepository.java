package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bookentity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

	@Query(value = "select * from book_entity where price>?1",nativeQuery = true)
	public List<BookEntity> getBookByPrice(Double price);

}

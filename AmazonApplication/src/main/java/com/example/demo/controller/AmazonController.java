package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Exceptions.DataNotFoundException;
import com.example.demo.utils.BookEntity;

@RestController
public class AmazonController {
	
	@GetMapping("/getBookDetailsById")
	public String getBookDetails(@RequestParam Integer id) throws DataNotFoundException {
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		String entity2 = restTemplate.exchange("http://localhost:8081/getBookById?id="+id, HttpMethod.GET,entity,String.class).getBody();
		return entity2;
	}
	
	@PostMapping("/addBookDetails")
	public String addBookDetails(@RequestBody BookEntity bookEntity) throws DataNotFoundException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookEntity> entity = new HttpEntity<BookEntity>(bookEntity,headers);
		RestTemplate restTemplate = new RestTemplate();
		String entity2 = restTemplate.exchange("http://localhost:8081/addBook", HttpMethod.POST,entity,String.class).getBody();
		return entity2;
	}
	
	@DeleteMapping("/deleteBookDetailsById")
	public String deleteBookDetails(@RequestParam("id") Integer id) throws DataNotFoundException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		String entity2 = restTemplate.exchange("http://localhost:8081/deleteBookById?id="+id, HttpMethod.DELETE,entity,String.class).getBody();
		return entity2;
	}
	
	@PutMapping("/updateBookDetails")
	public String updateBookDetails(@RequestParam("id") Integer id, @RequestBody BookEntity bookEntity) throws DataNotFoundException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookEntity> entity = new HttpEntity<BookEntity>(bookEntity,headers);
		RestTemplate restTemplate = new RestTemplate();
		String entity2 = restTemplate.exchange("http://localhost:8081/updateBookById?id="+id, HttpMethod.PUT,entity,String.class).getBody();
		return entity2;
	}

}

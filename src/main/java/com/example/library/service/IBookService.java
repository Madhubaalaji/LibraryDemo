package com.example.library.service;

import com.example.library.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface IBookService {

    public List<Book> getAllBooks();
    public Optional<Book> getBookByIsbn(Integer isbn);
    public String addBook(Book book);
    public void deleteBook(Integer id);
}

package com.example.library.service;

import com.example.library.data.BookRepository;
import com.example.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addBook(Book book) {
        Book bookadded = bookRepository.save(book);
        System.out.println("bookadded = " + bookadded);
        return "Book added/updated successfully";
    }

    @Override
    public void deleteBook(Integer isbn) {
        bookRepository.deleteById(isbn);
    }

    @Override
    public Optional<Book> getBookByIsbn(Integer isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}

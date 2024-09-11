package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBook")
    public Optional<Book> getBook(@RequestParam Integer isbn)
    {
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody @Valid Book book)
    {
       return bookService.addBook(book);
    }

    @PutMapping("/updatebook")
    public String updateBook(@RequestBody @Valid Book book)
    {
        Optional<Book> b = bookService.getBookByIsbn(book.getIsbn());
        Book bb=null;
        System.out.println("b = " + b);
        if(b.isPresent()){
            bb = b.get();
            bb.setBookName(book.getBookName());
            bb.setAuthorName(book.getAuthorName());
        }
        return bookService.addBook(bb);
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam Integer isbn)
    {
        Optional<Book> b = bookService.getBookByIsbn(isbn);
        if(b.isPresent())
        {
            bookService.deleteBook(isbn);
        }
        else
        {
            System.out.println("No record found");
        }
    }
}

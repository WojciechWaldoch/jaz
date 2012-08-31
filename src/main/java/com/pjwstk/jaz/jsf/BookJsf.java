
package com.pjwstk.jaz.jsf;

import com.pjwstk.jaz.domain.Book;
import com.pjwstk.jaz.ejb.BookService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class BookJsf implements Serializable {
    
    private ListDataModel<Book> books = new ListDataModel<Book>();
    private Book book;
    
    @Inject
    private BookService bookEjb; 
    
    public ListDataModel<Book> getBooks() {
        books.setWrappedData(bookEjb.getBooks());
        return books;
    }

    public Book getBook() {
        if(book == null){ book = new Book(); }
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public String show() {
        book = books.getRowData();
        return "show";
    }
    
    public String add() {
        return "add";
    }
    
    public String edit() {
        book = books.getRowData();
        return "edit";
    }
    
    public String delete() {
        book = books.getRowData();
        bookEjb.delete(book);
        return "all";
    }
    
    public String merge() {
        bookEjb.merge(book);
        return "all";
    }
}

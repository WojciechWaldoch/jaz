
package com.pjwstk.jaz.ejb;

import com.pjwstk.jaz.domain.Book;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named
public class BookService {

    @PersistenceContext(unitName = "jaz_JPU")
    private EntityManager em;
    
    public List<Book> getBooks() {
        return em.createQuery("select b from Book b").getResultList();
    }
    
    public void delete(Book book) {
        book = em.merge(book);
        em.remove(book);
    }
 
    public void merge(Book book) {
        em.merge(book);
    }
   
}

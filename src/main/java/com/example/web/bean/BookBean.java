package com.example.web.bean;

import com.example.web.dao.JPAUtil;
import com.example.web.entity.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class BookBean implements Serializable {

    private Book book = new Book();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void save(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(this.book);
        em.getTransaction().commit();
        em.close();
        System.out.println("Salvo");
    }
}

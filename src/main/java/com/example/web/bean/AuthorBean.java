package com.example.web.bean;

import com.example.web.dao.DAO;
import com.example.web.dao.JPAUtil;
import com.example.web.entity.Author;


import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class AuthorBean implements Serializable {

    private Author author = new Author();


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getAuthors(){
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select a from Author a";
        TypedQuery<Author> query = em.createQuery(consult, Author.class);
        return query.getResultList();
    }

    public void save(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(this.author);
        em.getTransaction().commit();
        em.close();
        System.out.println("Salvo");
    }

    public static void main(String[] args) {
        AuthorBean bean = new AuthorBean();
        System.out.println(bean.getAuthors());
    }
}

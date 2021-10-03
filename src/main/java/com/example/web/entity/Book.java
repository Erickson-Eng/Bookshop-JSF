package com.example.web.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "book")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Book implements Serializable {
    private static final long serialVersionUID = 7364825695099242150L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String ISBN;
    private Double price;

    @JoinTable(name = "book_authorList",
            joinColumns = @JoinColumn(name = "bookList_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authorList_id", referencedColumnName = "id"))
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Author> authorList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}